# 食堂点餐系统

## 查询需求 
### 进阶查询需求
1. 菜品数据分析：商户可以查看某个商户所有菜品的评分、销量以及购买该菜品次数最多的人。   
在的`RestaurantController`层中调用`analyzeAllDishesByRestaurantId`方法。
2. 某用户收藏的各个菜品在一段时间（近一周，近一月，近一年）内不同点餐方式的销量可进行筛选。   
在`UserController`层中调用`getFavouriteDishSales`方法。
3. 一段时间内某个商户的忠实粉丝在该商户的消费分布。（忠实粉丝：在该商户消费次数超过某个阈值的用户；消费分布：各个菜品购买次数）   
在`RestaurantController`层中调用`getLoyalCustomerDistribution`方法。
4. 用户活跃度分析：分析用户的活跃度模式，包括每周、每月点餐频率的变化趋势，以及用户在不同时间段的活跃程度。  
在`RestaurantController`层中调用`getOrderFrequency`以得到每周每月点餐频率的变化趋势，可以按照周/月/年来进行统计。调用`getActivityAnalysis`以得到用户在不同时间段的活跃程度。其中不同时间段的活跃程度统计过去一年中的数据。   
5. 用户群体特征分析：根据用户的角色、年龄和性别等信息，对用户群体进行特征分析和评价习惯。  
在`RestaurantController`层中调用`getUserGroupAnalysis`方法以得到用户群体特征分析。