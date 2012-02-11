# -*- coding: utf-8 -*-
"""
Created on Mon Oct  3 02:10:23 2011

@author: IxxI
@version: v1.0
"""

import sys
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    getmodsource(options.config)


def getmodsource(conffile=None):
    commands = Commands(conffile)

    try:
        commands.logger.info('> Getting modified client source')
        if commands.checksources(CLIENT):
            commands.gathermd5s(CLIENT, True)
            commands.unpackmodifiedclasses(CLIENT)
        commands.logger.info('> Getting modified server source')
        if commands.checksources(SERVER):
            commands.gathermd5s(SERVER, True)
            commands.unpackmodifiedclasses(SERVER)
    except Exception:  # pylint: disable-msg=W0703
        commands.logger.exception('FATAL ERROR')
        sys.exit(1)

if __name__ == '__main__':
    main()
