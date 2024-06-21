-- Active: 1718898911243@@127.0.0.1@3306@restaurant_manage_system
USE restaurant_manage_system;
DELIMITER $$

-- delete scripts
-- DROP PROCEDURE IF EXISTS GetAverageRatingByDishId $$

-- DROP PROCEDURE IF EXISTS GetTopCustomerUserIdByDishId $$

-- DROP PROCEDURE IF EXISTS SelectTotalSalesByDishIdAndOrdermethodBeforeParticularTime $$

-- DROP PROCEDURE IF EXISTS GetOrderDetailsByRestaurantIdAndUserId $$

-- DROP PROCEDURE IF EXISTS GetLoyalCustomerIds $$

-- DROP PROCEDURE IF EXISTS GetActivityInOneDayForRestaurant $$

-- DROP PROCEDURE IF EXISTS GetMonthlyRevenues $$

CREATE PROCEDURE GetAverageRatingByDishId(IN dishId INT)
BEGIN
    SELECT AVG(rating) AS averageRating
    FROM dish_review
    WHERE dish_id = dishId;
END $$

CREATE PROCEDURE GetTopCustomerUserIdByDishId(IN dishId INT)
BEGIN
    SELECT o.user_id
    FROM `order` AS o 
    JOIN order_detail AS od
    ON o.order_id = od.order_id
    WHERE od.dish_id = dishId
    AND o.order_status LIKE '%已完成%'
    GROUP BY o.user_id
    HAVING SUM(od.quantity) = (
        SELECT MAX(customer_total_quantity)
        FROM (
        SELECT o.user_id, SUM(sub.quantity) AS customer_total_quantity
        FROM order_detail AS sub
        JOIN `order` AS o ON o.order_id = sub.order_id
        WHERE sub.dish_id = dishId
        AND o.order_status LIKE '%已完成%'
        GROUP BY o.user_id
        ) AS max_query
    );
END $$

CREATE PROCEDURE SelectTotalSalesByDishIdAndOrdermethodBeforeParticularTime(IN dishId INT, IN timeStamp TIMESTAMP, IN orderMethod VARCHAR(255))
BEGIN
    SELECT SUM(od.quantity) 
    FROM order_detail AS od 
    JOIN `order` AS o 
    ON o.order_id = od.order_id 
    WHERE od.dish_id = dishId
    AND o.order_time >= timeStamp
    AND o.order_status LIKE '%已完成%'
    AND o.order_method = orderMethod;
END $$

CREATE PROCEDURE GetOrderDetailsByRestaurantIdAndUserId(IN restaurantId INT, IN startTime TIMESTAMP, IN userId INT)
BEGIN
    SELECT od.dish_id, SUM(od.quantity) AS total_purchase
    FROM order_detail AS od 
    JOIN `order` AS o 
    ON o.order_id = od.order_id 
    WHERE o.restaurant_id = restaurantId
    AND o.order_time >= startTime
    AND o.user_id = userId
    AND o.order_status LIKE '%已完成%'
    GROUP BY od.dish_id;
END $$
CREATE PROCEDURE GetLoyalCustomerIds(IN restaurantId INT, IN startTime TIMESTAMP, IN threshold INT)
BEGIN
    SELECT user_id
    FROM `order`
    WHERE restaurant_id = restaurantId
    AND order_time >= startTime
    AND order_status LIKE '%已完成%'
    GROUP BY user_id
    HAVING COUNT(user_id) >= threshold;
END $$

CREATE PROCEDURE GetActivityInOneDayForRestaurant(IN restaurantId INT, IN startTime TIMESTAMP)
BEGIN
    SELECT
        CASE 
            WHEN HOUR(order_time) BETWEEN 0 AND 5 THEN '夜间'
            WHEN HOUR(order_time) BETWEEN 6 AND 11 THEN '上午'
            WHEN HOUR(order_time) BETWEEN 12 AND 17 THEN '下午'
            WHEN HOUR(order_time) BETWEEN 18 AND 23 THEN '晚间'
        END AS period,
        count(order_id) as orderNum
    FROM `order`
    WHERE restaurant_id = restaurantId
    AND order_status LIKE '%已完成%'
    AND order_time >= startTime
    GROUP BY period
    ORDER BY period;
END $$
CREATE PROCEDURE GetMonthlyRevenues(IN restaurantId INT)
BEGIN
    SELECT MONTH(order_time) AS month,
        SUM(total_price) AS monthlyRevenue
    FROM `order`
    WHERE restaurant_id = restaurantId
    AND YEAR(order_time) = YEAR(CURRENT_DATE)
    AND order_status LIKE '%已完成%'
    GROUP BY MONTH(order_time)
    ORDER BY MONTH(order_time);
END $$

DELIMITER ;