# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 16:54:36 2011

@author: Searge
@version: v1.0
"""

import sys
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    updatenames(options.config)


def updatenames(conffile):
    commands = Commands(conffile)

    try:
        commands.logger.info('== Client ==')
        commands.logger.info('> Renaming sources')
        commands.process_rename(CLIENT)
        commands.logger.info('> Creating reobfuscation tables')
        commands.renamereobsrg(CLIENT)
        commands.logger.info('== Server ==')
        commands.logger.info('> Renaming sources')
        commands.process_rename(SERVER)
        commands.logger.info('> Creating reobfuscation tables')
        commands.renamereobsrg(SERVER)
    except Exception:  # pylint: disable-msg=W0703
        commands.logger.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
