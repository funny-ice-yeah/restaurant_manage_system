import mysql.connector
import util
from tqdm import tqdm
import time

conn = mysql.connector.connect(
    host='localhost',
    user='root',
    password='YOUR-PASSWORD',
    database='big_data_analysis'
)
cursor = conn.cursor()

def insert_profiles(num: int):
    profiles = util.generate_profiles(num)
    cursor.executemany('''
        INSERT INTO PROFILE (user_id, profile_name)
        VALUES (%s, %s)
    ''', profiles)
    conn.commit()

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

def create_composite_idx_on_user_role_age():
    cursor.execute('CREATE INDEX idx_role_age ON user(role, age)')
    conn.commit()

def drop_composite_idx_on_user_role_age():
    cursor.execute('DROP INDEX idx_role_age ON user')
    conn.commit()

def create_idx_on_profile_user_id():
    cursor.execute('CREATE INDEX idx_user_id ON PROFILE(user_id)')
    conn.commit()

def drop_idx_on_profile_user_id():
    cursor.execute('DROP INDEX idx_user_id ON PROFILE')
    conn.commit()


def execute_query(query:str):
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
    execute_query(query=query)

def execute_without_index(query="SELECT * FROM user WHERE age=24"):
    try:
        drop_idx_on_user_age()
    except Exception as e:
        pass
    print("无索引查询:")
    execute_query(query=query)

def execute_with_composite_index(query="SELECT * FROM user WHERE role=0 AND age=24"):
    try:
        create_composite_idx_on_user_role_age()
    except Exception as e:
        pass
    print("建立联合索引查询:")
    execute_query(query=query)

def execute_without_composite_index(query="SELECT * FROM user WHERE role=0 AND age=24"):
    try:
        drop_composite_idx_on_user_role_age()
    except Exception as e:
        pass
    print("无联合索引查询:")
    execute_query(query=query)

def execute_with_join_index(query="SELECT u.user_name, p.profile_name FROM user u JOIN PROFILE p ON u.user_id = p.user_id WHERE u.age = 24"):
    try:
        create_idx_on_profile_user_id()
    except Exception as e:
        pass
    print("建立索引JOIN查询:")
    execute_query(query=query)

def execute_without_join_index(query="SELECT u.user_name, p.profile_name FROM user u JOIN PROFILE p ON u.user_id = p.user_id WHERE u.age = 24"):
    try:
        drop_idx_on_profile_user_id()
    except Exception as e:
        pass
    print("无索引JOIN查询:")
    execute_query(query=query)

if __name__ == '__main__':
    # delete_all_users()
    # insert_users(500000)
    # stage 1. single index
    # querys = ["SELECT * FROM user WHERE age>24 and age<=30", 'SELECT * FROM user WHERE age=27', "SELECT * FROM user WHERE age>24", "SELECT * FROM user WHERE age<=30"]
    # for query in querys:
    #     execute_with_index(query)
    #     execute_without_index(query)
    
    # stage 2.combined index
    # querys = ["SELECT * FROM user WHERE role = 0 AND age = 27", 
    #           "SELECT * FROM user WHERE role = 0 AND age > 24", 
    #           "SELECT * FROM user WHERE role = 0 AND age < 30", 
    #           "SELECT * FROM user WHERE role = 0 AND age > 24 AND age <= 30"]
    # for query in querys:
    #     execute_with_composite_index(query)
    #     execute_without_composite_index(query)    
    # cursor.close()
    # conn.close()

    # insert_profiles(500000)

    # stage 3. join
    query = "SELECT u.user_name, p.profile_name FROM user u JOIN PROFILE p ON u.user_id = p.user_id"
    
    execute_with_join_index(query)
    execute_without_join_index(query)
    
    cursor.close()
    conn.close()