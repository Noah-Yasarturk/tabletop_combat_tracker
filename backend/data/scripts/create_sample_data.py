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
INSERT_ROLE = ''
INSERT_USER = ''
INSERT_ENCOUNTER = ''
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
with open(DML_DIR + 'insert_role.sql') as f:
    INSERT_ROLE = f.read()
with open(DML_DIR + 'insert_user.sql') as f:
    INSERT_USER = f.read()
with open(DML_DIR + 'insert_encounter.sql') as f:
    INSERT_ENCOUNTER = f.read()
DDL_ORDER = ['user_role', 'tool_user', 'encounter', 'character_template', 
                 'template_stat', 'character_instance', 'instance_stat']

def run_sql(q: str) -> None:
    ''' Run & commit SQL '''
    print(f'Executing SQL:\n{q}') 
    with ENGINE.connect() as connection:
        res = connection.execute(text(q))
        connection.commit()

def sql_to_df(q: str) -> pd.DataFrame:
    ''' Read the SQL '''
    print(f'Reading via SQL to DataFrame:\n{q}') 
    df = None
    with ENGINE.connect() as connection:
        df = pd.read_sql(q, connection)
    return df


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
        run_sql(INSERT_ROLE)
        run_sql(INSERT_USER)
        run_sql(INSERT_ENCOUNTER)
        for c in d['characters']:
            print(c)
            print()
            # Insert character template 
            sql = INSERT_CHARACTER_TEMPLATE.replace('<HEALTH>', str(c['total_health']))
            sql = sql.replace('<PLAYER_TYPE>',c['player_type']).replace('<CHAR_TYPE>',c['character_type'])
            run_sql(sql)
            # Get the char template id 
            max_chrtmpl_sql = "SELECT MAX(template_id) as tid FROM public.character_template"
            char_tmp_id = str(sql_to_df(max_chrtmpl_sql).iloc[0]['tid'])
            # Insert template stats
            for t_stat in c['stats']:
                sql = INSERT_TEMPLATE_STAT.replace('<TID>', char_tmp_id).replace('<NAME>', t_stat['stat_name'])
                sql = sql.replace('<VAL>', t_stat['stat_value']).replace('<MOD>', t_stat['stat_modifier'])
                run_sql(sql)
            # Insert instance character
            e_id_sql = "SELECT MAX(encounter_id) as eid FROM public.encounter"
            e_id = str(sql_to_df(e_id_sql).iloc[0]['eid'])
            sql = INSERT_CHARACTER_INSTANCE.replace('<EID>',e_id).replace('<TID>', char_tmp_id)
            sql = sql.replace('<HLTH>', str(c['current_health'])).replace('<C_TYPE>', c['character_type'])
            sql = sql.replace('<P_TYPE>',c['player_type'])
            run_sql(sql)
            # Insert instance stats 
            


if __name__ == "__main__":
    drop_all_tables()
    create_all_tables()
    load_dummy_data()