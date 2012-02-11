# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 16:54:36 2011

@author: ProfMobius
@version: v1.1
"""

import sys
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-a', '--all', action='store_true', dest='reobf_all', help='output all classes', default=False)
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    reobfuscate(options.config, options.reobf_all)


def reobfuscate(conffile=None, reobf_all=False):
    commands = Commands(conffile)

    try:
        commands.logger.info('== Reobfuscating client ==')
        if commands.checkbins(CLIENT):
            commands.cleanreobfdir(CLIENT)
            commands.logger.info('> Gathering md5 checksums')
            commands.gathermd5s(CLIENT, True)
            commands.logger.info('> Compacting client bin directory')
            commands.packbin(CLIENT)
            commands.logger.info('> Reobfuscating client jar')
            commands.applyrg(CLIENT, True)
            commands.logger.info('> Extracting modified classes')
            commands.unpackreobfclasses(CLIENT, reobf_all)

        commands.logger.info('== Reobfuscating server ==')
        if commands.checkbins(SERVER):
            commands.cleanreobfdir(SERVER)
            commands.logger.info('> Gathering md5 checksums')
            commands.gathermd5s(SERVER, True)
            commands.logger.info('> Compacting server bin directory')
            commands.packbin(SERVER)
            commands.logger.info('> Reobfuscating server jar')
            commands.applyrg(SERVER, True)
            commands.logger.info('> Extracting modified classes')
            commands.unpackreobfclasses(SERVER, reobf_all)
    except Exception:  # pylint: disable-msg=W0703
        commands.logger.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
