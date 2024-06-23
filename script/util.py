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

