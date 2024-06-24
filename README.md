# 食堂点餐系统
## 部署
1. 前往github上clone对应前端后端  
[前端](https://github.com/funny-ice-yeah/restaurant-system-frontend)

[后端](https://github.com/funny-ice-yeah/restaurant_manage_system)  
2. 在application.yml中修改对应的本地数据库连接
3. 运行[SQL](.\src\main\resources\sql)目录下的sql语句以初始化数据库
4. 运行对应前后端，在[http://localhost:5173/](http://localhost:5173/)进入登录界面。第一次登录可以通过账号`admin`和密码`123456789`进入管理员界面，查询对应商户或用户的账号或密码或创建自己的商户或用户账号。


## 查询需求
### 基础查询说明
1. 查询菜品及商户  
采用模糊查询，用户只需要输入部分文字就可以查询到对应店家或菜品，如“全家”-“全家便利店”

### 进阶查询需求说明
1. 菜品数据分析：商户可以查看某个商户所有菜品的评分、销量以及购买该菜品次数最多的人。   
在的`RestaurantController`层中调用`analyzeAllDishesByRestaurantId`方法。
  
- 评分：使用聚合函数AVG
- 销量：使用聚合函数SUM
- 购买次数最多的人：实现原理：  
  - 父查询按照 user_id 分组，计算每个用户购买该菜品的总数量。
  - 使用子查询找到购买该菜品最多的数量（MAX(customer_total_quantity)）。
  - 通过 HAVING 子句筛选出购买总数量等于最大数量的用户ID，并返回结果。这样可以查询所有符合最大值的客户
  
```SQL
    SELECT o.user_id
    FROM `order` AS o 
    JOIN order_detail AS od
    ON o.order_id = od.order_id
    WHERE od.dish_id = dishId -- the selected dish
    AND o.order_status LIKE '%已完成%'
    GROUP BY o.user_id -- user_id
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

```
2. 某用户收藏的各个菜品在一段时间（近一周，近一月，近一年）内不同点餐方式的销量可进行筛选。   
在`UserController`层中调用`getFavouriteDishSales`方法。  
- 在order和orderdetail中找某个时间前按照某个方法点单的菜品的总数`SUM`聚合
```SQL
    SELECT SUM(od.quantity) 
    FROM order_detail AS od 
    JOIN `order` AS o 
    ON o.order_id = od.order_id 
    WHERE od.dish_id = dishId --selected dish
    AND o.order_time >= timeStamp -- time calculated by JAVA backend
    AND o.order_status LIKE '%已完成%'
    AND o.order_method = orderMethod; -- selected method
```
3. 一段时间内某个商户的忠实粉丝在该商户的消费分布。（忠实粉丝：在该商户消费次数超过某个阈值的用户；消费分布：各个菜品购买次数）   
在`RestaurantController`层中调用`getLoyalCustomerDistribution`方法。
- 找到忠实粉丝
```SQL
    SELECT user_id
    FROM `order`
    WHERE restaurant_id = restaurantId
    AND order_time >= startTime
    AND order_status LIKE '%已完成%'
    GROUP BY user_id
    HAVING COUNT(user_id) >= threshold;
```
- 查询忠实粉丝的各个菜品的购买次数  
```SQL
    SELECT od.dish_id, SUM(od.quantity) AS total_purchase
    FROM order_detail AS od 
    JOIN `order` AS o 
    ON o.order_id = od.order_id 
    WHERE o.restaurant_id = restaurantId
    AND o.order_time >= startTime
    AND o.user_id = userId
    AND o.order_status LIKE '%已完成%'
    GROUP BY od.dish_id;
```
4. 用户活跃度分析：分析用户的活跃度模式，包括每周、每月点餐频率的变化趋势，以及用户在不同时间段的活跃程度。  
在`RestaurantController`层中调用`getOrderFrequency`以得到每周每月点餐频率的变化趋势，可以按照周/月/年来进行统计。调用`getActivityAnalysis`以得到用户在不同时间段的活跃程度。其中不同时间段的活跃程度统计过去一年中的数据。
- 点单频率:先规定数据格式，然后统计对应总的已完成订单数量即可。
```SQL
    SELECT
        CASE 
            WHEN #{period} = '周' THEN DATE_FORMAT(order_time, '%Y-%u')
            WHEN #{period} = '月' THEN DATE_FORMAT(order_time, '%Y-%m')
            ELSE DATE_FORMAT(order_time, '%Y-%m-%d')<!-- 默认格式为年-月-日 -->
        END AS period,         
        count(order_id) as orderNum
    FROM `order`
    WHERE restaurant_id = #{restaurantId}
    AND order_time >= #{startTime}
    AND order_status LIKE '%已完成%'         
    GROUP BY period
    ORDER BY period;

```  
- 不同时间段:将一天划分为四个时间段，统计某个商户的某个时间前的总订单数量
```SQL
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
```
5. 用户群体特征分析：根据用户的角色、年龄和性别等信息，对用户群体进行特征分析和评价习惯。  
在`RestaurantController`层中调用`getUserGroupAnalysis`方法以得到用户群体特征分析。
- 由JAVA后端规定对应的条件，先选择出对应的符合条件的用户，然后统计这一群体的订单数和平均评分。
```SQL
    SELECT COUNT(order_id) 
    FROM `order`
    WHERE user_id IN (SELECT sub.user_id FROM user AS sub WHERE ${condition})
    AND restaurant_id = #{restaurantId}
    AND order_status LIKE '%已完成%'; 
    -----------------------------------------------------------------------------------------------
    -----------------------------------------------------------------------------------------------
    SELECT od.dish_id, d.dish_name, SUM(od.quantity) AS totalSales
    FROM order_detail AS od
    JOIN `order` AS o ON od.order_id = o.order_id
    JOIN dish AS d ON od.dish_id = d.dish_id
    WHERE o.user_id IN (SELECT sub.user_id FROM user AS sub WHERE ${condition})
    AND o.restaurant_id = #{restaurantId}
    AND o.order_status LIKE '%已完成%'         
    GROUP BY od.dish_id, d.dish_name;
```
6. 月度流水查询：查询商户本年度每个月的营业额，供商户考察自己的盈利能力
在`RestaurantController`层中调用`getThisYearMonthlyRevenue`方法得到月度流水查询。
- 先将订单时间归到对应月份，然后按照月份统计已完成订单中总的营收。其中当年内的实现方法只需要确保订单时间与今日的年份相同。
```SQL
    SELECT MONTH(order_time) AS month,
        SUM(total_price) AS monthlyRevenue
    FROM `order`
    WHERE restaurant_id = restaurantId
    AND YEAR(order_time) = YEAR(CURRENT_DATE)
    AND order_status LIKE '%已完成%'
    GROUP BY MONTH(order_time)
    ORDER BY MONTH(order_time);
```
### 触发器
我们认为这次需求中：发送消息和记录价格比较适合用触发器来完成。然而我们对发送订单状态消息的规定如下：
> 当用户下单时，我们向Order表中插入一个订单，其状态为已预定，并发送信息。在用户的取餐时间前30分钟向用户发送确认消息，如果用户取消订单，则将状态状态改为已取消，并发送信息。如果用户没在取餐前20分钟没有回复，则默认用户确认，禁止用户取消。如果用户确认，则将订单状态改为准备中，并发送准备信息。商户将订单状态态改为已完成视为完成订单，并发送完成信息。ps：如果用户选择的取餐时间距当前小于20分钟，则直接将订单状态改为准备中，并发送准备信息。若大于20分钟小于30分钟，则直接向用户发送确认信息。

因此，考虑到引入了时间的特性，我们选择用Spring的定时任务来完成
- 价格历史
```SQL
CREATE TRIGGER after_dish_price_update
AFTER UPDATE ON dish
FOR EACH ROW
BEGIN
    IF NEW.current_price <> OLD.current_price THEN
        INSERT INTO price (dish_id, price)
        VALUES (NEW.dish_id, NEW.current_price);
    END IF;
END;
```
