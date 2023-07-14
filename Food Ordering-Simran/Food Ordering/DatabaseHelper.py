from pymysql import *
 
from pymysql import cursors
 
 
class DatabaseHelper():
 
    USER = 'root'
 
    PASSWORD = 'root1234'
 
    HOST = 'localhost'
 
    database = 'world'
 
 
    @classmethod
 
    def get_columns(cls, description):
 
        return tuple(map(lambda x: x[0], description))
 
 
#
 
    @classmethod
 
    def get_data(cls, query, parameters=None) -> dict:
 
        conn = connect(host=cls.HOST, database=cls.database, user=cls.USER, password=cls.PASSWORD)
 
        cur = conn.cursor(cursor=cursors.DictCursor)
 
        if (parameters is None):
 
            cur.execute(query)
 
        else:
 
            cur.execute(query,parameters)
 
        result = cur.fetchone()
 
        cur.close()
 
        conn.close()
 
        return result
 
 
    @classmethod
 
    def get_all_data(cls, query, parameters=None):
 
        conn = connect(host=cls.HOST, database=cls.database, user=cls.USER, password=cls.PASSWORD)
 
        cur = conn.cursor()
 
        if (parameters is None):
 
            cur.execute(query)
 
        else:
 
            cur.execute(query, parameters)
 
        result = cur.fetchall()
 
        headers = DatabaseHelper.get_columns(cur.description)
 
        cur.close()
 
        conn.close()
 
        return (headers,) + result
 
 
    @classmethod
 
    def execute_query(cls, query, parameters=None):
 
        conn = connect(host=cls.HOST, database=cls.database, user=cls.USER, password=cls.PASSWORD)
 
        cur = conn.cursor()
 
        if (parameters is None):
 
            cur.execute(query)
 
        else:
 
            cur.execute(query, parameters)
 
        conn.commit()
 
        cur.close()
 
        conn.close()
 
 
    @classmethod
 
    def get_all_data_multiple_input(cls, query, params):
 
        conn = connect(host=cls.HOST, database=cls.database, user=cls.USER, password=cls.PASSWORD)
 
        cur = conn.cursor()
 
        format_strings = ','.join(['%s'] * len(params))
 
        cur.execute(query % format_strings, params)
 
        result = cur.fetchall()
 
        headers = DatabaseHelper.get_columns(cur.description)
 
        cur.close()
 
        conn.close()
 
        return (headers,) + result
 
 
    @classmethod
 
    def execute_all_data_multiple_input(cls, query, params):
 
        conn = connect(host=cls.HOST, database=cls.database, user=cls.USER, password=cls.PASSWORD)
 
        cur = conn.cursor()
 
        format_strings = ','.join(['%s'] * len(params))
 
        cur.execute(query % format_strings, params)
 
        conn.commit()
 
        cur.close()
 
        conn.close()