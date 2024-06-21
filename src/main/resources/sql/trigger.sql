-- Active: 1718898911243@@127.0.0.1@3306@restaurant_manage_system
USE restaurant_manage_system;

CREATE TRIGGER after_dish_price_update
AFTER UPDATE ON dish
FOR EACH ROW
BEGIN
    IF NEW.current_price != OLD.current_price THEN
        INSERT INTO price (dish_id, price)
        VALUES (NEW.dish_id, NEW.current_price);
    END IF;
END;
