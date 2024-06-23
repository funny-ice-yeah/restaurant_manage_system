-- DROP DATABASE restaurant_manage_system;
CREATE DATABASE IF NOT EXISTS restaurant_manage_system;

USE restaurant_manage_system;

CREATE TABLE IF NOT EXISTS user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender INT,
    age INT,
    role INT NOT NULL,
    role_id VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS restaurant (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_name VARCHAR(255) NOT NULL,
    account VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    brief_intro VARCHAR(255),
    canteen_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS dish (
    dish_id INT AUTO_INCREMENT PRIMARY KEY,
    dish_name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    current_price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255),
    image_url VARCHAR(255),
    is_main_dish INT,
    restaurant_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS allergy (
    dish_id INT NOT NULL,
    allergy VARCHAR(255) NOT NULL,
    PRIMARY KEY(dish_id, allergy)
);

CREATE TABLE IF NOT EXISTS ingredient (
    dish_id INT NOT NULL,
    ingredient VARCHAR(255) NOT NULL,
    PRIMARY KEY(dish_id, ingredient)
);

CREATE TABLE IF NOT EXISTS nutrition (
    dish_id INT NOT NULL,
    nutrition VARCHAR(255) NOT NULL,
    PRIMARY KEY(dish_id, nutrition)
);

CREATE TABLE IF NOT EXISTS `order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_status VARCHAR(255) NOT NULL,
    order_time TIMESTAMP NOT NULL,
    order_method VARCHAR(255) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT NOT NULL,
    restaurant_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS order_detail (
    quantity INT NOT NULL,
    order_id INT NOT NULL,
    dish_id INT NOT NULL,
    PRIMARY KEY(order_id, dish_id)
);

CREATE TABLE IF NOT EXISTS message (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    order_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS dish_review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL, 
    rating INT NOT NULL,
    user_id INT NOT NULL,
    dish_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS restaurant_review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    rating INT NOT NULL,
    user_id INT NOT NULL,
    restaurant_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS canteen (
    canteen_id INT AUTO_INCREMENT PRIMARY KEY,
    canteen_name VARCHAR(255) NOT NULL,
    canteen_location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS manager (
    manager_id INT AUTO_INCREMENT PRIMARY KEY,
    account VARCHAR(255) NOT NULL,
    manager_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS favorite_restaurant (
    user_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    PRIMARY KEY(user_id, restaurant_id)
);

CREATE TABLE IF NOT EXISTS favorite_dish (
    user_id INT NOT NULL,
    dish_id INT NOT NULL,
    PRIMARY KEY(user_id, dish_id)
);

CREATE TABLE IF NOT EXISTS price (
    dish_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(dish_id, create_at)
);



ALTER TABLE restaurant ADD FOREIGN KEY(canteen_id) REFERENCES canteen(canteen_id) ON DELETE CASCADE;  
ALTER TABLE dish ADD FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id) ON DELETE CASCADE;  
ALTER TABLE `order` ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;  
ALTER TABLE `order` ADD FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id) ON DELETE CASCADE;  
ALTER TABLE order_detail ADD FOREIGN KEY(order_id) REFERENCES `order`(order_id) ON DELETE CASCADE;  
ALTER TABLE order_detail ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;  
ALTER TABLE message ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;  
ALTER TABLE message ADD FOREIGN KEY(order_id) REFERENCES `order`(order_id) ON DELETE CASCADE;  
ALTER TABLE dish_review ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;  
ALTER TABLE dish_review ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;  
ALTER TABLE restaurant_review ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;  
ALTER TABLE restaurant_review ADD FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id) ON DELETE CASCADE; 
ALTER TABLE favorite_restaurant ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;  
ALTER TABLE favorite_restaurant ADD FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id) ON DELETE CASCADE;  
ALTER TABLE favorite_dish ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;  
ALTER TABLE favorite_dish ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;  
ALTER TABLE price ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;
ALTER TABLE allergy ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;  
ALTER TABLE ingredient ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;  
ALTER TABLE nutrition ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;  

-- 主键索引
CREATE INDEX idx_user_id ON user(user_id);
CREATE INDEX idx_restaurant_id ON restaurant(restaurant_id);
CREATE INDEX idx_dish_id ON dish(dish_id);
CREATE INDEX idx_allergy_dish_id_allergy ON allergy(dish_id, allergy);
CREATE INDEX idx_ingredient_dish_id_ingredient ON ingredient(dish_id, ingredient);
CREATE INDEX idx_nutrition_dish_id_nutrition ON nutrition(dish_id, nutrition);
CREATE INDEX idx_order_id ON `order`(order_id);
CREATE INDEX idx_order_detail_order_id_dish_id ON order_detail(order_id, dish_id);
CREATE INDEX idx_message_id ON message(message_id);
CREATE INDEX idx_dish_review_id ON dish_review(review_id);
CREATE INDEX idx_restaurant_review_id ON restaurant_review(review_id);
CREATE INDEX idx_canteen_id ON canteen(canteen_id);
CREATE INDEX idx_manager_id ON manager(manager_id);
CREATE INDEX idx_favorite_restaurant_user_id ON favorite_restaurant(user_id);
CREATE INDEX idx_favorite_restaurant_restaurant_id ON favorite_restaurant(restaurant_id);
CREATE INDEX idx_favorite_dish_user_id ON favorite_dish(user_id);
CREATE INDEX idx_favorite_dish_dish_id ON favorite_dish(dish_id);
CREATE INDEX idx_price_dish_id_create_at ON price(dish_id, create_at);

CREATE INDEX idx_user_role_id ON user(role_id); 
CREATE INDEX idx_user_gender ON user(gender); -- 用户群体分析
CREATE INDEX idx_user_age ON user(age);  -- 用户群体分析

CREATE INDEX idx_restaurant_account ON restaurant(account);
CREATE INDEX idx_restaurant_canteen_id ON restaurant(canteen_id);
CREATE INDEX idx_restaurant_name ON restaurant(restaurant_name);

CREATE INDEX idx_dish_restaurant_id ON dish(restaurant_id);
CREATE INDEX idx_dish_name ON dish(dish_name);
CREATE INDEX idx_dish_is_main_dish ON dish(is_main_dish); -- 主菜

CREATE INDEX idx_order_user_id ON `order`(user_id);
CREATE INDEX idx_order_restaurant_id ON `order`(restaurant_id);
CREATE INDEX idx_order_status ON `order`(order_status);
CREATE INDEX idx_order_time ON `order`(order_time); -- 订餐

CREATE INDEX idx_order_detail_order_id ON order_detail(order_id);
CREATE INDEX idx_order_detail_dish_id ON order_detail(dish_id);

CREATE INDEX idx_message_user_id ON message(user_id);
CREATE INDEX idx_message_order_id ON message(order_id);

CREATE INDEX idx_dish_review_user_id ON dish_review(user_id);
CREATE INDEX idx_dish_review_dish_id ON dish_review(dish_id);

CREATE INDEX idx_restaurant_review_user_id ON restaurant_review(user_id);
CREATE INDEX idx_restaurant_review_restaurant_id ON restaurant_review(restaurant_id);

-- 为 dish_review 表的评分和评论创建索引
CREATE INDEX idx_dish_review_rating ON dish_review(rating);
CREATE INDEX idx_dish_review_content ON dish_review(content);

-- 为 restaurant_review 表的评分和评论创建索引
CREATE INDEX idx_restaurant_review_rating ON restaurant_review(rating);
CREATE INDEX idx_restaurant_review_content ON restaurant_review(content);
