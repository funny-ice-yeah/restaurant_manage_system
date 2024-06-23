import mysql.connector
import util
from tqdm import tqdm
import time

conn = mysql.connector.connect(
    host='localhost',
    user='root',
    password='970227',
    database='big_data_analysis'
)
cursor = conn.cursor()

def insert_users(num: int):
    users = util.generate_user(num)
    cursor.executemany('''
        INSERT INTO user (password, user_name, gender, age, role, role_id)
        VALUES (%s, %s, %s, %s, %s, %s)
    ''', users)
    conn.commit()

def delete_all_users():
    cursor.execute('DELETE FROM user')
    conn.commit()

def create_idx_on_user_age():
    cursor.execute('CREATE INDEX idx_age ON user(age)')
    conn.commit()

def drop_idx_on_user_age():
    cursor.execute('DROP INDEX idx_age ON user')
    conn.commit()

def execute_query_on_age(query:str):
    start_time = time.time()
    cursor.execute(query)
    results = cursor.fetchall()
    end_time = time.time()
    print(f'查询语句:{query}')
    print(f"查询结果: {len(results)} 行")
    print(f"查询时间: {end_time - start_time} 秒")

def execute_with_index(query="SELECT * FROM user WHERE age=24"):
    try:
        create_idx_on_user_age()
    except Exception as e:
        pass
    print("建立索引查询:")
    execute_query_on_age(query=query)

def execute_without_index(query="SELECT * FROM user WHERE age=24"):
    try:
        drop_idx_on_user_age()
    except Exception as e:
        pass
    print("无索引查询:")
    execute_query_on_age(query=query)

if __name__ == '__main__':
    # delete_all_users()
    # insert_users(500000)
    querys = ["SELECT * FROM user WHERE age>24 and age<=30", 'SELECT * FROM user WHERE age=27', "SELECT * FROM user WHERE age>24", "SELECT * FROM user WHERE age<=30"]
    for query in querys:
        execute_with_index(query)
        execute_without_index(query)
    cursor.close()
    conn.close()