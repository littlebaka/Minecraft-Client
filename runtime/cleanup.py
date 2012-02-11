# -*- coding: utf-8 -*-
"""
Created on Sat Apr  9 13:51:48 2011

@author: ProfMobius & Searge
@version: v1.0
"""

import sys
import os
import glob
import logging
from optparse import OptionParser

from commands import Commands, reallyrmtree


def main():
    parser = OptionParser(version='MCP %s' % Commands.MCPFullVersion())
    parser.add_option('-f', '--force', action='store_true', dest='force', help='force cleanup', default=False)
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    cleanup(options.config, options.force)


def cleanup(conffile=None, force=False):
    if not force:
        print 'WARNING:'
        print 'The cleanup script will delete all folders created by MCP, including the'
        print 'src folder which may contain changes you made to the code.'
        answer = raw_input('If you really want to clean up, enter "Yes" ')
        if answer.lower() not in ['yes']:
            print 'You have not entered "Yes", aborting the clean up process'
            sys.exit(1)

    commands = Commands(conffile)
    commands.checkupdates()

    commands.logger.info('> Cleaning temp')
    try:
        reallyrmtree(commands.dirtemp)
    except OSError:
        commands.logger.error('failed cleaning temp')

    commands.logger.info('> Cleaning src')
    try:
        reallyrmtree(commands.dirsrc)
    except OSError:
        commands.logger.error('failed cleaning src')

    commands.logger.info('> Cleaning bin')
    try:
        reallyrmtree(commands.dirbin)
    except OSError:
        commands.logger.error('failed cleaning bin')

    commands.logger.info('> Cleaning reobf')
    try:
        reallyrmtree(commands.dirreobf)
    except OSError:
        commands.logger.error('failed cleaning reobf')

    commands.logger.info('> Cleaning jars')
    try:
        reallyrmtree(os.path.join(commands.dirjars, 'saves'))
    except OSError:
        commands.logger.error('failed cleaning saves')
    try:
        reallyrmtree(os.path.join(commands.dirjars, 'texturepacks'))
    except OSError:
        commands.logger.error('failed cleaning texturepacks')
    try:
        reallyrmtree(os.path.join(commands.dirjars, 'world'))
    except OSError:
        commands.logger.error('failed cleaning world')
    if os.path.exists(os.path.join(commands.dirjars, 'server.log')):
        os.remove(os.path.join(commands.dirjars, 'server.log'))
    for txt_file in glob.glob(os.path.join(commands.dirjars, '*.txt')):
        os.remove(txt_file)

    commands.logger.info('> Cleaning logs')
    logging.shutdown()
    reallyrmtree(commands.dirlogs)


if __name__ == '__main__':
    main()
