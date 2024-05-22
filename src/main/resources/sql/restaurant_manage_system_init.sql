USE restaurant_manage_system;
--初始化一些用户
INSERT INTO user (user_id, password, user_name, gender, age, role, role_id) VALUES
(1, 'password1', '张伟', 1, '20', 0, 2021001),
(2, 'password2', '李娜', 0, '22', 0, 2021002),
(3, 'password3', '王伟', 1, '25', 1, 10001),
(4, 'password4', '王伟', 0, '30', 1, 10002),
(5, 'password5', '张敏', 1, '21', 0, 2021003),
(6, 'password6', '李娜', 0, '28', 0, 2021004),
(7, 'password7', '刘洋', 1, '23', 1, 10003),
(8, 'password8', '赵强', 0, '26', 1, 10004),
(9, 'password9', '张伟', 1, '24', 0, 2021005),
(10, 'password10', '孙丽', 0, '29', 1, 10005);
--初始化一些餐厅
INSERT INTO canteen (canteen_id, canteen_name, canteen_location) VALUES
(1, '旦苑餐厅', '邯郸校区'),
(2, '南苑餐厅', '邯郸校区'),
(3, '北区食堂', '邯郸校区'),
(4, '江湾食堂', '江湾校区'),
(5, '枫林西餐厅', '枫林校区'),
(6, '张江食堂', '张江校区');
--初始化一些商户
INSERT INTO restaurant (restaurant_id, restaurant_name, account, password, location, brief_intro, canteen_id) VALUES
(1, '麦当劳', 'mcdonalds1', 'mcdonalds123', '一楼东', '美式快餐 普通店', 1),
(2, '麦当劳', 'mcdonalds2', 'mcdonalds456', '一楼大厅', '美式快餐 旗舰店', 3),
(3, '麦当劳', 'mcdonalds3', 'mcdonalds789', '二楼北', '美式快餐 普通店', 1),
(4, '肯德基', 'kfc1', 'kfc123', '一楼西', '快餐连锁 旗舰店', 1),
(5, '肯德基', 'kfc2', 'kfc456', '二楼西', '快餐连锁 普通店', 4),
(6, '德克士', 'dicos1', 'dicos123', '二楼东', '快餐连锁 普通店', 1),
(7, '德克士', 'dicos2', 'dicos456', '二楼大厅', '快餐连锁 加盟店', 3),
(8, '星巴克', 'starbucks1', 'starbucks123', '一楼南', '咖啡连锁店 旗舰店', 5),
(9, '星巴克', 'starbucks2', 'starbucks456', '二楼水吧', '咖啡连锁店', 3),
(10, '全家便利店', 'familymart1', 'familymart123', '一楼大厅', '便利店连锁 直营店', 4),
(11, '全家便利店', 'familymart2', 'familymart456', '一楼南', '便利店连锁 直营店', 2),
(12, '吉野家', 'yoshinoya1', 'yoshinoya123', '二楼', '日式快餐 直营店', 2);
--初始化一些菜品
INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(1, '巨无霸', '汉堡', 20.00, '经典牛肉汉堡', './imgs/big_mac.jpg', 1, 1),
(2, '麦辣鸡腿堡', '汉堡', 16.00, '香辣鸡腿汉堡', './imgs/chicken_burger.jpg', 1, 1),
(3, '薯条', '小吃', 10.00, '金黄脆薯', './imgs/fries_1.jpg', 0, 1),
(4, '麦乐鸡', '小吃', 9.00, '鸡肉块', './imgs/nuggets_2.jpg', 0, 1),
(5, '可乐', '饮料', 5.00, '冰爽可乐', './imgs/cola_1.jpg', 0, 1),
(6, '巨无霸', '汉堡', 22.00, '经典牛肉汉堡', './imgs/big_mac.jpg', 1, 2),
(7, '麦辣鸡腿堡', '汉堡', 17.00, '香辣鸡腿汉堡', './imgs/chicken_burger.jpg', 0, 2),
(8, '薯条', '小吃', 10.00, '金黄脆薯', './imgs/fries_2.jpg', 1, 2),
(9, '麦乐鸡', '小吃', 15.00, '鸡肉块', './imgs/nuggets_1.jpg', 0, 2),
(10, '可乐', '饮料', 5.00, '冰爽可乐', './imgs/cola_2.jpg', 0, 2),
(11, '巨无霸', '汉堡', 25.00, '经典牛肉汉堡', './imgs/big_mac.jpg', 1, 3),
(12, '麦辣鸡腿堡', '汉堡', 18.00, '香辣鸡腿汉堡', './imgs/chicken_burger.jpg', 1, 3),
(13, '薯条', '小吃', 9.00, '金黄脆薯', './imgs/fries_2.jpg', 0, 3),
(14, '麦乐鸡', '小吃', 12.00, '鸡肉块', './imgs/nuggets_1.jpg', 1, 3),
(15, '可乐', '饮料', 3.00, '冰爽可乐', './imgs/cola_2.jpg', 0, 3);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(16, '原味鸡', '鸡肉', 12.00, '香脆原味鸡', './imgs/original_chicken.jpg', 1, 4),
(17, '香辣鸡翅', '鸡肉', 15.00, '香辣鸡翅', './imgs/spicy_wings_1.jpg', 1, 4),
(18, '田园鸡腿堡', '汉堡', 18.00, '美味鸡腿堡', './imgs/yummy_chicken_burger.jpg', 1, 4),
(19, '劲脆鸡腿堡', '汉堡', 20.00, '劲脆鸡腿堡', './imgs/crispy_burger.jpg', 1, 4),
(20, '九珍果汁', '饮料', 8.00, '新鲜果汁', './imgs/juice.jpg', 0, 4),
(21, '原味鸡', '鸡肉', 15.00, '香脆原味鸡', './imgs/original_chicken.jpg', 1, 5),
(22, '香辣鸡翅', '鸡肉', 15.00, '香辣鸡翅', './imgs/spicy_wings_2.jpg', 1, 5),
(23, '田园鸡腿堡', '汉堡', 18.00, '美味鸡腿堡', './imgs/yummy_chicken_burger.jpg', 0, 5),
(24, '劲脆鸡腿堡', '汉堡', 18.00, '劲脆鸡腿堡', './imgs/crispy_burger.jpg', 0, 5),
(25, '九珍果汁', '饮料', 8.00, '新鲜果汁', './imgs/juice.jpg', 0, 5);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(26, '脆皮炸鸡', '鸡肉', 14.00, '香脆炸鸡', './imgs/crispy_chicken.jpg', 1, 6),
(27, '鸡肉卷', '卷类', 12.00, '美味鸡肉卷', './imgs/chicken_wrap.jpg', 1, 6),
(28, '薯条', '小吃', 9.00, '金黄脆薯', './imgs/fries_3.jpg', 0, 6),
(29, '甜筒', '甜品', 6.00, '香草冰淇淋', './imgs/ice_cream.jpg', 0, 6),
(30, '柠檬茶', '饮料', 7.00, '清新柠檬茶', './imgs/lemon_tea.jpg', 0, 6),
(31, '脆皮炸鸡', '鸡肉', 15.00, '香脆炸鸡', './imgs/crispy_chicken.jpg', 1, 7),
(32, '鸡肉卷', '卷类', 13.00, '美味鸡肉卷', './imgs/chicken_wrap.jpg', 1, 7),
(33, '薯条', '小吃', 8.00, '金黄脆薯', './imgs/fries_3.jpg', 0, 7),
(34, '甜筒', '甜品', 5.00, '香草冰淇淋', './imgs/ice_cream.jpg', 0, 7),
(35, '柠檬茶', '饮料', 6.00, '清新柠檬茶', './imgs/lemon_tea.jpg', 0, 7);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(36, '拿铁', '咖啡', 28.00, '香浓拿铁', './imgs/latte.jpg', 1, 8),
(37, '抹茶星冰乐', '饮料', 32.00, '清新抹茶', './imgs/green_tea_frappe.jpg', 0, 8),
(38, '蓝莓麦芬', '甜品', 18.00, '蓝莓麦芬蛋糕', './imgs/blueberry_muffin.jpg', 0, 8),
(39, '美式咖啡', '咖啡', 25.00, '纯美式咖啡', './imgs/americano.jpg', 1, 9),
(40, '焦糖玛奇朵', '饮料', 35.00, '香甜焦糖玛奇朵', './imgs/caramel_macchiato.jpg', 0, 9),
(41, '巧克力蛋糕', '甜品', 20.00, '浓郁巧克力蛋糕', './imgs/chocolate_cake.jpg', 0, 9);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(42, '关东煮', '小吃', 15.00, '热腾腾的关东煮', './imgs/oden.jpg', 1, 10),
(43, '饭团', '主食', 8.00, '各种口味的饭团', './imgs/rice_ball.jpg', 1, 10),
(44, '乌龙茶', '饮料', 5.00, '清爽乌龙茶', './imgs/oolong_tea.jpg', 0, 10),
(45, '关东煮', '小吃', 16.00, '热腾腾的关东煮', './imgs/oden.jpg', 1, 11),
(46, '饭团', '主食', 9.00, '各种口味的饭团', './imgs/rice_ball.jpg', 1, 11),
(47, '红茶', '饮料', 6.00, '香浓红茶', './imgs/black_tea.jpg', 0, 11);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(48, '牛肉饭', '主食', 25.00, '经典牛肉饭', './imgs/beef_rice.jpg', 1, 12),
(49, '鸡肉饭', '主食', 22.00, '美味鸡肉饭', './imgs/chicken_rice.jpg', 1, 12),
(50, '味增汤', '汤类', 8.00, '传统味增汤', './imgs/miso_soup.jpg', 0, 12),
(51, '炸鸡块', '小吃', 15.00, '香脆炸鸡块', './imgs/fried_chicken.jpg', 0, 12),
(52, '绿茶', '饮料', 6.00, '清凉绿茶', './imgs/green_tea.jpg', 0, 12);

INSERT INTO manager (manager_id, account, manager_name, password) VALUES
(1, '22302010020', '王洋', '2230201020'),
(2, '22307130433', '刁子捷', '22307130433');


