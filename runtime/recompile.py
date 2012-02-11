# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 16:54:36 2011

@author: ProfMobius
@version: v1.0
"""

import sys
import time
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    recompile(options.config)


def recompile(conffile=None):
    commands = Commands(conffile)

    try:
        commands.logger.info('> Recompiling client...')
        clienttime = time.time()
        if commands.checksources(CLIENT):
            commands.cleanbindirs(CLIENT)
            commands.recompile(CLIENT)
            commands.logger.info('> Done in %.2f seconds' % (time.time() - clienttime))

        commands.logger.info('> Recompiling server...')
        servertime = time.time()
        if commands.checksources(SERVER):
            commands.cleanbindirs(SERVER)
            commands.recompile(SERVER)
            commands.logger.info('> Done in %.2f seconds' % (time.time() - servertime))
    except Exception:  # pylint: disable-msg=W0703
        commands.logger.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
