# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 16:54:36 2011

@author: ProfMobius
@version: v1.2
"""

import sys
import time
import os
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER
from recompile import recompile


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-j', '--jad', dest='force_jad', action='store_true',
                      help='force use of JAD even if Fernflower available', default=False)
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    decompile(options.config, options.force_jad)


def decompile(conffile=None, force_jad=False):
    commands = Commands(conffile)

    try:
        commands.checkupdates()

        cltdone = False
        srvdone = False

        use_ff = os.path.exists(commands.fernflower) and not force_jad

        commands.logger.info('> Creating Retroguard config files')
        commands.creatergcfg()

        srcdir = os.path.join(commands.srcclient, os.path.normpath(commands.ffsource))
        if not os.path.exists(srcdir):
            commands.logger.info('== Decompiling Client ==')
            if commands.checkjars(CLIENT):
                clienttime = time.time()
                commands.logger.info('> Creating SRGS for client')
                commands.createsrgs(CLIENT)
                commands.logger.info('> Applying Retroguard to client')
                commands.applyrg(CLIENT)
                commands.logger.info('> Applying Exceptor to client')
                commands.applyexceptor(CLIENT)
                if use_ff:
                    commands.logger.info('> Decompiling...')
                    commands.applyff(CLIENT)
                    commands.logger.info('> Unzipping the client sources')
                    commands.extractsrc(CLIENT)
                commands.logger.info('> Unzipping the client jar')
                commands.extractjar(CLIENT)
                if not use_ff:
                    commands.logger.info('> Applying jadretro')
                    commands.applyjadretro(CLIENT)
                    commands.logger.info('> Decompiling...')
                    commands.applyjad(CLIENT)
                    commands.logger.info('> Copying the client sources')
                    commands.copysrc(CLIENT)
                commands.logger.info('> Applying patches')
                if commands.osname == 'osx' and not use_ff:
                    commands.applypatches(CLIENT, False, True)
                commands.applypatches(CLIENT, use_ff)
                commands.logger.info('> Removing comments')
                commands.process_comments(CLIENT)
                commands.logger.info('> Renaming sources')
                commands.process_rename(CLIENT)
                commands.logger.info('> Reformating sources')
                commands.applyastyle(CLIENT)
                commands.logger.info('> Commenting OpenGL constants')
                commands.process_annotate(CLIENT)
                commands.logger.info('> Creating reobfuscation tables')
                commands.renamereobsrg(CLIENT)
                commands.logger.info('> Done in %.2f seconds' % (time.time() - clienttime))
        else:
            commands.logger.warn('!! Client already decompiled. Run cleanup before decompiling again !!')
            cltdone = True

        srcdir = os.path.join(commands.srcserver, os.path.normpath(commands.ffsource))
        if not os.path.exists(srcdir):
            commands.logger.info('== Decompiling Server ==')
            if commands.checkjars(SERVER):
                servertime = time.time()
                commands.logger.info('> Creating SRGS for server')
                commands.createsrgs(SERVER)
                commands.logger.info('> Applying Retroguard to server')
                commands.applyrg(SERVER)
                commands.logger.info('> Applying Exceptor to server')
                commands.applyexceptor(SERVER)
                if use_ff:
                    commands.logger.info('> Decompiling...')
                    commands.applyff(SERVER)
                    commands.logger.info('> Unzipping the server sources')
                    commands.extractsrc(SERVER)
                commands.logger.info('> Unzipping the server jar')
                commands.extractjar(SERVER)
                if not use_ff:
                    commands.logger.info('> Applying jadretro')
                    commands.applyjadretro(SERVER)
                    commands.logger.info('> Decompiling...')
                    commands.applyjad(SERVER)
                    commands.logger.info('> Copying the server sources')
                    commands.copysrc(SERVER)
                commands.logger.info('> Applying patches')
                if commands.osname == 'osx' and not use_ff:
                    commands.applypatches(SERVER, False, True)
                commands.applypatches(SERVER, use_ff)
                commands.logger.info('> Removing comments')
                commands.process_comments(SERVER)
                commands.logger.info('> Renaming sources')
                commands.process_rename(SERVER)
                commands.logger.info('> Reformating sources')
                commands.applyastyle(SERVER)
                commands.logger.info('> Creating reobfuscation tables')
                commands.renamereobsrg(SERVER)
                commands.logger.info('> Done in %.2f seconds' % (time.time() - servertime))
        else:
            commands.logger.warn('!! Server already decompiled. Run cleanup before decompiling again !!')
            srvdone = True

        commands.logger.info('== Post decompiling operations ==')
        if not cltdone or not srvdone:
            commands.logger.info('> Recompiling')
            recompile(conffile)
        if not cltdone:
            commands.logger.info('> Generating the md5 (client)')
            commands.gathermd5s(CLIENT)
        if not srvdone:
            commands.logger.info('> Generating the md5 (server)')
            commands.gathermd5s(SERVER)
    except Exception:  # pylint: disable-msg=W0703
        commands.logger.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
