package main.service.impl;

import main.dao.RestaurantDao;
import main.dao.RestaurantReviewDao;
import main.dao.UserDao;
import main.dao.CanteenDao;
import main.dao.DishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.Restaurant;
import main.pojo.RestaurantDetails;
import main.pojo.RestaurantSummary;
import main.pojo.User;
import main.pojo.UserGroupAnalysis;
import main.pojo.UserHabit;
import main.pojo.UserReviewHabit;
import main.pojo.CustomerOrderDistribution;
import main.pojo.CustomerOrderSales;
import main.pojo.Dish;
import main.pojo.DishSalesSummary;
import main.pojo.LoyalCustomerDistribution;
import main.service.RestaurantService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private DishDao dishDao;

    @Autowired
    private CanteenDao canteenDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestaurantReviewDao restaurantReviewDao;
    
    @Override
    public List<Restaurant> selectAll(){
        return restaurantDao.selectAll();
    }

    @Override
    public Restaurant selectById(Integer id){
        return restaurantDao.selectById(id);
    }

    @Override
    public Restaurant selectByAccount(String account){
        QueryWrapper<Restaurant> qw = new QueryWrapper<>();
        qw.eq("account", account);
        return restaurantDao.selectOne(qw);
    }
    @Override
    public boolean insert(Restaurant restaurant){
        return restaurantDao.insert(restaurant) > 0;
    }

    @Override
    public boolean update(Restaurant restaurant){
        return restaurantDao.updateById(restaurant) > 0;
    }

    @Override
    public boolean deleteById(Integer id){
        return restaurantDao.deleteById(id) > 0;
    }
    @Override
    public List<Restaurant> getRestaurantsByKeyword(String keyword){
        return restaurantDao.getRestaurantsByKeyword(keyword);
    }

    @Override
    public List<RestaurantSummary> getRestaurantSummariesByKeyword(String keyword){
        List<Restaurant> restaurantList = getRestaurantsByKeyword(keyword);
        List<RestaurantSummary> restaurantSummaries = new ArrayList<>();//创建Summary，包含rest_name，brief_inro和main_dish_names
       
        for(Restaurant restaurant:restaurantList){
            Integer canteenId = restaurant.getCanteenId();
            String canteenName = canteenDao.selectById(canteenId).getCanteenName();
            String location = canteenName+restaurant.getLocation();
            List<Dish> mainDishs = dishDao.selectMainDishsByRestaurantId(restaurant.getRestaurantId());
            List<String> mainDishsName = new ArrayList<>();
            for(Dish dish : mainDishs){
                mainDishsName.add(dish.getDishName());
            }
            RestaurantSummary restaurantSummary = new RestaurantSummary(location,restaurant.getRestaurantName(),restaurant.getBriefIntro(),mainDishsName);
            restaurantSummaries.add(restaurantSummary);
        }

        return restaurantSummaries; 
    }
    
    @Override
    public RestaurantDetails getRestaurantDetailsById(Integer id){
        Restaurant restaurant = restaurantDao.selectById(id);
        List<Dish> menu= dishDao.selectByRestaurantId(id);
        return new RestaurantDetails(restaurant, menu);
    }

    @Override
    public List<LoyalCustomerDistribution> getLoyalCustomerDistribution(Integer restaurantId,Integer threshold,Timestamp startTimeStamp){

        List<Integer> LoyalUserIds = orderDao.getLoyalCustomerIds(restaurantId, startTimeStamp, threshold);
        List<LoyalCustomerDistribution> loyalCustomerDistributions = new ArrayList<>();
        for(Integer userId : LoyalUserIds){
            User user = userDao.selectById(userId);
            List<CustomerOrderSales> customerOrderSales = orderDetailDao.getOrderDetailsByRestaurantIdAndUserId(restaurantId, userId, startTimeStamp);
            List<CustomerOrderDistribution> customerOrderDistributions= new ArrayList<>();

            for(CustomerOrderSales customerOrderSale : customerOrderSales){
                Dish dish = dishDao.selectById(customerOrderSale.getDishId()); 
                customerOrderDistributions.add(new CustomerOrderDistribution( dish.getDishId() , dish.getDishName(), customerOrderSale.getTotalPurchase()));
            }

            loyalCustomerDistributions.add(new LoyalCustomerDistribution(userId, user.getUserName(), customerOrderDistributions));
        }
        return loyalCustomerDistributions;

    }

    @Override
    public List<UserGroupAnalysis> getUserGroupAnalysis(Integer restaurantId){
        List<UserGroupAnalysis> userGroupAnalysis = new ArrayList<>();
        // 确定如下条件
        String[] conditions = {
            "age BETWEEN 18 AND 25",
            "age BETWEEN 26 AND 35",
            "age BETWEEN 36 AND 45",
            "age > 45",
            "role = 0",
            "role = 1",
            "gender = 'Male'",
            "gender = 'Female'"
        };
        
        for(String cond : conditions){
            Integer orderNum = orderDao.getTotalOrderNumByConditionAndRestaurantId(restaurantId, cond);
            List<DishSalesSummary> dishSalesSummaries = orderDao.getDishSalesSummariesByConditionAndRestaurantId(restaurantId, cond);
            UserHabit userHabit = new UserHabit(orderNum, dishSalesSummaries);
            UserReviewHabit userReviewHabit = restaurantReviewDao.selectUserReviewHabitsByRestaurantIdGivenCondition(restaurantId, cond);
            String condition_info = cond.replace("age", "年龄").replace("BETWEEEN", "介于").replace("AND", "到").replace("role", "身份").replace("0", "学生")
                                        .replace("1", "教师").replace("gender", "性别").replace("=", "为").replace(">", "大于")
                                        .replace("'Male'", "男").replace("'Female'", "女");
            userGroupAnalysis.add(new UserGroupAnalysis(condition_info, userHabit, userReviewHabit));
        }

        return userGroupAnalysis;
    }

 
}
