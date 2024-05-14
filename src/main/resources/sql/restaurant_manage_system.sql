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
    role_id INT NOT NULL
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
    price_id INT NOT NULL,
    description VARCHAR(255),
    image_url VARCHAR(255),
    is_main_dish INT,
    restaurant_id INT NOT NULL,
    ingredient VARCHAR(255),
    allergy VARCHAR(255),
    nutrition VARCHAR(255)
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

CREATE TABLE IF NOT EXISTS seat (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255) NOT NULL,
    canteen_id INT NOT NULL,
    status VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS seat_reservation (
    seat_id INT NOT NULL,
    user_id INT NOT NULL,
    time TIMESTAMP NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(seat_id, user_id)
);

CREATE TABLE IF NOT EXISTS price (
    price_id INT AUTO_INCREMENT PRIMARY KEY,
    dish_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE restaurant ADD FOREIGN KEY(canteen_id) REFERENCES canteen(canteen_id) ON DELETE CASCADE;  
ALTER TABLE dish ADD FOREIGN KEY(restaurant_id) REFERENCES restaurant(restaurant_id) ON DELETE CASCADE;  
ALTER TABLE dish ADD FOREIGN KEY(price_id) REFERENCES price(price_id);
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
ALTER TABLE seat ADD FOREIGN KEY(canteen_id) REFERENCES canteen(canteen_id) ON DELETE CASCADE;  
ALTER TABLE seat_reservation ADD FOREIGN KEY(seat_id) REFERENCES seat(seat_id) ON DELETE CASCADE;  
ALTER TABLE seat_reservation ADD FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE;
ALTER TABLE price ADD FOREIGN KEY(dish_id) REFERENCES dish(dish_id) ON DELETE CASCADE;


