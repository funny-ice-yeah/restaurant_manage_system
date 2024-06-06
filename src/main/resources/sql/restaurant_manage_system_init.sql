-- Active: 1716358865468@@127.0.0.1@3306@restaurant_manage_system
USE restaurant_manage_system;
-- 初始化一些用户
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
(10, 'password10', '孙丽', 0, '29', 1, 10005),
(11, '1', '王洋', 1, '21', 0, 22302010020);
-- 初始化一些餐厅
INSERT INTO canteen (canteen_id, canteen_name, canteen_location) VALUES
(1, '旦苑餐厅', '邯郸校区'),
(2, '南苑餐厅', '邯郸校区'),
(3, '北区食堂', '邯郸校区'),
(4, '江湾食堂', '江湾校区'),
(5, '枫林西餐厅', '枫林校区'),
(6, '张江食堂', '张江校区');
-- 初始化一些商户
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
-- 初始化一些菜品
INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(1, '巨无霸', '汉堡', 20.00, '经典牛肉汉堡', 'http://127.0.0.1:8080/images/dish/big_mac.jpg', 1, 1),
(2, '麦辣鸡腿堡', '汉堡', 16.00, '香辣鸡腿汉堡', 'http://127.0.0.1:8080/images/dish/chicken_burger.jpg', 1, 1),
(3, '薯条', '小吃', 10.00, '金黄脆薯', 'http://127.0.0.1:8080/images/dish/fries_1.jpg', 0, 1),
(4, '麦乐鸡', '小吃', 9.00, '鸡肉块', 'http://127.0.0.1:8080/images/dish/nuggets_2.jpg', 0, 1),
(5, '可乐', '饮料', 5.00, '冰爽可乐', 'http://127.0.0.1:8080/images/dish/cola_1.jpg', 0, 1),
(6, '巨无霸', '汉堡', 22.00, '经典牛肉汉堡', 'http://127.0.0.1:8080/images/dish/big_mac.jpg', 1, 2),
(7, '麦辣鸡腿堡', '汉堡', 17.00, '香辣鸡腿汉堡', 'http://127.0.0.1:8080/images/dish/chicken_burger.jpg', 0, 2),
(8, '薯条', '小吃', 10.00, '金黄脆薯', 'http://127.0.0.1:8080/images/dish/fries_2.jpg', 1, 2),
(9, '麦乐鸡', '小吃', 15.00, '鸡肉块', 'http://127.0.0.1:8080/images/dish/nuggets_1.jpg', 0, 2),
(10, '可乐', '饮料', 5.00, '冰爽可乐', 'http://127.0.0.1:8080/images/dish/cola_2.jpg', 0, 2),
(11, '巨无霸', '汉堡', 25.00, '经典牛肉汉堡', 'http://127.0.0.1:8080/images/dish/big_mac.jpg', 1, 3),
(12, '麦辣鸡腿堡', '汉堡', 18.00, '香辣鸡腿汉堡', 'http://127.0.0.1:8080/images/dish/chicken_burger.jpg', 1, 3),
(13, '薯条', '小吃', 9.00, '金黄脆薯', 'http://127.0.0.1:8080/images/dish/fries_2.jpg', 0, 3),
(14, '麦乐鸡', '小吃', 12.00, '鸡肉块', 'http://127.0.0.1:8080/images/dish/nuggets_1.jpg', 1, 3),
(15, '可乐', '饮料', 3.00, '冰爽可乐', 'http://127.0.0.1:8080/images/dish/cola_2.jpg', 0, 3);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(16, '原味鸡', '鸡肉', 12.00, '香脆原味鸡', 'http://127.0.0.1:8080/images/dish/original_chicken.jpg', 1, 4),
(17, '香辣鸡翅', '鸡肉', 15.00, '香辣鸡翅', 'http://127.0.0.1:8080/images/dish/spicy_wings_1.jpg', 1, 4),
(18, '田园鸡腿堡', '汉堡', 18.00, '美味鸡腿堡', 'http://127.0.0.1:8080/images/dish/yummy_chicken_burger.jpg', 1, 4),
(19, '劲脆鸡腿堡', '汉堡', 20.00, '劲脆鸡腿堡', 'http://127.0.0.1:8080/images/dish/crispy_burger.jpg', 1, 4),
(20, '九珍果汁', '饮料', 8.00, '新鲜果汁', 'http://127.0.0.1:8080/images/dish/juice.jpg', 0, 4),
(21, '原味鸡', '鸡肉', 15.00, '香脆原味鸡', 'http://127.0.0.1:8080/images/dish/original_chicken.jpg', 1, 5),
(22, '香辣鸡翅', '鸡肉', 15.00, '香辣鸡翅', 'http://127.0.0.1:8080/images/dish/spicy_wings_2.jpg', 1, 5),
(23, '田园鸡腿堡', '汉堡', 18.00, '美味鸡腿堡', 'http://127.0.0.1:8080/images/dish/yummy_chicken_burger.jpg', 0, 5),
(24, '劲脆鸡腿堡', '汉堡', 18.00, '劲脆鸡腿堡', 'http://127.0.0.1:8080/images/dish/crispy_burger.jpg', 0, 5),
(25, '九珍果汁', '饮料', 8.00, '新鲜果汁', 'http://127.0.0.1:8080/images/dish/juice.jpg', 0, 5);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(26, '脆皮炸鸡', '鸡肉', 14.00, '香脆炸鸡', 'http://127.0.0.1:8080/images/dish/crispy_chicken.jpg', 1, 6),
(27, '鸡肉卷', '卷类', 12.00, '美味鸡肉卷', 'http://127.0.0.1:8080/images/dish/chicken_wrap.jpg', 1, 6),
(28, '薯条', '小吃', 9.00, '金黄脆薯', 'http://127.0.0.1:8080/images/dish/fries_3.jpg', 0, 6),
(29, '甜筒', '甜品', 6.00, '香草冰淇淋', 'http://127.0.0.1:8080/images/dish/ice_cream.jpg', 0, 6),
(30, '柠檬茶', '饮料', 7.00, '清新柠檬茶', 'http://127.0.0.1:8080/images/dish/lemon_tea.jpg', 0, 6),
(31, '脆皮炸鸡', '鸡肉', 15.00, '香脆炸鸡', 'http://127.0.0.1:8080/images/dish/crispy_chicken.jpg', 1, 7),
(32, '鸡肉卷', '卷类', 13.00, '美味鸡肉卷', 'http://127.0.0.1:8080/images/dish/chicken_wrap.jpg', 1, 7),
(33, '薯条', '小吃', 8.00, '金黄脆薯', 'http://127.0.0.1:8080/images/dish/fries_3.jpg', 0, 7),
(34, '甜筒', '甜品', 5.00, '香草冰淇淋', 'http://127.0.0.1:8080/images/dish/ice_cream.jpg', 0, 7),
(35, '柠檬茶', '饮料', 6.00, '清新柠檬茶', 'http://127.0.0.1:8080/images/dish/lemon_tea.jpg', 0, 7);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(36, '拿铁', '咖啡', 28.00, '香浓拿铁', 'http://127.0.0.1:8080/images/dish/latte.jpg', 1, 8),
(37, '抹茶星冰乐', '饮料', 32.00, '清新抹茶', 'http://127.0.0.1:8080/images/dish/green_tea_frappe.jpg', 0, 8),
(38, '蓝莓麦芬', '甜品', 18.00, '蓝莓麦芬蛋糕', 'http://127.0.0.1:8080/images/dish/blueberry_muffin.jpg', 0, 8),
(39, '美式咖啡', '咖啡', 25.00, '纯美式咖啡', 'http://127.0.0.1:8080/images/dish/americano.jpg', 1, 9),
(40, '焦糖玛奇朵', '饮料', 35.00, '香甜焦糖玛奇朵', 'http://127.0.0.1:8080/images/dish/caramel_macchiato.jpg', 0, 9),
(41, '巧克力蛋糕', '甜品', 20.00, '浓郁巧克力蛋糕', 'http://127.0.0.1:8080/images/dish/chocolate_cake.jpg', 0, 9);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(42, '关东煮', '小吃', 15.00, '热腾腾的关东煮', 'http://127.0.0.1:8080/images/dish/oden.jpg', 1, 10),
(43, '饭团', '主食', 8.00, '各种口味的饭团', 'http://127.0.0.1:8080/images/dish/rice_ball.jpg', 1, 10),
(44, '乌龙茶', '饮料', 5.00, '清爽乌龙茶', 'http://127.0.0.1:8080/images/dish/oolong_tea.jpg', 0, 10),
(45, '关东煮', '小吃', 16.00, '热腾腾的关东煮', 'http://127.0.0.1:8080/images/dish/oden.jpg', 1, 11),
(46, '饭团', '主食', 9.00, '各种口味的饭团', 'http://127.0.0.1:8080/images/dish/rice_ball.jpg', 1, 11),
(47, '红茶', '饮料', 6.00, '香浓红茶', 'http://127.0.0.1:8080/images/dish/black_tea.jpg', 0, 11);

INSERT INTO dish (dish_id, dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) VALUES
(48, '牛肉饭', '主食', 25.00, '经典牛肉饭', 'http://127.0.0.1:8080/images/dish/beef_rice.jpg', 1, 12),
(49, '鸡肉饭', '主食', 22.00, '美味鸡肉饭', 'http://127.0.0.1:8080/images/dish/chicken_rice.jpg', 1, 12),
(50, '味增汤', '汤类', 8.00, '传统味增汤', 'http://127.0.0.1:8080/images/dish/miso_soup.jpg', 0, 12),
(51, '炸鸡块', '小吃', 15.00, '香脆炸鸡块', 'http://127.0.0.1:8080/images/dish/fried_chicken.jpg', 0, 12),
(52, '绿茶', '饮料', 6.00, '清凉绿茶', 'http://127.0.0.1:8080/images/dish/green_tea.jpg', 0, 12);

INSERT INTO manager (manager_id, account, manager_name, password) VALUES
(1, '22302010020', '王洋', '2230201020'),
(2, '22307130433', '刁子捷', '22307130433');

INSERT INTO allergy (dish_id, allergy) VALUES
(1, '麸质'),
(1, '乳制品'),
(2, '麸质'),
(2, '大豆'),
(3, '无'),
(4, '无'),
(5, '无'),
(6, '麸质'),
(6, '乳制品'),
(7, '麸质'),
(7, '大豆'),
(8, '无'),
(9, '无'),
(10, '无'),
(11, '麸质'),
(11, '乳制品'),
(12, '麸质'),
(12, '大豆'),
(13, '无'),
(14, '无'),
(15, '无'),
(16, '麸质'),
(16, '乳制品'),
(17, '麸质'),
(17, '鸡蛋'),
(18, '麸质'),
(18, '鸡蛋'),
(19, '麸质'),
(19, '鸡蛋'),
(20, '无'),
(21, '麸质'),
(21, '乳制品'),
(22, '麸质'),
(22, '鸡蛋'),
(23, '麸质'),
(23, '鸡蛋'),
(24, '麸质'),
(24, '鸡蛋'),
(25, '无'),
(26, '麸质'),
(26, '乳制品'),
(27, '麸质'),
(27, '鸡蛋'),
(28, '无'),
(29, '乳制品'),
(29, '鸡蛋'),
(30, '无'),
(31, '麸质'),
(31, '乳制品'),
(32, '麸质'),
(32, '鸡蛋'),
(33, '无'),
(34, '乳制品'),
(34, '鸡蛋'),
(35, '无'),
(36, '乳制品'),
(37, '乳制品'),
(38, '乳制品'),
(38, '鸡蛋'),
(39, '无'),
(40, '乳制品'),
(40, '鸡蛋'),
(41, '乳制品'),
(41, '鸡蛋'),
(42, '无'),
(43, '麸质'),
(44, '无'),
(45, '无'),
(46, '麸质'),
(47, '无'),
(48, '麸质'),
(48, '牛肉'),
(49, '麸质'),
(49, '鸡肉'),
(50, '大豆'),
(51, '无'),
(52, '无');

INSERT INTO ingredient (dish_id, ingredient) VALUES
(1, '牛肉'),
(1, '面包'),
(1, '生菜'),
(1, '洋葱'),
(1, '芝士'),
(1, '酱汁'),
(2, '鸡肉'),
(2, '面包'),
(2, '生菜'),
(2, '辣椒酱'),
(3, '土豆'),
(3, '盐'),
(3, '油'),
(4, '鸡肉'),
(4, '面粉'),
(4, '盐'),
(4, '胡椒'),
(5, '碳酸水'),
(5, '糖'),
(5, '焦糖色'),
(6, '牛肉'),
(6, '面包'),
(6, '生菜'),
(6, '洋葱'),
(6, '芝士'),
(6, '酱汁'),
(7, '鸡肉'),
(7, '面包'),
(7, '生菜'),
(7, '辣椒酱'),
(8, '土豆'),
(8, '盐'),
(8, '油'),
(9, '鸡肉'),
(9, '面粉'),
(9, '盐'),
(9, '胡椒'),
(10, '碳酸水'),
(10, '糖'),
(10, '焦糖色'),
(11, '牛肉'),
(11, '面包'),
(11, '生菜'),
(11, '洋葱'),
(11, '芝士'),
(11, '酱汁'),
(12, '鸡肉'),
(12, '面包'),
(12, '生菜'),
(12, '辣椒酱'),
(13, '土豆'),
(13, '盐'),
(13, '油'),
(14, '鸡肉'),
(14, '面粉'),
(14, '盐'),
(14, '胡椒'),
(15, '碳酸水'),
(15, '糖'),
(15, '焦糖色'),
(16, '鸡肉'),
(16, '面粉'),
(16, '盐'),
(16, '胡椒'),
(17, '鸡肉'),
(17, '辣椒粉'),
(17, '盐'),
(17, '胡椒'),
(18, '鸡肉'),
(18, '面包'),
(18, '生菜'),
(18, '番茄'),
(18, '酱汁'),
(19, '鸡肉'),
(19, '面包'),
(19, '生菜'),
(19, '番茄'),
(19, '酱汁'),
(20, '多种水果'),
(20, '糖'),
(21, '鸡肉'),
(21, '面粉'),
(21, '盐'),
(21, '胡椒'),
(22, '鸡肉'),
(22, '辣椒粉'),
(22, '盐'),
(22, '胡椒'),
(23, '鸡肉'),
(23, '面包'),
(23, '生菜'),
(23, '番茄'),
(23, '酱汁'),
(24, '鸡肉'),
(24, '面包'),
(24, '生菜'),
(24, '番茄'),
(24, '酱汁'),
(25, '多种水果'),
(25, '糖'),
(26, '鸡肉'),
(26, '面粉'),
(26, '盐'),
(26, '胡椒'),
(27, '鸡肉'),
(27, '面粉'),
(27, '盐'),
(27, '胡椒'),
(27, '玉米饼'),
(28, '土豆'),
(28, '盐'),
(28, '油'),
(29, '牛奶'),
(29, '糖'),
(29, '香草精'),
(30, '茶叶'),
(30, '柠檬'),
(30, '糖'),
(31, '鸡肉'),
(31, '面粉'),
(31, '盐'),
(31, '胡椒'),
(32, '鸡肉'),
(32, '面粉'),
(32, '盐'),
(32, '胡椒'),
(32, '玉米饼'),
(33, '土豆'),
(33, '盐'),
(33, '油'),
(34, '牛奶'),
(34, '糖'),
(34, '香草精'),
(35, '茶叶'),
(35, '柠檬'),
(35, '糖'),
(36, '牛奶'),
(36, '咖啡'),
(36, '糖'),
(37, '抹茶粉'),
(37, '牛奶'),
(37, '糖'),
(38, '面粉'),
(38, '蓝莓'),
(38, '糖'),
(38, '鸡蛋'),
(39, '咖啡'),
(39, '水'),
(40, '牛奶'),
(40, '咖啡'),
(40, '焦糖'),
(41, '面粉'),
(41, '巧克力'),
(41, '糖'),
(41, '鸡蛋'),
(42, '多种食材'),
(42, '鱼丸'),
(42, '萝卜'),
(42, '鸡蛋'),
(43, '米'),
(43, '海苔'),
(43, '多种配料'),
(44, '茶叶'),
(44, '水'),
(45, '多种食材'),
(45, '鱼丸'),
(45, '萝卜'),
(45, '鸡蛋'),
(46, '米'),
(46, '海苔'),
(46, '多种配料'),
(47, '茶叶'),
(47, '水'),
(48, '牛肉'),
(48, '米'),
(48, '洋葱'),
(48, '酱油'),
(49, '鸡肉'),
(49, '米'),
(49, '酱油'),
(49, '洋葱'),
(50, '豆腐'),
(50, '味增'),
(50, '海带'),
(51, '鸡肉'),
(51, '面粉'),
(51, '盐'),
(51, '胡椒'),
(52, '茶叶'),
(52, '水');

INSERT INTO nutrition (dish_id, nutrition) VALUES
(1, '高蛋白'),
(1, '高脂肪'),
(1, '高碳水化合物'),
(2, '高蛋白'),
(2, '高脂肪'),
(2, '高碳水化合物'),
(3, '高碳水化合物'),
(3, '低脂肪'),
(4, '高蛋白'),
(4, '高脂肪'),
(5, '高糖分'),
(6, '高蛋白'),
(6, '高脂肪'),
(6, '高碳水化合物'),
(7, '高蛋白'),
(7, '高脂肪'),
(7, '高碳水化合物'),
(8, '高碳水化合物'),
(8, '低脂肪'),
(9, '高蛋白'),
(9, '高脂肪'),
(10, '高糖分'),
(11, '高蛋白'),
(11, '高脂肪'),
(11, '高碳水化合物'),
(12, '高蛋白'),
(12, '高脂肪'),
(12, '高碳水化合物'),
(13, '高碳水化合物'),
(13, '低脂肪'),
(14, '高蛋白'),
(14, '高脂肪'),
(15, '高糖分'),
(16, '高蛋白'),
(16, '高脂肪'),
(17, '高蛋白'),
(17, '高脂肪'),
(18, '高蛋白'),
(18, '高脂肪'),
(18, '高碳水化合物'),
(19, '高蛋白'),
(19, '高脂肪'),
(19, '高碳水化合物'),
(20, '高糖分'),
(21, '高蛋白'),
(21, '高脂肪'),
(22, '高蛋白'),
(22, '高脂肪'),
(23, '高蛋白'),
(23, '高脂肪'),
(23, '高碳水化合物'),
(24, '高蛋白'),
(24, '高脂肪'),
(24, '高碳水化合物'),
(25, '高糖分'),
(26, '高蛋白'),
(26, '高脂肪'),
(27, '高蛋白'),
(27, '高脂肪'),
(27, '高碳水化合物'),
(28, '高碳水化合物'),
(28, '低脂肪'),
(29, '高糖分'),
(29, '高脂肪'),
(30, '低脂肪'),
(30, '高糖分'),
(31, '高蛋白'),
(31, '高脂肪'),
(32, '高蛋白'),
(32, '高脂肪'),
(32, '高碳水化合物'),
(33, '高碳水化合物'),
(33, '低脂肪'),
(34, '高糖分'),
(34, '高脂肪'),
(35, '低脂肪'),
(35, '高糖分'),
(36, '高糖分'),
(36, '高脂肪'),
(37, '高糖分'),
(37, '高脂肪'),
(38, '高糖分'),
(38, '高脂肪'),
(39, '低脂肪'),
(40, '高糖分'),
(40, '高脂肪'),
(41, '高糖分'),
(41, '高脂肪'),
(42, '高蛋白'),
(42, '低脂肪'),
(43, '高碳水化合物'),
(43, '低脂肪'),
(44, '低脂肪'),
(45, '高蛋白'),
(45, '低脂肪'),
(46, '高碳水化合物'),
(46, '低脂肪'),
(47, '低脂肪'),
(48, '高蛋白'),
(48, '高碳水化合物'),
(49, '高蛋白'),
(49, '高碳水化合物'),
(50, '高蛋白'),
(50, '低脂肪'),
(51, '高蛋白'),
(51, '高脂肪'),
(52, '低脂肪');

-- 订单数据
INSERT INTO `order` (order_id, order_status, order_time, order_method, total_price, user_id, restaurant_id) VALUES
(1, '已完成', '2024-05-01 12:34:56', '线上', 55.00, 1, 1),
(2, '已完成', '2024-05-02 14:21:12', '排队', 45.00, 2, 2),
(3, '已取消', '2024-05-03 16:45:30', '线上', 30.00, 3, 3),
(4, '已完成', '2024-05-04 18:22:45', '排队', 60.00, 4, 4),
(5, '已取消', '2024-05-05 20:10:05', '线上', 75.00, 5, 5),
(6, '已完成', '2024-05-06 12:11:25', '排队', 25.00, 6, 6),
(7, '已取消', '2024-05-07 13:30:50', '线上', 50.00, 7, 7),
(8, '已取消', '2024-05-08 15:40:15', '排队', 40.00, 8, 8),
(9, '已完成', '2024-05-09 17:00:00', '排队', 35.00, 9, 9),
(10, '已完成', '2024-05-10 19:20:10', '线上', 80.00, 10, 10),
(11, '已完成', '2024-05-11 12:30:45', '排队', 35.50, 2, 1),
(12, '已完成', '2024-05-12 14:25:10', '线上', 42.00, 3, 2),
(13, '已取消', '2024-05-13 16:10:20', '排队', 58.00, 4, 3),
(14, '已完成', '2024-05-14 18:45:30', '线上', 20.00, 5, 4),
(15, '已完成', '2024-05-15 11:00:00', '排队', 65.00, 6, 5),
(16, '已完成', '2024-05-16 12:55:40', '线上', 29.00, 7, 6),
(17, '已完成', '2024-05-17 13:35:20', '排队', 50.00, 8, 7),
(18, '已取消', '2024-05-18 15:25:00', '线上', 37.50, 9, 8),
(19, '已完成', '2024-05-19 17:15:10', '排队', 28.00, 10, 9),
(20, '已完成', '2024-05-20 19:05:25', '线上', 75.00, 1, 10),
(21, '已完成', '2024-05-21 11:55:40', '排队', 40.00, 2, 11),
(22, '已完成', '2024-05-22 13:45:55', '线上', 55.00, 3, 12),
(23, '已取消', '2024-05-23 15:35:05', '排队', 38.00, 4, 1),
(24, '已完成', '2024-05-24 17:25:15', '线上', 60.00, 5, 2),
(25, '已完成', '2024-05-25 19:15:30', '排队', 45.00, 6, 3),
(26, '已取消', '2024-05-26 12:05:40', '线上', 30.00, 7, 4),
(27, '已完成', '2024-05-27 13:55:55', '排队', 70.00, 8, 5),
(28, '已取消', '2024-05-28 15:45:05', '线上', 25.00, 9, 6),
(29, '已完成', '2024-05-29 17:35:15', '排队', 35.00, 10, 7),
(30, '已完成', '2024-05-30 19:25:30', '线上', 50.00, 1, 8);

-- 订单详情数据
INSERT INTO order_detail (quantity, order_id, dish_id) VALUES
(2, 1, 1),
(1, 1, 3),
(3, 2, 6),
(2, 2, 8),
(1, 3, 11),
(1, 4, 16),
(2, 5, 21),
(1, 5, 23),
(1, 6, 26),
(1, 6, 29),
(2, 7, 31),
(1, 8, 36),
(1, 8, 38),
(1, 9, 42),
(2, 9, 44),
(1, 10, 48),
(1, 10, 50),
(1, 10, 51),
(2, 11, 2),
(1, 11, 4),
(1, 12, 7),
(3, 12, 9),
(1, 13, 12),
(2, 13, 14),
(1, 14, 18),
(1, 15, 21),
(1, 15, 23),
(2, 16, 27),
(1, 17, 30),
(2, 17, 32),
(1, 18, 35),
(1, 19, 39),
(2, 19, 41),
(1, 20, 43),
(1, 21, 46),
(2, 22, 48),
(1, 22, 50),
(2, 23, 3),
(1, 24, 5),
(2, 25, 6),
(1, 25, 9),
(1, 26, 10),
(2, 27, 11),
(1, 28, 13),
(2, 29, 15),
(1, 30, 16),
(2, 30, 19),
(1, 30, 20),
(1, 30, 22),
(1, 30, 24),
(2, 30, 26),
(1, 30, 28),
(2, 30, 29),
(1, 30, 32),
(1, 30, 34),
(2, 30, 36),
(1, 30, 38),
(2, 30, 40);

-- 价格历史数据
INSERT INTO price (dish_id, price, create_at) VALUES
(1, 18.00, '2023-12-01 10:00:00'),
(1, 19.00, '2024-01-15 11:30:00'),
(1, 20.00, '2024-03-10 09:45:00'),
(2, 15.00, '2023-11-20 14:20:00'),
(2, 16.00, '2024-02-01 10:10:00'),
(3, 9.00, '2024-01-05 13:00:00'),
(3, 10.00, '2024-04-20 16:45:00'),
(4, 8.00, '2023-12-25 12:30:00'),
(4, 9.00, '2024-03-01 14:00:00'),
(5, 4.50, '2024-01-10 11:00:00'),
(5, 5.00, '2024-05-01 18:20:00'),
(6, 21.00, '2024-02-20 10:15:00'),
(6, 22.00, '2024-04-10 12:45:00'),
(7, 17.00, '2024-03-15 15:00:00'),
(8, 10.00, '2024-04-25 13:00:00'),
(9, 14.00, '2023-11-30 14:45:00'),
(9, 15.00, '2024-02-28 12:15:00'),
(10, 4.50, '2024-01-20 11:45:00'),
(10, 5.00, '2024-04-20 16:30:00'),
(11, 25.00, '2024-05-15 17:00:00'),
(12, 17.00, '2024-02-10 11:00:00'),
(12, 18.00, '2024-04-10 12:45:00'),
(13, 8.50, '2024-01-25 10:00:00'),
(13, 9.00, '2024-04-25 13:00:00'),
(14, 11.00, '2023-11-30 14:45:00'),
(14, 12.00, '2024-02-28 12:15:00'),
(15, 2.50, '2024-01-20 11:45:00'),
(15, 3.00, '2024-04-20 16:30:00'),
(16, 11.00, '2024-02-10 14:00:00'),
(16, 12.00, '2024-05-10 18:45:00'),
(17, 14.00, '2023-11-10 12:00:00'),
(17, 15.00, '2024-03-20 13:15:00'),
(18, 17.00, '2024-01-30 14:30:00'),
(18, 18.00, '2024-05-15 12:00:00'),
(19, 20.00, '2024-04-10 12:45:00'),
(20, 7.50, '2023-12-15 13:30:00'),
(20, 8.00, '2024-03-15 15:00:00'),
(21, 15.00, '2024-04-25 13:00:00'),
(22, 14.00, '2023-11-30 14:45:00'),
(22, 15.00, '2024-02-28 12:15:00'),
(23, 18.00, '2024-04-20 16:30:00'),
(24, 17.00, '2024-02-10 14:00:00'),
(24, 18.00, '2024-05-10 18:45:00'),
(25, 8.00, '2024-03-20 13:15:00'),
(26, 13.00, '2024-01-30 14:30:00'),
(26, 14.00, '2024-05-15 12:00:00'),
(27, 11.00, '2024-02-20 10:15:00'),
(27, 12.00, '2024-04-10 12:45:00'),
(28, 8.00, '2023-12-15 13:30:00'),
(28, 9.00, '2024-03-15 15:00:00'),
(29, 5.00, '2024-01-25 10:00:00'),
(29, 6.00, '2024-04-25 13:00:00'),
(30, 6.00, '2023-11-30 14:45:00'),
(30, 7.00, '2024-02-28 12:15:00'),
(31, 14.00, '2024-01-20 11:45:00'),
(31, 15.00, '2024-04-20 16:30:00'),
(32, 12.00, '2024-02-10 14:00:00'),
(32, 13.00, '2024-05-10 18:45:00'),
(33, 7.00, '2023-11-10 12:00:00'),
(33, 8.00, '2024-03-20 13:15:00'),
(34, 4.50, '2024-01-30 14:30:00'),
(34, 5.00, '2024-05-15 12:00:00'),
(35, 5.50, '2024-02-20 10:15:00'),
(35, 6.00, '2024-04-10 12:45:00'),
(36, 26.00, '2023-12-15 13:30:00'),
(36, 28.00, '2024-03-15 15:00:00'),
(37, 30.00, '2024-01-25 10:00:00'),
(37, 32.00, '2024-04-25 13:00:00'),
(38, 17.00, '2023-11-30 14:45:00'),
(38, 18.00, '2024-02-28 12:15:00'),
(39, 24.00, '2024-01-20 11:45:00'),
(39, 25.00, '2024-04-20 16:30:00'),
(40, 33.00, '2024-02-10 14:00:00'),
(40, 35.00, '2024-05-10 18:45:00'),
(41, 19.00, '2023-11-10 12:00:00'),
(41, 20.00, '2024-03-20 13:15:00'),
(42, 14.00, '2024-01-30 14:30:00'),
(42, 15.00, '2024-05-15 12:00:00'),
(43, 7.00, '2024-02-20 10:15:00'),
(43, 8.00, '2024-04-10 12:45:00'),
(44, 4.50, '2023-12-15 13:30:00'),
(44, 5.00, '2024-03-15 15:00:00'),
(45, 15.00, '2024-01-25 10:00:00'),
(45, 16.00, '2024-04-25 13:00:00'),
(46, 8.00, '2023-11-30 14:45:00'),
(46, 9.00, '2024-02-28 12:15:00'),
(47, 5.00, '2024-01-20 11:45:00'),
(47, 6.00, '2024-04-20 16:30:00'),
(48, 24.00, '2024-02-10 14:00:00'),
(48, 25.00, '2024-05-10 18:45:00'),
(49, 21.00, '2023-11-10 12:00:00'),
(49, 22.00, '2024-03-20 13:15:00'),
(50, 7.00, '2024-01-30 14:30:00'),
(50, 8.00, '2024-05-15 12:00:00'),
(51, 14.00, '2024-02-20 10:15:00'),
(51, 15.00, '2024-04-10 12:45:00'),
(52, 6.00, '2024-03-15 15:00:00');

-- 座位数据
INSERT INTO seat (canteen_id, location, status) VALUES
(1, '1号厅', '空闲'),
(1, '2号厅', '使用中'),
(1, '3号厅', '空闲'),
(1, '4号厅', '维修中'),
(2, '1号厅', '使用中'),
(2, '2号厅', '空闲'),
(2, '3号厅', '维修中'),
(2, '4号厅', '使用中'),
(3, '1号厅', '空闲'),
(3, '2号厅', '使用中'),
(3, '3号厅', '空闲'),
(3, '4号厅', '维修中'),
(4, '1号厅', '使用中'),
(4, '2号厅', '空闲'),
(4, '3号厅', '维修中'),
(4, '4号厅', '使用中'),
(5, '1号厅', '空闲'),
(5, '2号厅', '使用中'),
(5, '3号厅', '空闲'),
(5, '4号厅', '维修中'),
(6, '1号厅', '空闲'),
(6, '2号厅', '空闲'),
(6, '3号厅', '空闲'),
(6, '4号厅', '空闲');

-- 座位预订数据
INSERT INTO seat_reservation (seat_id, user_id, canteen_id, time_booked, create_at, status) VALUES
(1, 1, 1, '2024-05-25 12:00:00', '2024-05-24 10:00:00', '已完成'),
(2, 2, 1, '2024-05-25 13:00:00', '2024-05-24 10:30:00', '已取消'),
(3, 3, 1, '2024-05-25 14:00:00', '2024-05-24 11:00:00', '已完成'),
(4, 4, 1, '2024-05-25 15:00:00', '2024-05-24 11:30:00', '已完成'),
(5, 5, 2, '2024-05-25 12:00:00', '2024-05-24 12:00:00', '已完成'),
(6, 6, 2, '2024-05-25 13:00:00', '2024-05-24 12:30:00', '已完成'),
(7, 7, 2, '2024-05-25 14:00:00', '2024-05-24 13:00:00', '已取消'),
(8, 8, 2, '2024-05-25 15:00:00', '2024-05-24 13:30:00', '已完成'),
(9, 9, 3, '2024-05-25 12:00:00', '2024-05-24 14:00:00', '已完成'),
(10, 10, 3, '2024-05-25 13:00:00', '2024-05-24 14:30:00', '已取消'),
(11, 1, 3, '2024-05-25 14:00:00', '2024-05-24 15:00:00', '已取消'),
(12, 2, 3, '2024-05-25 15:00:00', '2024-05-24 15:30:00', '已完成'),
(13, 3, 4, '2024-05-25 12:00:00', '2024-05-24 16:00:00', '已完成'),
(14, 4, 4, '2024-05-25 13:00:00', '2024-05-24 16:30:00', '已完成'),
(15, 5, 4, '2024-05-25 14:00:00', '2024-05-24 17:00:00', '已取消'),
(16, 6, 4, '2024-05-25 15:00:00', '2024-05-24 17:30:00', '已完成'),
(17, 7, 5, '2024-05-25 12:00:00', '2024-05-24 18:00:00', '已完成'),
(18, 8, 5, '2024-05-25 13:00:00', '2024-05-24 18:30:00', '已完成'),
(19, 9, 5, '2024-05-25 14:00:00', '2024-05-24 19:00:00', '已取消'),
(20, 10, 5, '2024-05-25 15:00:00', '2024-05-24 19:30:00', '已取消'),
(21, 1, 6, '2024-05-25 12:00:00', '2024-05-24 20:00:00', '已取消'),
(22, 2, 6, '2024-05-25 13:00:00', '2024-05-24 20:30:00', '已取消'),
(23, 3, 6, '2024-05-25 14:00:00', '2024-05-24 21:00:00', '已完成'),
(24, 4, 6, '2024-05-25 15:00:00', '2024-05-24 21:30:00', '已取消');

-- 示例插入数据到 favorite_dish 表
INSERT INTO favorite_dish (user_id, dish_id) VALUES
(1, 1),
(1, 3),
(2, 5),
(2, 10),
(3, 2),
(3, 7),
(4, 4),
(4, 8),
(5, 6),
(5, 9),
(6, 11),
(6, 14),
(7, 12),
(7, 15),
(8, 13),
(8, 20),
(9, 18),
(9, 22),
(10, 21),
(10, 25);

-- 示例插入数据到 favorite_restaurant 表
INSERT INTO favorite_restaurant (user_id, restaurant_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10),
(6, 11),
(6, 12),
(7, 1),
(7, 3),
(8, 5),
(8, 7),
(9, 9),
(9, 11),
(10, 2),
(10, 4);

INSERT INTO restaurant_review(review_id,content,rating,user_id,restaurant_id) VALUES
-- 好评
(1, '这里的汉堡味道很好，服务也很周到。', 5, 1, 1),
(2, '环境很干净，食物也很好吃。', 5, 1, 2),
(3, '服务态度一般，食物质量还可以。', 3, 2, 3),
(4, '这里的炸鸡很美味，环境也不错。', 5, 2, 4),
(5, '价格合理，食物很美味。', 5, 3, 5),
(6, '服务速度有点慢，但食物很好吃。', 3, 3, 6),
(7, '可乐好喝，环境很舒适。', 5, 4, 7),
(8, '饮料口味不错。', 4, 4, 8),
(9, '咖啡好喝', 5, 5, 9),
(10, '便利店的商品很齐全，价格也合理。', 4, 5, 10),
(11, '很方便', 5, 6, 11),
(12, '餐厅环境很好，服务也不错。', 4, 6, 12),
(13, '食物味道很好，价格也合理。', 4, 7, 1),
(14, '服务态度很好，食物也很新鲜。', 5, 7, 2),
(15, '这里的饮品很美味，环境也很舒适。', 5, 8, 3),
(16, '炸鸡很好吃，价格也合理。', 5, 8, 4),
(17, '这里的面条很好吃，环境也不错。', 4, 9, 5),
(18, '薯条好吃。', 5, 9, 6),
(19, '汉堡味道不错', 5, 10, 7),
(20, '很舒服', 5, 10, 8),
(21, '环境很干净', 5, 11, 9),
(22, '关东煮味道不错', 5, 11, 10),

-- 差评
(23, '汉堡味道很差，服务态度也不好。', 1, 1, 1),
(24, '环境很脏。', 2, 1, 2),
(25, '服务态度很差。', 1, 2, 3),
(26, '炸鸡不好吃，环境也很差。', 2, 2, 4),
(27, '价格太贵，食物很难吃。', 1, 3, 5),
(28, '服务速度很慢，食物也不好吃。', 2, 3, 6),
(29, '环境也很糟糕。', 1, 4, 7),
(30, '价格太贵', 2, 4, 8),
(31, '很吵闹。', 1, 5, 9),
(32, '不好吃，环境也很差。', 2, 5, 10),
(33, '饮料过期了，服务态度也很差。', 1, 6, 11),
(34, '餐厅环境很差，服务也不好。', 2, 6, 12),
(35, '食物味道很差，价格也很贵。', 1, 7, 1),
(36, '食物不新鲜。', 2, 7, 2);

INSERT INTO dish_review (review_id, content, rating, user_id, dish_id) VALUES
(1, '这个巨无霸汉堡真的非常好吃！强烈推荐。', 5, 1, 1),
(2, '麦辣鸡腿堡非常美味，辣味刚刚好！', 5, 2, 2),
(3, '薯条又脆又金黄，正是我喜欢的口感。', 4, 3, 3),
(4, '麦乐鸡非常嫩滑，每一口都是享受。', 4, 4, 4),
(5, '冰爽可乐非常解渴，搭配汉堡简直完美。', 5, 5, 5),
(6, '这个巨无霸汉堡真的非常好吃！强烈推荐。', 5, 6, 6),
(7, '麦辣鸡腿堡非常美味，辣味刚刚好！', 5, 7, 7),
(8, '薯条又脆又金黄，正是我喜欢的口感。', 4, 8, 8),
(9, '麦乐鸡非常嫩滑，每一口都是享受。', 4, 9, 9),
(10, '冰爽可乐非常解渴，搭配汉堡简直完美。', 5, 10, 10),
(11, '巨无霸汉堡真的是经典中的经典，好吃极了！', 5, 1, 11),
(12, '麦辣鸡腿堡非常好吃，值得一试。', 5, 2, 12),
(13, '薯条很好吃，口感很脆。', 4, 3, 13),
(14, '麦乐鸡好吃又便宜，推荐！', 4, 4, 14),
(15, '可乐冰爽，非常解渴。', 5, 5, 15),
(16, '原味鸡真的很香，吃完还想再来一份。', 5, 1, 16),
(17, '香辣鸡翅非常美味，辣味适中。', 5, 2, 17),
(18, '田园鸡腿堡非常好吃，口感丰富。', 5, 3, 18),
(19, '劲脆鸡腿堡味道很好，推荐。', 5, 4, 19),
(20, '九珍果汁非常清新，很好喝。', 4, 5, 20),
(21, '原味鸡真的很香，吃完还想再来一份。', 5, 1, 21),
(22, '香辣鸡翅非常美味，辣味适中。', 5, 2, 22),
(23, '田园鸡腿堡非常好吃，口感丰富。', 5, 3, 23),
(24, '劲脆鸡腿堡味道很好，推荐。', 5, 4, 24),
(25, '九珍果汁非常清新，很好喝。', 4, 5, 25),
(26, '脆皮炸鸡非常香脆，好吃极了。', 5, 1, 26),
(27, '鸡肉卷味道很好，推荐。', 5, 2, 27),
(28, '薯条非常脆，好吃极了。', 4, 3, 28),
(29, '甜筒冰淇淋非常香甜，好吃。', 4, 4, 29),
(30, '柠檬茶非常清新，很好喝。', 4, 5, 30),
(31, '脆皮炸鸡非常香脆，好吃极了。', 5, 1, 31),
(32, '鸡肉卷味道很好，推荐。', 5, 2, 32),
(33, '薯条非常脆，好吃极了。', 4, 3, 33),
(34, '甜筒冰淇淋非常香甜，好吃。', 4, 4, 34),
(35, '柠檬茶非常清新，很好喝。', 4, 5, 35),
(36, '拿铁咖啡非常香浓，好喝极了。', 5, 1, 36),
(37, '抹茶星冰乐非常清新，很好喝。', 4, 2, 37),
(38, '蓝莓麦芬蛋糕非常香甜，好吃。', 4, 3, 38),
(39, '美式咖啡非常纯正，喜欢。', 5, 4, 39),
(40, '焦糖玛奇朵非常香甜，好喝。', 5, 5, 40),
(41, '巧克力蛋糕非常浓郁，好吃极了。', 5, 1, 41),
(42, '关东煮非常好吃，热腾腾的感觉真好。', 5, 2, 42),
(43, '饭团非常美味，各种口味都很不错。', 5, 3, 43),
(44, '乌龙茶非常清爽，很好喝。', 4, 4, 44),
(45, '关东煮非常好吃，热腾腾的感觉真好。', 5, 1, 45),
(46, '饭团非常美味，各种口味都很不错。', 5, 2, 46),
(47, '红茶非常香浓，好喝极了。', 4, 3, 47),
(48, '牛肉饭非常好吃，肉质很嫩。', 5, 4, 48),
(49, '鸡肉饭非常美味，口感很好。', 5, 5, 49),
(50, '味增汤非常传统，味道很好。', 4, 1, 50),
(51, '炸鸡块非常香脆，好吃极了。', 5, 2, 51),
(52, '绿茶非常清凉，很好喝。', 4, 3, 52),
(53, '巨无霸汉堡的味道真的超级棒，每一口都是享受！', 5, 1, 1),
(54, '这是我吃过最好吃的汉堡，强烈推荐巨无霸！', 5, 2, 1),
(55, '每次来这家店必点巨无霸，真的很好吃！', 5, 3, 1),
(56, '巨无霸汉堡的牛肉非常多汁，好吃极了。', 5, 4, 1),
(57, '我爱这个巨无霸汉堡，口感丰富，味道好极了。', 5, 5, 1),
(58, '巨无霸的配料很新鲜，每一口都很满足。', 5, 6, 1),
(59, '这个巨无霸汉堡非常美味，吃完还想再来一个。', 5, 7, 1),
(60, '巨无霸汉堡真的是经典中的经典，味道绝佳。', 5, 8, 1),
(61, '巨无霸汉堡的味道一般，不太符合我的口味。', 2, 9, 1),
(62, '这个巨无霸汉堡的牛肉不够多汁，有点干。', 1, 10, 1),
(63, '麦辣鸡腿堡真是美味，每一口都充满香辣的味道。', 5, 1, 2),
(64, '这个麦辣鸡腿堡太好吃了，辣味恰到好处！', 5, 2, 2),
(65, '每次吃麦辣鸡腿堡都让我非常满足，强烈推荐。', 5, 3, 2),
(66, '麦辣鸡腿堡的鸡肉非常嫩滑，好吃极了。', 5, 4, 2),
(67, '这个麦辣鸡腿堡的味道真是一级棒，特别喜欢。', 5, 5, 2),
(68, '麦辣鸡腿堡的辣味刚好，不会太辣，非常好吃。', 5, 6, 2),
(69, '麦辣鸡腿堡真是超级好吃，每次都吃得很满足。', 5, 7, 2),
(70, '麦辣鸡腿堡的味道很一般，不推荐。', 3, 8, 2),
(71, '鸡腿堡的酱料味道怪怪的，不喜欢。', 2, 9, 2),
(72, '麦辣鸡腿堡的鸡肉不够嫩，有点失望。', 1, 10, 2);

INSERT INTO message (message_id, subject, content, user_id, order_id) VALUES
(1, '订单已完成', '您的订单已成功完成，感谢您的购买！', 1, 1),
(2, '订单已完成', '您的订单已成功完成，感谢您的购买！', 2, 2),
(3, '订单已取消', '您的订单已成功取消。', 3, 3),
(4, '订单已完成', '您的订单已成功完成，感谢您的购买！', 4, 4),
(5, '订单已取消', '您的订单已成功取消。', 5, 5),
(6, '订单已完成', '您的订单已成功完成，感谢您的购买！', 6, 6),
(7, '订单已取消', '您的订单已成功取消。', 7, 7),
(8, '订单已取消', '您的订单已成功取消。', 8, 8),
(9, '订单已完成', '您的订单已成功完成，感谢您的购买！', 9, 9),
(10, '订单已完成', '您的订单已成功完成，感谢您的购买！', 10, 10),
(11, '订单已完成', '您的订单已成功完成，感谢您的购买！', 2, 11),
(12, '订单已完成', '您的订单已成功完成，感谢您的购买！', 3, 12),
(13, '订单已取消', '您的订单已成功取消。', 4, 13),
(14, '订单已完成', '您的订单已成功完成，感谢您的购买！', 5, 14),
(15, '订单已完成', '您的订单已成功完成，感谢您的购买！', 6, 15),
(16, '订单已完成', '您的订单已成功完成，感谢您的购买！', 7, 16),
(17, '订单已完成', '您的订单已成功完成，感谢您的购买！', 8, 17),
(18, '订单已取消', '您的订单已成功取消。', 9, 18),
(19, '订单已完成', '您的订单已成功完成，感谢您的购买！', 10, 19),
(20, '订单已完成', '您的订单已成功完成，感谢您的购买！', 1, 20),
(21, '订单已完成', '您的订单已成功完成，感谢您的购买！', 2, 21),
(22, '订单已完成', '您的订单已成功完成，感谢您的购买！', 3, 22),
(23, '订单已取消', '您的订单已成功取消。', 4, 23),
(24, '订单已完成', '您的订单已成功完成，感谢您的购买！', 5, 24),
(25, '订单已完成', '您的订单已成功完成，感谢您的购买！', 6, 25),
(26, '订单已取消', '您的订单已成功取消。', 7, 26),
(27, '订单已完成', '您的订单已成功完成，感谢您的购买！', 8, 27),
(28, '订单已取消', '您的订单已成功取消。', 9, 28),
(29, '订单已完成', '您的订单已成功完成，感谢您的购买！', 10, 29),
(30, '订单已完成', '您的订单已成功完成，感谢您的购买！', 1, 30);
