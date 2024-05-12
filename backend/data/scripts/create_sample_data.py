''' Quick script to create test encounter data to work with '''
import pandas as pd 
from sqlalchemy import create_engine, text
import json
import os


SENS_JSON = os.getcwd() + '/sens.json' # gitignored
SENS_D = {}
with open(SENS_JSON) as jf:
    SENS_D = json.loads(jf.read())
# Instantiate db connection
ENGINE_URL = f"postgresql+psycopg2://{SENS_D['db_un']}:{SENS_D['db_pw']}@{SENS_D['db_host']}:{SENS_D['db_port']}/{SENS_D['db_nm']}"
ENGINE = create_engine(ENGINE_URL)
# Get SQL templates
DDL_DIR = os.getcwd() + '/backend/data/ddl/'
DML_DIR = os.getcwd() + '/backend/data/dml/'
INSERT_TEMPLATE_STAT = ''
INSERT_CHARACTER_TEMPLATE = ''
INSERT_INSTANCE_STAT = '' 
INSERT_CHARACTER_INSTANCE = ''
with open(DML_DIR + 'insert_template_stat.sql') as f:
    INSERT_TEMPLATE_STAT = f.read()
with open(DML_DIR + 'insert_character_template.sql') as f:
    INSERT_CHARACTER_TEMPLATE = f.read()
with open(DML_DIR + 'insert_instance_stat.sql') as f:
    INSERT_INSTANCE_STAT = f.read()
with open(DML_DIR + 'insert_character_instance.sql') as f:
    INSERT_CHARACTER_INSTANCE = f.read()
DDL_ORDER = ['user_role', 'tool_user', 'encounter', 'character_template', 
                 'template_stat', 'character_instance', 'instance_stat']

def run_sql(q: str) -> None:
    ''' Run & commit SQL '''
    print(f'Executing SQL:\n{q}') 
    with ENGINE.connect() as connection:
        res = connection.execute(text(q))
        connection.commit()


def drop_all_tables() -> None:
    ''' Drop all tables '''
    print('Dropping all tables...')
    ddl_reverse = reversed(DDL_ORDER)
    for tbl_nm in ddl_reverse:
        drop_sql = f"DROP TABLE IF EXISTS public.{tbl_nm};"
        run_sql(drop_sql)
    print('All tables dropped.')


def create_all_tables() -> None:
    ''' Create all tables, accounting for dependencies '''
    print('Creating all tables..')
    def run_ddl_from_file(ddl_nm):
        file_nm = DDL_DIR + ddl_nm + '.sql'
        with open(file_nm) as ddl_f:
            run_sql(ddl_f.read())
    for ddl in DDL_ORDER:
        run_ddl_from_file(ddl)
    print('All tables created.')


def load_dummy_data() -> None:
    ''' Load data from dummy json'''
    # Get dummy data
    d = {}
    with open(os.getcwd() + '/frontend/tabletop-track/src/components/dummyStats1.json') as jf:
        d = json.loads(jf.read())
        for c in d['characters']:
            print(c)
            print()
            # Insert character template 
            sql = INSERT_CHARACTER_TEMPLATE.replace('<HEALTH>', str(c['total_health']))
            sql = sql.replace('<PLAYER_TYPE>',c['player_type']).replace('<CHAR_TYPE>',c['character_type'])
            run_sql(sql)
            # Insert template stats
            for template_stat in c['stats']:
                # TODO: execute SQL
                pass
            # Insert instance character
            # TODO: implement

            # Insert instance stats 
            # TODO: implement


if __name__ == "__main__":
    drop_all_tables()
    create_all_tables()
    load_dummy_data()