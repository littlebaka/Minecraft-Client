# -*- coding: utf-8 -*-
"""
Created on Fri May 22 23:32:36 2011

@author: Searge
@version: v1.0
"""

import sys
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER
from recompile import recompile


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    updatemd5(options.config)


def updatemd5(conffile=None):
    commands = Commands(conffile)

    try:
        commands.logger.info('> Recompiling')
        recompile(conffile)
        commands.logger.info('> Generating the md5 (client)')
        commands.gathermd5s(CLIENT)
        commands.logger.info('> Generating the md5 (server)')
        commands.gathermd5s(SERVER)
    except Exception:  # pylint: disable-msg=W0703
        commands.logger.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
