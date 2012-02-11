# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 12:50:02 2011

@author: ProfMobius
@version : v0.1
"""


def writesrgs(filename, data):
    """Writes a srgs file based on data. Data is formatted similar to the output of readsrgs (dict of lists)"""
    if not 'PK' in data or not 'CL' in data or not 'FD' in data or not 'MD' in data:
        raise Exception("Malformed data for writesrgs. Keys should be in ['PK', 'CL', 'FD', 'MD']")

    with open(filename, 'w') as srgsout:
        # HINT: We write all the entries for a given key in order. The line ending is set to \r\n for windows compatibility
        for key in ['PK', 'CL', 'FD', 'MD']:
            for entry in data[key]:
                srgsout.write('%s: %s %s\n' % (key, entry[0], entry[1]))
