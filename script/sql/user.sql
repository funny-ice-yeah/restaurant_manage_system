CREATE DATABASE big_data_analysis;

USE big_data_analysis;

CREATE TABLE IF NOT EXISTS user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender INT,
    age INT,
    role INT NOT NULL,
    role_id VARCHAR(255) NOT NULL
);