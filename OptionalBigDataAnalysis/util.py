from faker import Faker
import random
from tqdm import tqdm

def generate_user(num: int):
    fake = Faker(locale='zh_CN')
    users = []
    for _ in tqdm(range(num), desc='生成用户数据'):
        password = fake.password(length=10)
        user_name = fake.user_name()
        gender = random.choice([0, 1])
        age = random.randint(18, 70)
        role = random.choice([0, 1])
        role_id = fake.ssn()
        user = (password, user_name, gender, age, role, role_id)
        users.append(user)
    return users

def generate_profiles(num: int):
    fake = Faker(locale='zh_CN')
    profiles = []
    for _ in tqdm(range(num), desc='生成配置文件数据'):
        user_id = random.randint(1, 500000)  # 假设 user 表中有 500000 条记录
        profile_name = fake.job()
        profile = (user_id, profile_name)
        profiles.append(profile)
    return profiles