# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 16:36:26 2011

@author: ProfMobius & Searge
@version: v1.2
"""

import sys
if sys.version_info[0] == 3:
    print('ERROR : Python3 is not supported yet.')
    sys.exit(1)

import warnings
warnings.simplefilter('ignore')

import fnmatch
import logging
import os
import shutil
import zipfile
import csv
import re
import subprocess
import ConfigParser
import urllib
import time
import stat
from hashlib import md5
from contextlib import closing

from filehandling.srgsexport import writesrgsfromcsvs
from pylibs.annotate_gl_constants import annotate_file
from pylibs.whereis import whereis


CLIENT = 0
SERVER = 1
SIDE_NAME = {CLIENT: 'client', SERVER: 'server'}


class Error(Exception):
    pass


class CalledProcessError(Error):
    def __init__(self, returncode, cmd, output=None):
        super(CalledProcessError, self).__init__()
        self.returncode = returncode
        self.cmd = cmd
        self.output = output

    def __str__(self):
        return "Command '%s' returned non-zero exit status %d" % (self.cmd, self.returncode)


def reallyrmtree(path):
    i = 0
    try:
        while os.stat(path) and i < 20:
            shutil.rmtree(path, onerror=rmtree_onerror)
            i += 1
    except OSError:
        pass
    # raise OSError if the path still exists even after trying really hard
    try:
        os.stat(path)
    except OSError:
        pass
    else:
        raise OSError


def rmtree_onerror(func, path, _):
    if not os.access(path, os.W_OK):
        os.chmod(path, stat.S_IWUSR)
    time.sleep(0.5)
    try:
        func(path)
    except OSError:
        pass


def filterdirs(src_dir, pattern=None, ignore_dirs=None, append_pattern=False):
    """Return list of subdirs containing given file pattern filtering out ignored dirs"""
    # avoid problems with mutable default parameters
    if ignore_dirs is None:
        ignore_dirs = []
    dirs = []
    for path, dirlist, filelist in os.walk(src_dir, followlinks=True):
        sub_dir = os.path.relpath(path, src_dir)
        for cur_dir in dirlist:
            if os.path.normpath(os.path.join(sub_dir, cur_dir)) in ignore_dirs:
                # if the full subdir is in the ignored package list delete it so that we don't descend into it
                dirlist.remove(cur_dir)
        if pattern is None:
            dirs.append(path)
        elif fnmatch.filter(filelist, pattern):
            if append_pattern:
                dirs.append(os.path.join(path, pattern))
            else:
                dirs.append(path)
    return dirs


def normaliselines(in_filename, out_filename):
    with open(in_filename, 'rb') as in_file:
        with open(out_filename, 'wb') as out_file:
            buf = in_file.read()
            if os.linesep == '\r\n':
                buf = re.sub(r'\r?\n', r'\r\n', buf)
            else:
                buf = buf.replace('\r\n', '\n')
            out_file.write(buf)


class Commands(object):
    """Contains the commands and initialisation for a full mcp run"""

    MCPVersion = '5.6'
    _instance = None  # Small trick to create a singleton
    _single = False   # Small trick to create a singleton
    _default_config = 'conf/mcp.cfg'
    _version_config = 'conf/version.cfg'

    @classmethod
    def MCPFullVersion(cls):
        """Read the version configuration file and return a full version string"""
        full_version = None
        try:
            config = ConfigParser.SafeConfigParser()
            with open(os.path.normpath(cls._version_config)) as fh:
                config.readfp(fh)
            config.read(os.path.normpath(cls._version_config))
            data_version = config.get('VERSION', 'MCPVersion')
            client_version = config.get('VERSION', 'ClientVersion')
            server_version = config.get('VERSION', 'ServerVersion')
            full_version = ' (data: %s, client: %s, server: %s)' % (data_version, client_version, server_version)
        except IOError:
            pass
        except ConfigParser.Error:
            pass

        if full_version is None:
            return cls.MCPVersion
        else:
            return cls.MCPVersion + full_version

    def __init__(self, conffile=None):
        # HINT: This is for the singleton pattern. If we already did __init__, we skip it
        if Commands._single:
            return
        if not Commands._single:
            Commands._single = True

        self.conffile = conffile
        self.readconf()
        self.checkfolders()
        self.startlogger()
        self.logger.info('== MCP %s ==' % Commands.MCPFullVersion())

        if 'linux' in sys.platform:
            self.osname = 'linux'
        elif 'darwin' in sys.platform:
            self.osname = 'osx'
        elif sys.platform[0:3] == 'win':
            self.osname = 'win'
        else:
            self.logger.error('OS not supported : %s' % sys.platform)
            sys.exit(1)
        self.logger.debug('OS : %s' % sys.platform)

        self.checkjava()
        self.readcommands()

    # HINT: This is for the singleton pattern. We either create a new instance or return the current one
    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(Commands, cls).__new__(cls, *args, **kwargs)
        return cls._instance

    def readcommands(self):
        self.patcher = os.path.normpath(self.config.get('COMMANDS', 'Patcher_%s' % self.osname))
        self.jad = os.path.normpath(self.config.get('COMMANDS', 'Jad_%s' % self.osname))
        self.astyle = os.path.normpath(self.config.get('COMMANDS', 'AStyle_%s' % self.osname))
        self.jadretro = os.path.normpath(self.config.get('COMMANDS', 'JadRetro'))
        self.fernflower = os.path.normpath(self.config.get('COMMANDS', 'Fernflower'))
        self.exceptor = os.path.normpath(self.config.get('COMMANDS', 'Exceptor'))

        self.cmdpatch = self.config.get('COMMANDS', 'CmdPatch', raw=1) % self.patcher
        self.cmdjad = self.config.get('COMMANDS', 'CmdJad', raw=1) % self.jad
        self.cmdastyle = self.config.get('COMMANDS', 'CmdAStyle', raw=1) % self.astyle
        self.cmdrg = self.config.get('COMMANDS', 'CmdRG', raw=1) % self.cmdjava
        self.cmdrgreobf = self.config.get('COMMANDS', 'CmdRGReobf', raw=1) % self.cmdjava
        self.cmdjadretro = self.config.get('COMMANDS', 'CmdJadretro', raw=1) % (self.cmdjava, self.jadretro)
        self.cmdfernflower = self.config.get('COMMANDS', 'CmdFernflower', raw=1) % (self.cmdjava, self.fernflower)
        self.cmdexceptor = self.config.get('COMMANDS', 'CmdExceptor', raw=1) % (self.cmdjava, self.exceptor)
        self.cmdrecomp = self.config.get('COMMANDS', 'CmdRecomp', raw=1) % self.cmdjavac
        self.cmdstartsrv = self.config.get('COMMANDS', 'CmdStartSrv', raw=1) % self.cmdjava
        self.cmdstartclt = self.config.get('COMMANDS', 'CmdStartClt', raw=1) % self.cmdjava

    def startlogger(self):
        self.logger = logging.getLogger('MCPLog')
        self.logger.setLevel(logging.DEBUG)
        # create file handler which logs even debug messages
        filehandler = logging.FileHandler(filename=self.mcplogfile)
        filehandler.setLevel(logging.DEBUG)
        # create console handler with a higher log level
        consolehandler = logging.StreamHandler()
        consolehandler.setLevel(logging.INFO)
        # File output of everything Warning or above
        errorhandler = logging.FileHandler(filename=self.mcperrlogfile)
        errorhandler.setLevel(logging.WARNING)
        # create formatter and add it to the handlers
        formatterconsole = logging.Formatter('%(message)s')
        consolehandler.setFormatter(formatterconsole)
        formatterfile = logging.Formatter('%(asctime)s - %(message)s', datefmt='%H:%M:%S')
        filehandler.setFormatter(formatterfile)
        errorhandler.setFormatter(formatterfile)
        # add the handlers to logger
        self.logger.addHandler(consolehandler)
        self.logger.addHandler(filehandler)
        self.logger.addHandler(errorhandler)

        # HINT: SECONDARY LOGGER FOR CLIENT & SERVER
        self.loggermc = logging.getLogger('MCRunLog')
        self.loggermc.setLevel(logging.DEBUG)
        chmc = logging.StreamHandler()
        chmc.setLevel(logging.DEBUG)
        formatterconsolemc = logging.Formatter('[%(asctime)s] %(message)s', datefmt='%H:%M:%S')
        chmc.setFormatter(formatterconsolemc)
        # add the handlers to logger
        self.loggermc.addHandler(chmc)

    def readconf(self):
        """Read the configuration file to setup some basic paths"""
        config = ConfigParser.SafeConfigParser()
        with open(os.path.normpath(self._default_config)) as fh:
            config.readfp(fh)
        if self.conffile is not None:
            config.read(os.path.normpath(self.conffile))
        self.config = config

        # HINT: We read the directories for cleanup
        self.dirtemp = os.path.normpath(config.get('DEFAULT', 'DirTemp'))
        self.dirsrc = os.path.normpath(config.get('DEFAULT', 'DirSrc'))
        self.dirlogs = os.path.normpath(config.get('DEFAULT', 'DirLogs'))
        self.dirbin = os.path.normpath(config.get('DEFAULT', 'DirBin'))
        self.dirjars = os.path.normpath(config.get('DEFAULT', 'DirJars'))
        self.dirreobf = os.path.normpath(config.get('DEFAULT', 'DirReobf'))
        self.dirlib = os.path.normpath(config.get('DEFAULT', 'DirLib'))
        self.dirffout = os.path.normpath(config.get('DEFAULT', 'DirFFOut'))
        self.dirmodsrc = os.path.normpath(config.get('DEFAULT', 'DirModSrc'))

        # HINT: We read the position of the CSV files
        self.csvclasses = os.path.normpath(config.get('CSV', 'Classes'))
        self.csvmethods = os.path.normpath(config.get('CSV', 'Methods'))
        self.csvfields = os.path.normpath(config.get('CSV', 'Fields'))

        # HINT: We read the names of the SRG output
        self.srgsclient = os.path.normpath(config.get('SRGS', 'Client'))
        self.srgsserver = os.path.normpath(config.get('SRGS', 'Server'))

        # HINT: We read the position of the jar files
        self.dirnatives = os.path.normpath(config.get('JAR', 'DirNatives'))
        self.jarclient = os.path.normpath(config.get('JAR', 'Client'))
        self.jarserver = os.path.normpath(config.get('JAR', 'Server'))
        self.md5jarclt = config.get('JAR', 'MD5Client')
        self.md5jarsrv = config.get('JAR', 'MD5Server')

        # HINT: We read keys relevant to retroguard
        self.retroguard = os.path.normpath(config.get('RETROGUARD', 'Location'))
        self.rgconfig = os.path.normpath(config.get('RETROGUARD', 'RetroConf'))
        self.rgclientconf = os.path.normpath(config.get('RETROGUARD', 'ClientConf'))
        self.rgserverconf = os.path.normpath(config.get('RETROGUARD', 'ServerConf'))
        self.rgclientout = os.path.normpath(config.get('RETROGUARD', 'ClientOut'))
        self.rgserverout = os.path.normpath(config.get('RETROGUARD', 'ServerOut'))
        self.rgclientlog = os.path.normpath(config.get('RETROGUARD', 'ClientLog'))
        self.rgserverlog = os.path.normpath(config.get('RETROGUARD', 'ServerLog'))
        self.rgclientdeoblog = os.path.normpath(config.get('RETROGUARD', 'ClientDeobLog'))
        self.rgserverdeoblog = os.path.normpath(config.get('RETROGUARD', 'ServerDeobLog'))

        # HINT: We read keys relevant to exceptor
        self.xclientconf = os.path.normpath(config.get('EXCEPTOR', 'XClientCfg'))
        self.xserverconf = os.path.normpath(config.get('EXCEPTOR', 'XServerCfg'))
        self.xclientout = os.path.normpath(config.get('EXCEPTOR', 'XClientOut'))
        self.xserverout = os.path.normpath(config.get('EXCEPTOR', 'XServerOut'))
        self.xclientlog = os.path.normpath(config.get('EXCEPTOR', 'XClientLog'))
        self.xserverlog = os.path.normpath(config.get('EXCEPTOR', 'XServerLog'))

        # HINT: We read keys relevant to fernflower
        self.ffclientout = os.path.normpath(config.get('DECOMPILE', 'FFClientOut'))
        self.ffserverout = os.path.normpath(config.get('DECOMPILE', 'FFServerOut'))
        self.ffclientsrc = os.path.normpath(config.get('DECOMPILE', 'FFClientSrc'))
        self.ffserversrc = os.path.normpath(config.get('DECOMPILE', 'FFServerSrc'))
        self.ffsource = config.get('DECOMPILE', 'FFSource')

        # HINT: We read the output directories
        self.binclienttmp = os.path.normpath(config.get('OUTPUT', 'BinClient'))
        self.binservertmp = os.path.normpath(config.get('OUTPUT', 'BinServer'))
        self.srcclient = os.path.normpath(config.get('OUTPUT', 'SrcClient'))
        self.srcserver = os.path.normpath(config.get('OUTPUT', 'SrcServer'))
        self.testclient = config.get('OUTPUT', 'TestClient')
        self.testserver = config.get('OUTPUT', 'TestServer')

        # HINT: Patcher related configs
        self.patchclient = os.path.normpath(config.get('PATCHES', 'PatchClient'))
        self.patchserver = os.path.normpath(config.get('PATCHES', 'PatchServer'))
        self.patchtemp = os.path.normpath(config.get('PATCHES', 'PatchTemp'))
        self.ffpatchclient = os.path.normpath(config.get('PATCHES', 'FFPatchClient'))
        self.ffpatchserver = os.path.normpath(config.get('PATCHES', 'FFPatchServer'))
        self.patchclient_osx = os.path.normpath(config.get('PATCHES', 'PatchClient_osx'))
        self.patchserver_osx = os.path.normpath(config.get('PATCHES', 'PatchServer_osx'))

        # HINT: Recompilation related configs
        self.binclient = os.path.normpath(config.get('RECOMPILE', 'BinClient'))
        self.binserver = os.path.normpath(config.get('RECOMPILE', 'BinServer'))
        cpathclient = config.get('RECOMPILE', 'ClassPathClient').split(',')
        self.cpathclient = [os.path.normpath(p) for p in cpathclient]
        self.fixesclient = os.path.normpath(config.get('RECOMPILE', 'ClientFixes'))
        cpathserver = config.get('RECOMPILE', 'ClassPathServer').split(',')
        self.cpathserver = [os.path.normpath(p) for p in cpathserver]

        # HINT: Reobf related configs
        self.md5client = os.path.normpath(config.get('REOBF', 'MD5Client'))
        self.md5server = os.path.normpath(config.get('REOBF', 'MD5Server'))
        self.md5reobfclient = os.path.normpath(config.get('REOBF', 'MD5PreReobfClient'))
        self.md5reobfserver = os.path.normpath(config.get('REOBF', 'MD5PreReobfServer'))
        self.rgclientrolog = os.path.normpath(config.get('REOBF', 'ClientRoLog'))
        self.rgserverrolog = os.path.normpath(config.get('REOBF', 'ServerRoLog'))
        self.reobsrgclient = os.path.normpath(config.get('REOBF', 'ObfSRGClient'))
        self.reobsrgserver = os.path.normpath(config.get('REOBF', 'ObfSRGServer'))
        self.cmpjarclient = os.path.normpath(config.get('REOBF', 'RecompJarClient'))
        self.cmpjarserver = os.path.normpath(config.get('REOBF', 'RecompJarServer'))
        self.reobfjarclient = os.path.normpath(config.get('REOBF', 'ObfJarClient'))
        self.reobfjarserver = os.path.normpath(config.get('REOBF', 'ObfJarServer'))
        self.nullpkg = config.get('REOBF', 'NullPkg')
        self.ignorepkg = config.get('REOBF', 'IgnorePkg').split(',')
        self.dirreobfclt = os.path.normpath(config.get('REOBF', 'ReobfDirClient'))
        self.dirreobfsrv = os.path.normpath(config.get('REOBF', 'ReobfDirServer'))
        self.clientreoblog = os.path.normpath(config.get('REOBF', 'ReobfClientLog'))
        self.serverreoblog = os.path.normpath(config.get('REOBF', 'ReobfServerLog'))
        self.fixsound = config.get('REOBF', 'FixSound')
        self.fixstart = config.get('REOBF', 'FixStart')

        self.mcplogfile = os.path.normpath(config.get('MCP', 'LogFile'))
        self.mcperrlogfile = os.path.normpath(config.get('MCP', 'LogFileErr'))
        if config.has_option('MCP', 'UpdateUrl'):
            updateurl = config.get('MCP', 'UpdateUrl')
            self.updateurl = updateurl.format(version=Commands.MCPVersion)
        else:
            self.updateurl = None
        ignoreimport = config.get('MCP', 'IgnoreUpdate').split(',')
        self.ignoreimport = [os.path.normpath(p) for p in ignoreimport]

        # Get modified source
        self.srcmodclient = os.path.normpath(config.get('GETMODSOURCE', 'OutSRCClient'))
        self.srcmodserver = os.path.normpath(config.get('GETMODSOURCE', 'OutSRCServer'))

        self.rgreobconfig = os.path.normpath(config.get('RETROGUARD', 'RetroReobConf'))
        self.rgclientreobconf = os.path.normpath(config.get('RETROGUARD', 'ClientReobConf'))
        self.rgserverreobconf = os.path.normpath(config.get('RETROGUARD', 'ServerReobConf'))

    def creatergcfg(self):
        """Create the files necessary for both deobf and obf RetroGuard"""
        self.createsinglergcfg()
        self.createsinglergcfg(True)

    def createsinglergcfg(self, reobf=False):
        """Create the files necessary for RetroGuard"""
        if reobf:
            rgconfig_file = self.rgreobconfig
            rgclientconf_file = self.rgclientreobconf
            rgserverconf_file = self.rgserverreobconf
        else:
            rgconfig_file = self.rgconfig
            rgclientconf_file = self.rgclientconf
            rgserverconf_file = self.rgserverconf

        with open(rgconfig_file, 'w') as rgout:
            rgout.write('.option Application\n')
            rgout.write('.option Applet\n')
            rgout.write('.option Repackage\n')
            rgout.write('.option Annotations\n')
            rgout.write('.option MapClassString\n')
            rgout.write('.attribute LineNumberTable\n')
            rgout.write('.attribute EnclosingMethod\n')
            rgout.write('.attribute Deprecated\n')
            if reobf:
                # this is obfuscated in vanilla and breaks the patches
                rgout.write('.attribute SourceFile\n')
                # this will mess up the patches with mods:
                rgout.write('.attribute LocalVariableTable\n')
                # rg screws up generic signatures:
                rgout.write('.option Generic\n')
                rgout.write('.attribute LocalVariableTypeTable\n')

        with open(rgclientconf_file, 'w') as rgout:
            rgout.write('%s = %s\n' % ('startindex', '0'))
            rgout.write('%s = %s\n' % ('input', self.jarclient))
            rgout.write('%s = %s\n' % ('output', self.rgclientout))
            rgout.write('%s = %s\n' % ('reobinput', self.cmpjarclient))
            rgout.write('%s = %s\n' % ('reoboutput', self.reobfjarclient))
            if reobf:
                rgout.write('%s = %s\n' % ('script', self.rgreobconfig))
                rgout.write('%s = %s\n' % ('log', self.rgclientrolog))
            else:
                rgout.write('%s = %s\n' % ('script', self.rgconfig))
                rgout.write('%s = %s\n' % ('log', self.rgclientlog))
            rgout.write('%s = %s\n' % ('deob', self.srgsclient))
            rgout.write('%s = %s\n' % ('reob', self.reobsrgclient))
            rgout.write('%s = %s\n' % ('nplog', self.rgclientdeoblog))
            rgout.write('%s = %s\n' % ('rolog', self.clientreoblog))
            rgout.write('%s = %s\n' % ('verbose', '0'))
            rgout.write('%s = %s\n' % ('quiet', '1'))
            for pkg in self.ignorepkg:
                rgout.write('%s = %s\n' % ('protectedpackage', pkg))

        with open(rgserverconf_file, 'w') as rgout:
            rgout.write('%s = %s\n' % ('startindex', '0'))
            rgout.write('%s = %s\n' % ('input', self.jarserver))
            rgout.write('%s = %s\n' % ('output', self.rgserverout))
            rgout.write('%s = %s\n' % ('reobinput', self.cmpjarserver))
            rgout.write('%s = %s\n' % ('reoboutput', self.reobfjarserver))
            if reobf:
                rgout.write('%s = %s\n' % ('script', self.rgreobconfig))
                rgout.write('%s = %s\n' % ('log', self.rgserverrolog))
            else:
                rgout.write('%s = %s\n' % ('script', self.rgconfig))
                rgout.write('%s = %s\n' % ('log', self.rgserverlog))
            rgout.write('%s = %s\n' % ('deob', self.srgsserver))
            rgout.write('%s = %s\n' % ('reob', self.reobsrgserver))
            rgout.write('%s = %s\n' % ('nplog', self.rgserverdeoblog))
            rgout.write('%s = %s\n' % ('rolog', self.serverreoblog))
            rgout.write('%s = %s\n' % ('verbose', '0'))
            rgout.write('%s = %s\n' % ('quiet', '1'))
            for pkg in self.ignorepkg:
                rgout.write('%s = %s\n' % ('protectedpackage', pkg))

    def createsrgs(self, side):
        """Write the srgs files."""
        sidelk = {CLIENT: self.srgsclient, SERVER: self.srgsserver}
        writesrgsfromcsvs(self.csvclasses, self.csvmethods, self.csvfields, sidelk[side], side, [self.fixstart, self.fixsound])

    def checkjava(self):
        """Check for java and setup the proper directory if needed"""
        results = []
        if self.osname == 'win':
            if subprocess.call('javac.exe 1>NUL 2>NUL', shell=True) == 2:
                self.cmdjava = 'java.exe'
                self.cmdjavac = 'javac.exe'
                return
            else:
                import _winreg

                for flag in [_winreg.KEY_WOW64_64KEY, _winreg.KEY_WOW64_32KEY]:
                    try:
                        k = _winreg.OpenKey(_winreg.HKEY_LOCAL_MACHINE, "Software\\JavaSoft\\Java Development Kit", 0, _winreg.KEY_READ | flag)
                        version, _ = _winreg.QueryValueEx(k, "CurrentVersion")
                        k.Close()
                        k = _winreg.OpenKey(_winreg.HKEY_LOCAL_MACHINE, "Software\\JavaSoft\\Java Development Kit\\%s" % version, 0, _winreg.KEY_READ | flag)
                        path, _ = _winreg.QueryValueEx(k, "JavaHome")
                        k.Close()
                        if subprocess.call('"%s" 1>NUL 2>NUL' % os.path.join(path, "bin", "javac.exe"), shell=True) == 2:
                            self.cmdjava = '"%s"' % os.path.join(path, "bin", "java.exe")
                            self.cmdjavac = '"%s"' % os.path.join(path, "bin", "javac.exe")
                            return
                    except OSError:
                        pass

                if 'ProgramW6432' in os.environ:
                    results.extend(whereis('javac.exe', os.environ['ProgramW6432']))
                if 'ProgramFiles' in os.environ:
                    results.extend(whereis('javac.exe', os.environ['ProgramFiles']))
                if 'ProgramFiles(x86)' in os.environ:
                    results.extend(whereis('javac.exe', os.environ['ProgramFiles(x86)']))
        elif self.osname in ['linux', 'osx']:
            if subprocess.call('javac 1> /dev/null 2> /dev/null', shell=True) == 2:
                self.cmdjava = 'java'
                self.cmdjavac = 'javac'
                return
            else:
                results.extend(whereis('javac', '/usr/bin'))
                results.extend(whereis('javac', '/usr/local/bin'))
                results.extend(whereis('javac', '/opt'))

        if not results:
            self.logger.error('Java JDK is not installed ! Please install java JDK from http://java.oracle.com')
            sys.exit(1)
        else:
            if self.osname == 'win':
                self.cmdjavac = '"%s"' % os.path.join(results[0], 'javac.exe')
                self.cmdjava = '"%s"' % os.path.join(results[0], 'java.exe')
            elif self.osname in ['linux', 'osx']:
                self.cmdjavac = os.path.join(results[0], 'javac')
                self.cmdjava = os.path.join(results[0], 'java')

    def checkjars(self, side):
        jarlk = {CLIENT: self.jarclient, SERVER: self.jarserver}
        md5jarlk = {CLIENT: self.md5jarclt, SERVER: self.md5jarsrv}

        if not os.path.exists(jarlk[side]):
            self.logger.warning('!! Missing jar file %s. Aborting !!' % jarlk[side])
            return False
        with open(jarlk[side], 'rb') as fh:
            md5jar = md5(fh.read()).hexdigest()
        if md5jar != md5jarlk[side]:
            self.logger.warn('!! Modified jar detected. Unpredictable results !!')
            self.logger.debug('md5: ' + md5jar)
        return True

    def checksources(self, side):
        srclk = {CLIENT: self.srcclient, SERVER: self.srcserver}
        testlk = {CLIENT: self.testclient, SERVER: self.testserver}
        if not os.path.exists(os.path.join(srclk[side], os.path.normpath(testlk[side] + '.java'))):
            self.logger.warning('!! Can not find %s sources !!' % SIDE_NAME[side])
            return False
        return True

    def checkbins(self, side):
        binlk = {CLIENT: self.binclient, SERVER: self.binserver}
        testlk = {CLIENT: self.testclient, SERVER: self.testserver}
        if not os.path.exists(os.path.join(binlk[side], os.path.normpath(testlk[side] + '.class'))):
            self.logger.warning('!! Can not find %s bins !!' % SIDE_NAME[side])
            return False
        return True

    def checkfolders(self):
        if not os.path.exists(self.dirtemp):
            os.makedirs(self.dirtemp)
        if not os.path.exists(self.dirsrc):
            os.makedirs(self.dirsrc)
        if not os.path.exists(self.dirlogs):
            os.makedirs(self.dirlogs)
        if not os.path.exists(self.dirbin):
            os.makedirs(self.dirbin)
        if not os.path.exists(self.dirreobf):
            os.makedirs(self.dirreobf)
        if not os.path.exists(self.dirlib):
            os.makedirs(self.dirlib)

    def checkupdates(self, silent=False):
        # updates disabled?
        if not self.updateurl:
            if not silent:
                self.logger.debug('Updates disabled')
            return []
        # HINT: Each local entry is of the form dict[filename]=(md5,modificationtime)
        md5lcldict = {}
        for path, dirlist, filelist in os.walk('.'):
            for cur_dir in dirlist:
                if os.path.normpath(os.path.join(path, cur_dir)) in self.ignoreimport:
                    # if the full subdir is in the ignored list delete it so that we don't descend into it
                    dirlist.remove(cur_dir)
            for trgfile in filelist:
                cur_file = os.path.normpath(os.path.join(path, trgfile))
                with open(cur_file, 'rb') as fh:
                    md5_file = md5(fh.read()).hexdigest()
                md5lcldict[cur_file] = (md5_file, os.stat(cur_file).st_mtime)
        try:
            update_url = self.updateurl + 'mcp.md5'
            listfh = urllib.urlopen(update_url)
            if listfh.getcode() != 200:
                return []
            md5srvlist = listfh.readlines()
            md5srvdict = {}
        except IOError:
            return []

        # HINT: Each remote entry is of the form dict[filename]=(md5,modificationtime,action)
        for entry in md5srvlist:
            md5srvdict[entry.split()[0]] = (entry.split()[1], float(entry.split()[2]), entry.split()[3])

        results = []
        for key, value in md5srvdict.items():
            cur_file = os.path.normpath(key)
            # HINT: If the remote entry is not in the local table, append
            if cur_file not in md5lcldict:
                results.append([key, value[0], value[1], value[2]])
                continue
            # HINT: If the remote entry has a different MD5 checksum and modtime is > local entry modtime
            if md5lcldict[cur_file][0] != value[0] and md5lcldict[cur_file][1] < value[1]:
                results.append([key, value[0], value[1], value[2]])

        if results and not silent:
            self.logger.warning('!! Updates available. Please run updatemcp to get them. !!')

        return results

    def cleanbindirs(self, side):
        pathbinlk = {CLIENT: self.binclient, SERVER: self.binserver}

        for path, _, filelist in os.walk(pathbinlk[side]):
            for bin_file in fnmatch.filter(filelist, '*.class'):
                os.remove(os.path.normpath(os.path.join(path, bin_file)))

    def cleanreobfdir(self, side):
        outpathlk = {CLIENT: self.dirreobfclt, SERVER: self.dirreobfsrv}

        reallyrmtree(outpathlk[side])
        os.makedirs(outpathlk[side])

    def applyrg(self, side, reobf=False):
        """Apply rg to the given side"""
        rgcplk = {CLIENT: self.cpathclient, SERVER: self.cpathserver}
        if reobf:
            rgcmd = self.cmdrgreobf
            rgconflk = {CLIENT: self.rgclientreobconf, SERVER: self.rgserverreobconf}
        else:
            rgcmd = self.cmdrg
            rgconflk = {CLIENT: self.rgclientconf, SERVER: self.rgserverconf}

        # add retroguard.jar to copy of client or server classpath
        rgcp = [self.retroguard] + rgcplk[side]
        rgcp = os.pathsep.join(rgcp)

        forkcmd = rgcmd.format(classpath=rgcp, conffile=rgconflk[side])
        try:
            self.runcmd(forkcmd)
        except CalledProcessError as ex:
            self.logger.error('')
            self.logger.error('== ERRORS FOUND ==')
            self.logger.error('')
            for line in ex.output.splitlines():
                if line.strip():
                    if line[0] != '#':
                        self.logger.error(line)
            self.logger.error('==================')
            self.logger.error('')
            raise

    def applyff(self, side):
        """Apply fernflower to the given side"""
        ffsrclk = {CLIENT: self.xclientout, SERVER: self.xserverout}

        forkcmd = self.cmdfernflower.format(jarin=ffsrclk[side], jarout=self.dirffout)
        self.runcmd(forkcmd)

    def applyexceptor(self, side):
        """Apply exceptor to the given side"""
        excinput = {CLIENT: self.rgclientout, SERVER: self.rgserverout}
        excoutput = {CLIENT: self.xclientout, SERVER: self.xserverout}
        excconf = {CLIENT: self.xclientconf, SERVER: self.xserverconf}
        exclog = {CLIENT: self.xclientlog, SERVER: self.xserverlog}

        forkcmd = self.cmdexceptor.format(input=excinput[side], output=excoutput[side], conf=excconf[side], log=exclog[side])
        self.runcmd(forkcmd)

    def applyjadretro(self, side):
        """Apply jadretro to the bin output directory"""
        pathbinlk = {CLIENT: self.binclienttmp, SERVER: self.binservertmp}

        ignoredirs = [os.path.normpath(p) for p in self.ignorepkg]
        pkglist = filterdirs(pathbinlk[side], '*.class', ignore_dirs=ignoredirs)
        dirs = ' '.join(pkglist)
        forkcmd = self.cmdjadretro.format(targetdir=dirs)
        self.runcmd(forkcmd)

    def applyjad(self, side):
        """Decompile the code using jad"""
        pathbinlk = {CLIENT: self.binclienttmp, SERVER: self.binservertmp}
        pathsrclk = {CLIENT: self.ffclientout, SERVER: self.ffserverout}

        # HINT: We delete the old temp source folder and recreate it
        reallyrmtree(pathsrclk[side])
        os.makedirs(pathsrclk[side])

        ignoredirs = [os.path.normpath(p) for p in self.ignorepkg]
        pkglist = filterdirs(pathbinlk[side], '*.class', ignore_dirs=ignoredirs, append_pattern=True)
        outdir = pathsrclk[side]

        # on linux with wine we need to quote each directory seperately to prevent the shell expanding *.class before
        # wine sees it, and also use \ as a directory seperator
        if self.cmdjad[:4] == 'wine':
            pkglist = [p.replace(os.sep, '\\') for p in pkglist]
            dirs = '"' + '" "'.join(pkglist) + '"'
            outdir = '"' + outdir.replace(os.sep, '\\') + '"'
        else:
            dirs = ' '.join(pkglist)
        forkcmd = self.cmdjad.format(outdir=outdir, classes=dirs)
        self.runcmd(forkcmd)

    def applypatches(self, side, use_ff=False, use_osx=False):
        """Applies the patches to the src directory"""
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}
        if use_ff:
            patchlk = {CLIENT: self.ffpatchclient, SERVER: self.ffpatchserver}
        elif use_osx:
            patchlk = {CLIENT: self.patchclient_osx, SERVER: self.patchserver_osx}
        else:
            patchlk = {CLIENT: self.patchclient, SERVER: self.patchserver}

        # HINT: Here we transform the patches to match the directory separator of the specific platform
        # also normalise lineendings to platform default to keep patch happy
        with open(patchlk[side], 'rb') as inpatch:
            with open(self.patchtemp, 'wb') as outpatch:
                for line in inpatch:
                    line = line.rstrip('\r\n')
                    if line[:3] in ['+++', '---', 'Onl', 'dif']:
                        outpatch.write(line.replace('\\', os.sep) + os.linesep)
                    else:
                        outpatch.write(line + os.linesep)
        patchfile = os.path.relpath(self.patchtemp, pathsrclk[side])
        forkcmd = self.cmdpatch.format(srcdir=pathsrclk[side], patchfile=patchfile)
        try:
            self.runcmd(forkcmd)
        except CalledProcessError as ex:
            self.logger.warn('')
            self.logger.warn('== ERRORS FOUND ==')
            self.logger.warn('')
            for line in ex.output.splitlines():
                if 'saving rejects' in line:
                    self.logger.warn(line)
            self.logger.warn('==================')
            self.logger.warn('')

    def recompile(self, side):
        """Recompile the sources and produce the final bins"""
        cplk = {CLIENT: self.cpathclient, SERVER: self.cpathserver}
        pathbinlk = {CLIENT: self.binclient, SERVER: self.binserver}
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        if not os.path.exists(pathbinlk[side]):
            os.makedirs(pathbinlk[side])

        # HINT: We create the list of source directories based on the list of packages
        pkglist = filterdirs(pathsrclk[side], '*.java', append_pattern=True)
        if side == CLIENT:
            pkglist.append(os.path.join(self.fixesclient, self.fixsound + '.java'))
            pkglist.append(os.path.join(self.fixesclient, self.fixstart + '.java'))
        dirs = ' '.join(pkglist)

        classpath = os.pathsep.join(cplk[side])
        forkcmd = self.cmdrecomp.format(classpath=classpath, sourcepath=pathsrclk[side], outpath=pathbinlk[side], pkgs=dirs)
        try:
            self.runcmd(forkcmd)
        except CalledProcessError as ex:
            self.logger.error('')
            self.logger.error('== ERRORS FOUND ==')
            self.logger.error('')
            for line in ex.output.splitlines():
                if line.strip():
                    if line[0] != '[' and line[0:4] != 'Note':
                        self.logger.error(line)
                        if '^' in line:
                            self.logger.error('')
            self.logger.error('==================')
            self.logger.error('')
            raise

    def startserver(self):
        classpath = [self.binserver] + self.cpathserver
        classpath = [os.path.join('..', p) for p in classpath]
        classpath = os.pathsep.join(classpath)

        os.chdir(self.dirjars)
        forkcmd = self.cmdstartsrv.format(classpath=classpath)
        self.runmc(forkcmd)

    def startclient(self):
        classpath = [self.binclient] + self.cpathclient
        classpath = [os.path.join('..', p) for p in classpath]
        classpath = os.pathsep.join(classpath)
        natives = os.path.join('..', self.dirnatives)

        os.chdir(self.dirjars)
        forkcmd = self.cmdstartclt.format(classpath=classpath, natives=natives)
        self.runmc(forkcmd)

    def runcmd(self, forkcmd):
        self.logger.debug("runcmd: '" + forkcmd + "'")
        process = subprocess.Popen(forkcmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, bufsize=-1)
        output, _ = process.communicate()
        returncode = process.poll()
        for line in output.splitlines():
            self.logger.debug(line)
        if returncode:
            self.logger.error('\'%s\' failed : %d' % (forkcmd, returncode))
            raise CalledProcessError(returncode, forkcmd, output)

    def runmc(self, forkcmd):
        self.logger.debug("runmc: '" + forkcmd + "'")
        process = subprocess.Popen(forkcmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, bufsize=1)
        while process.poll() is None:
            line = process.stdout.readline().rstrip()
            self.loggermc.debug(line)
            self.logger.debug(line)

    def extractjar(self, side):
        """Unzip the jar file to the bin directory defined in the config file"""
        pathbinlk = {CLIENT: self.binclienttmp, SERVER: self.binservertmp}
        jarlk = {CLIENT: self.xclientout, SERVER: self.xserverout}

        # HINT: We delete the specific side directory and recreate it
        reallyrmtree(pathbinlk[side])
        os.makedirs(pathbinlk[side])

        # HINT: We extract the jar to the right location
        with closing(zipfile.ZipFile(jarlk[side])) as zipjar:
            zipjar.extractall(pathbinlk[side])

    def extractsrc(self, side):
        """Unzip the source jar file to the src directory defined in the config file"""
        pathbinlk = {CLIENT: self.ffclientout, SERVER: self.ffserverout}
        jarlk = {CLIENT: self.ffclientsrc, SERVER: self.ffserversrc}
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # HINT: We check if the top output directory exists. If not, we create it
        if not os.path.exists(pathsrclk[side]):
            os.makedirs(pathsrclk[side])

        # HINT: We extract the jar to a temp dir
        with closing(zipfile.ZipFile(jarlk[side])) as zipjar:
            zipjar.extractall(pathbinlk[side])

        # HINT: copy source to final dir, fixing line endings
        self.copyandfixsrc(pathbinlk[side], pathsrclk[side])

    def copysrc(self, side):
        """Copy the source files to the src directory defined in the config file"""
        pathbinlk = {CLIENT: self.ffclientout, SERVER: self.ffserverout}
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # HINT: We check if the top output directory exists. If not, we create it
        if not os.path.exists(pathsrclk[side]):
            os.makedirs(pathsrclk[side])

        # HINT: copy source to final dir, fixing line endings
        self.copyandfixsrc(pathbinlk[side], pathsrclk[side])

    def copyandfixsrc(self, src_dir, dest_dir):
        src_dir = os.path.normpath(src_dir)
        dest_dir = os.path.normpath(dest_dir)
        ignore_dirs = [os.path.normpath(p) for p in self.ignorepkg]

        for path, dirlist, filelist in os.walk(src_dir, followlinks=True):
            sub_dir = os.path.relpath(path, src_dir)
            for cur_dir in dirlist:
                if os.path.normpath(os.path.join(sub_dir, cur_dir)) in ignore_dirs:
                    # if the full subdir is in the ignored package list delete it so that we don't descend into it
                    dirlist.remove(cur_dir)
            for cur_file in fnmatch.filter(filelist, '*.java'):
                src_file = os.path.normpath(os.path.join(src_dir, sub_dir, cur_file))
                dest_file = os.path.normpath(os.path.join(dest_dir, sub_dir, cur_file))
                if not os.path.exists(os.path.dirname(dest_file)):
                    os.makedirs(os.path.dirname(dest_file))
                # normalise lineendings to platform default, to keep patch happy
                normaliselines(src_file, dest_file)

    def process_rename(self, side):
        """Rename the sources using the CSV data"""
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # HINT: We read the relevant CSVs
        names = {'methods': {}, 'fields': {}}
        with open(self.csvmethods, 'rb') as fh:
            methodsreader = csv.DictReader(fh)
            for row in methodsreader:
                if int(row['side']) == side:
                    names['methods'][row['searge']] = row
        with open(self.csvfields, 'rb') as fh:
            fieldsreader = csv.DictReader(fh)
            for row in fieldsreader:
                if int(row['side']) == side:
                    names['fields'][row['searge']] = row

        regexps = {'methods': re.compile(r'func_[0-9]+_[a-zA-Z]+_?'), 'fields': re.compile(r'field_[0-9]+_[a-zA-Z]+_?')}

        # HINT: We pathwalk the sources
        for path, _, filelist in os.walk(pathsrclk[side], followlinks=True):
            for cur_file in fnmatch.filter(filelist, '*.java'):
                src_file = os.path.normpath(os.path.join(path, cur_file))

                tmp_file = src_file + '.tmp'
                with open(src_file, 'r') as fh:
                    buf = fh.read()

                # HINT: We check if the sources have func_????_? or field_????_? in them.
                # If yes, we replace with the relevant information
                for group in ['methods', 'fields']:
                    for result in regexps[group].findall(buf):
                        # HINT: It is possible for the csv to contain data from previous version or enums, so we catch those
                        try:
                            buf = buf.replace(result, names[group][result]['name'])
                        except KeyError as msg:
                            self.logger.debug("Can not replace %s on side %d" % (msg, side))

                with open(tmp_file, 'w') as fh:
                    fh.write(buf)

                shutil.move(tmp_file, src_file)

    def process_annotate(self, side):
        """Annotate OpenGL constants"""
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # HINT: We pathwalk the sources
        for path, _, filelist in os.walk(pathsrclk[side], followlinks=True):
            for cur_file in fnmatch.filter(filelist, '*.java'):
                src_file = os.path.normpath(os.path.join(path, cur_file))

                annotate_file(src_file)

    def process_comments(self, side):
        """Strip comments, trailing whitespace and extra blank lines"""
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # Remove C and C++ style comments
        regexp_comments = re.compile(r'//.*?$|/\*.*?\*/|\'(?:\\.|[^\\\'])*\'|"(?:\\.|[^\\"])*"', re.DOTALL | re.MULTILINE)

        # Remove extra whitespace at start of file
        regexp_header = re.compile(r'^\s+')

        # Remove extra whitespace at end of file
        regexp_footer = re.compile(r'\s+$')

        # Remove trailing whitespace
        regexp_trailingline = re.compile(r'[ \t]+$', re.MULTILINE)

        # Also remove repeated newlines that are left from comments
        regexp_newlines = re.compile(r'^\n(?:\n+)', re.MULTILINE)

        # close up blanks in code like:
        # {
        #
        #     private
        regexp_blockstarts = re.compile(r'({)\s+(\n[ \t]*\S)', re.MULTILINE)

        # close up blanks in code like:
        #     }
        #
        # }
        regexp_blockends = re.compile(r'([;}])\s+(\n\s*})', re.MULTILINE)

        def replacer(match):
            part = match.group(0)
            if part.startswith('/'):
                return ''
            else:
                return part

        # HINT: We pathwalk the sources
        for path, _, filelist in os.walk(pathsrclk[side], followlinks=True):
            for cur_file in fnmatch.filter(filelist, '*.java'):
                src_file = os.path.normpath(os.path.join(path, cur_file))

                tmp_file = src_file + '.tmp'
                with open(src_file, 'r') as fh:
                    buf = fh.read()

                buf = re.sub(regexp_comments, replacer, buf)
                buf = re.sub(regexp_header, r'', buf)
                buf = re.sub(regexp_footer, r'\n', buf)
                buf = re.sub(regexp_trailingline, r'', buf)
                buf = re.sub(regexp_newlines, r'\n', buf)
                buf = re.sub(regexp_blockstarts, r'\1\2', buf)
                buf = re.sub(regexp_blockends, r'\1\2', buf)
                buf = re.sub(regexp_blockstarts, r'\1\2', buf)
                buf = re.sub(regexp_blockends, r'\1\2', buf)

                with open(tmp_file, 'w') as fh:
                    fh.write(buf)

                shutil.move(tmp_file, src_file)

    def applyastyle(self, side):
        """Recompile the sources and produce the final bins"""
        pathsrclk = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # HINT: We create the list of source directories based on the list of packages
        pkglist = filterdirs(pathsrclk[side], '*.java', append_pattern=True)

        # on linux with wine we need to use \ as a directory seperator
        if self.cmdjad[:4] == 'wine':
            pkglist = [p.replace(os.sep, '\\') for p in pkglist]
        # quote each directory seperately to use astyle filename globbing instead of shell
        dirs = '"' + '" "'.join(pkglist) + '"'
        forkcmd = self.cmdastyle.format(classes=dirs)
        self.runcmd(forkcmd)

    def renamereobsrg(self, side):
        deoblk = {CLIENT: self.rgclientdeoblog, SERVER: self.rgserverdeoblog}
        reoblk = {CLIENT: self.reobsrgclient, SERVER: self.reobsrgserver}

        with open(deoblk[side], 'r') as fh:
            deoblog = fh.read()
        with open(self.csvmethods, 'rb') as fh:
            methodsreader = csv.DictReader(fh)
            for row in methodsreader:
                if int(row['side']) == side:
                    deoblog = deoblog.replace(row['searge'], row['name'])
        with open(self.csvfields, 'rb') as fh:
            fieldsreader = csv.DictReader(fh)
            for row in fieldsreader:
                if int(row['side']) == side:
                    deoblog = deoblog.replace(row['searge'], row['name'])
        with open(reoblk[side], 'w') as reobsrg:
            reobsrg.write(deoblog)

    def gathermd5s(self, side, reobf=False):
        if not reobf:
            md5lk = {CLIENT: self.md5client, SERVER: self.md5server}
        else:
            md5lk = {CLIENT: self.md5reobfclient, SERVER: self.md5reobfserver}
        pathbinlk = {CLIENT: self.binclient, SERVER: self.binserver}

        with open(md5lk[side], 'w') as md5file:
            # HINT: We pathwalk the recompiled classes
            for path, _, filelist in os.walk(pathbinlk[side]):
                class_path = os.path.relpath(path, pathbinlk[side]).replace(os.sep, '/')
                if class_path == '.':
                    class_path = ''
                else:
                    class_path += '/'
                for class_file in fnmatch.filter(filelist, '*.class'):
                    class_name = class_path + os.path.splitext(class_file)[0]
                    bin_file = os.path.normpath(os.path.join(path, class_file))
                    with open(bin_file, 'rb') as fh:
                        class_md5 = md5(fh.read()).hexdigest()
                    md5file.write('%s %s\n' % (class_name, class_md5))

    def packbin(self, side):
        jarlk = {CLIENT: self.cmpjarclient, SERVER: self.cmpjarserver}
        pathbinlk = {CLIENT: self.binclient, SERVER: self.binserver}
        pathtmpbinlk = {CLIENT: self.binclienttmp, SERVER: self.binservertmp}

        ignore_files = []
        if side == CLIENT:
            ignore_files.append(self.fixsound + '.class')
            ignore_files.append(self.fixstart + '.class')

        # HINT: We create the zipfile and add all the files from the bin directory
        with closing(zipfile.ZipFile(jarlk[side], 'w')) as zipjar:
            for path, _, filelist in os.walk(pathbinlk[side]):
                class_path = os.path.relpath(path, pathbinlk[side]).replace(os.sep, '/')
                if class_path == '.':
                    class_path = ''
                else:
                    class_path += '/'
                for class_file in fnmatch.filter(filelist, '*.class'):
                    class_name = class_path + class_file
                    bin_file = os.path.normpath(os.path.join(path, class_file))
                    if class_name not in ignore_files:
                        zipjar.write(bin_file, class_name)
            for pkg in self.ignorepkg:
                curpath = os.path.join(pathtmpbinlk[side], os.path.normpath(pkg))
                for path, _, filelist in os.walk(curpath):
                    class_path = os.path.relpath(path, pathtmpbinlk[side]).replace(os.sep, '/')
                    if class_path == '.':
                        class_path = ''
                    else:
                        class_path += '/'
                    for class_file in fnmatch.filter(filelist, '*.class'):
                        class_name = class_path + class_file
                        bin_file = os.path.join(path, class_file)
                        zipjar.write(bin_file, class_name)

    def unpackreobfclasses(self, side, reobf_all=False):
        jarlk = {CLIENT: self.reobfjarclient, SERVER: self.reobfjarserver}
        md5lk = {CLIENT: self.md5client, SERVER: self.md5server}
        md5reoblk = {CLIENT: self.md5reobfclient, SERVER: self.md5reobfserver}
        outpathlk = {CLIENT: self.dirreobfclt, SERVER: self.dirreobfsrv}

        # HINT: We need a table for the old md5 and the new ones
        md5table = {}
        with open(md5lk[side], 'r') as fh:
            for row in fh:
                row = row.strip().split()
                if len(row) == 2:
                    md5table[row[0]] = row[1]
        md5reobtable = {}
        with open(md5reoblk[side], 'r') as fh:
            for row in fh:
                row = row.strip().split()
                if len(row) == 2:
                    md5reobtable[row[0]] = row[1]

        ignore_classes = []
        if side == CLIENT:
            ignore_classes.append(self.fixstart)
            ignore_classes.append(self.fixsound)

        trgclasses = []
        for key in md5reobtable.keys():
            if key in ignore_classes:
                continue
            if key not in md5table:
                trgclasses.append(key)
                self.logger.info('> New class found      : %s' % key)
            elif md5table[key] != md5reobtable[key]:
                trgclasses.append(key)
                self.logger.info('> Modified class found : %s' % key)
            elif reobf_all:
                trgclasses.append(key)
                self.logger.info('> Unchanged class found: %s' % key)

        classes = {}
        with open(self.csvclasses, 'rb') as fh:
            classesreader = csv.DictReader(fh)
            for row in classesreader:
                if int(row['side']) == side:
                    # HINT: This pkg equivalence is used to reduce the src pkg to the null one
                    pkg = row['package'] + '/'
                    if row['package'] == self.nullpkg:
                        pkg = ''
                    in_class = row['package'] + '/' + row['name']
                    out_class = pkg + row['notch']
                    classes[in_class] = out_class

        if not os.path.exists(outpathlk[side]):
            os.makedirs(outpathlk[side])

        # HINT: We extract the modified class files
        with closing(zipfile.ZipFile(jarlk[side])) as zipjar:
            for in_class in trgclasses:
                try:
                    if in_class in classes:
                        out_class = classes[in_class] + '.class'
                        zipjar.extract(out_class, outpathlk[side])
                        self.logger.info('> Outputted %s to %s as %s' % (in_class.ljust(35), outpathlk[side], out_class))
                    else:
                        out_class = in_class + '.class'
                        out_class = out_class.replace(self.nullpkg, '')
                        if out_class[0] == '/':
                            out_class = out_class[1:]
                        zipjar.extract(out_class, outpathlk[side])
                        self.logger.info('> Outputted %s to %s as %s' % (in_class.ljust(35), outpathlk[side], out_class))
                except KeyError:
                    self.logger.info('> File %s not found' % (in_class + '.class'))

    def downloadupdates(self, force=False):
        if not self.updateurl:
            self.logger.error('Updates disabled.')
            return

        newfiles = self.checkupdates(silent=True)
        if not newfiles:
            self.logger.info('No new updates found.')
            return

        for entry in newfiles:
            if entry[3] == 'U':
                self.logger.info('New version found for : %s' % entry[0])
            elif entry[3] == 'D':
                self.logger.info('File tagged for deletion : %s' % entry[0])

        if 'CHANGELOG' in [i[0] for i in newfiles]:
            print ''
            self.logger.info('== CHANGELOG ==')
            changelog_url = self.updateurl + 'mcp/CHANGELOG'
            changelog = urllib.urlopen(changelog_url).readlines()
            for line in changelog:
                self.logger.info(line.strip())
                if not line.strip():
                    break
            print ''
            print ''

        if not force:
            print 'WARNING:'
            print 'You are going to update MCP'
            print 'Are you sure you want to continue ?'
            answer = raw_input('If you really want to update, enter "Yes" ')
            if answer.lower() not in ['yes', 'y']:
                print 'You have not entered "Yes", aborting the update process'
                sys.exit(1)

        for entry in newfiles:
            if entry[3] == 'U':
                self.logger.info('Retrieving file from server : %s' % entry[0])
                cur_file = os.path.normpath(entry[0])
                path = os.path.dirname(cur_file)
                if not os.path.isdir(path):
                    try:
                        os.makedirs(path)
                    except OSError:
                        pass
                file_url = self.updateurl + 'mcp/' + entry[0]
                urllib.urlretrieve(file_url, cur_file)
            elif entry[3] == 'D':
                self.logger.info('Removing file from local install : %s' % entry[0])
                # Remove file here

    def unpackmodifiedclasses(self, side):
        md5lk = {CLIENT: self.md5client, SERVER: self.md5server}
        md5reoblk = {CLIENT: self.md5reobfclient, SERVER: self.md5reobfserver}
        outpathlk = {CLIENT: self.srcmodclient, SERVER: self.srcmodserver}
        src = {CLIENT: self.srcclient, SERVER: self.srcserver}

        # HINT: We need a table for the old md5 and the new ones
        md5table = {}
        with open(md5lk[side], 'r') as fh:
            for row in fh:
                row = row.strip().split()
                if len(row) == 2:
                    md5table[row[0]] = row[1]
        md5reobtable = {}
        with open(md5reoblk[side], 'r') as fh:
            for row in fh:
                row = row.strip().split()
                if len(row) == 2:
                    md5reobtable[row[0]] = row[1]

        trgclasses = []
        for key in md5reobtable.keys():
            if key not in md5table:
                trgclasses.append(key)
                self.logger.info('> New class found      : %s' % key)
            elif md5table[key] != md5reobtable[key]:
                trgclasses.append(key)
                self.logger.info('> Modified class found : %s' % key)

        if not os.path.exists(outpathlk[side]):
            os.makedirs(outpathlk[side])

        # HINT: We extract the source files for the modified class files
        for i in trgclasses:
            src_file = os.path.normpath(os.path.join(src[side], i + '.java'))
            dest_file = os.path.normpath(os.path.join(outpathlk[side], i + '.java'))
            if os.path.isfile(src_file):
                if not os.path.exists(os.path.dirname(dest_file)):
                    os.makedirs(os.path.dirname(dest_file))
                shutil.copyfile(src_file, dest_file)
                self.logger.info('> Outputted %s to %s' % (i, outpathlk[side]))
