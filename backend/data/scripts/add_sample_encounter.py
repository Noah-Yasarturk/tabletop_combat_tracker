''' Quick script to create test encounter data to work with '''
import pandas as pd 
import sqlalchemy
import json
import os

# Get SQL templates
INSERT_TEMPLATE_STAT = ''
INSERT_CHARACTER_TEMPLATE = ''
INSERT_INSTANCE_STAT = '' 
INSERT_CHARACTER_INSTANCE = ''
dml_dir = os.getcwd() + '/backend/data/dml/'
with open(dml_dir + 'insert_template_stat.sql') as f:
    INSERT_TEMPLATE_STAT = f.read()
with open(dml_dir + 'insert_character_template.sql') as f:
    INSERT_CHARACTER_TEMPLATE = f.read()
with open(dml_dir + 'insert_instance_stat.sql') as f:
    INSERT_INSTANCE_STAT = f.read()
with open(dml_dir + 'insert_character_instance.sql') as f:
    INSERT_CHARACTER_INSTANCE = f.read()
# Get dummy data
d = {}
with open(os.getcwd() + '/frontend/tabletop-track/src/components/dummyStats1.json') as jf:
    d = json.loads(jf.read())
    for character in d['characters']:
        print(character)
        print()
        # Insert template stats
        for template_stat in character['stats']:
            sql = INSERT_TEMPLATE_STAT.replace('<NAME>', template_stat['stat_name'])
            sql = sql.replace('<VALUE>', str(template_stat['stat_value']))
            sql = sql.replace('<MODIFIER>', str(template_stat['stat_modifier']))
            print(sql)
        # Insert character template

        # Insert instance stats 

        # Insert instance character
