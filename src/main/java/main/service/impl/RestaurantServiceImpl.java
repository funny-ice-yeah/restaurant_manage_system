package main.service.impl;

import main.dao.RestaurantDao;
import main.dao.RestaurantReviewDao;
import main.dao.UserDao;
import main.dto.BriefRestaurantDTO;
import main.dto.RestaurantDTO;
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
import main.pojo.MonthlyRevenue;
import main.service.RestaurantService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestaurantReviewDao restaurantReviewDao;
    
    @Override
    public List<BriefRestaurantDTO> selectAll4U(){
        return restaurantDao.selectAll4U();
    }

    @Override
    public List<RestaurantDTO> selectAll4M(){
        return restaurantDao.selectAll4M();
    }

    @Override
    public BriefRestaurantDTO selectById(Integer id){
        return restaurantDao.selectByRestaurantId(id);
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
    public List<BriefRestaurantDTO> getRestaurantsByKeyword(String keyword){
        return restaurantDao.getRestaurantsByKeyword(keyword);
    }

    @Override
    public List<RestaurantSummary> getRestaurantSummariesByKeyword(String keyword){
        List<BriefRestaurantDTO> restaurantDTOList = getRestaurantsByKeyword(keyword);
        List<RestaurantSummary> restaurantSummaries = new ArrayList<>();//创建Summary，包含rest_name，brief_inro和main_dish_names
       
        for(BriefRestaurantDTO restaurantDto:restaurantDTOList){
            String location = restaurantDto.getLocation();
            List<Dish> mainDishs = dishDao.selectMainDishsByRestaurantId(restaurantDto.getRestaurantId());
            List<String> mainDishsName = new ArrayList<>();
            for(Dish dish : mainDishs){
                mainDishsName.add(dish.getDishName());
            }
            RestaurantSummary restaurantSummary = new RestaurantSummary(location,restaurantDto.getRestaurantName(),restaurantDto.getBriefIntro(),mainDishsName);
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
            "gender = 0",
            "gender = 1"
        };
        
        for(String cond : conditions){
            Integer orderNum = orderDao.getTotalOrderNumByConditionAndRestaurantId(restaurantId, cond);
            List<DishSalesSummary> dishSalesSummaries = orderDao.getDishSalesSummariesByConditionAndRestaurantId(restaurantId, cond);
            UserHabit userHabit = new UserHabit(orderNum, dishSalesSummaries);
            UserReviewHabit userReviewHabit = restaurantReviewDao.selectUserReviewHabitsByRestaurantIdGivenCondition(restaurantId, cond);
            Pattern role0Pattern = Pattern.compile("\\brole\\s*=\\s*0\\b");
            Pattern role1Pattern = Pattern.compile("\\brole\\s*=\\s*1\\b");    
            Pattern gender0Pattern = Pattern.compile("\\bgender\\s*=\\s*0\\b");
            Pattern gender1Pattern = Pattern.compile("\\bgender\\s*=\\s*1\\b");        
            String condition_info = cond.replace("age", "年龄").replace("BETWEEN", "介于").replace("AND", "到").replace(">", "大于");
            condition_info = role0Pattern.matcher(condition_info).replaceAll("学生");
            condition_info = role1Pattern.matcher(condition_info).replaceAll("职工");
            condition_info = gender0Pattern.matcher(condition_info).replaceAll("男性顾客");
            condition_info = gender1Pattern.matcher(condition_info).replaceAll("女性顾客");
            userGroupAnalysis.add(new UserGroupAnalysis(condition_info, userHabit, userReviewHabit));
        }

        return userGroupAnalysis;
    }

    @Override
    public List<MonthlyRevenue> getMonthlyRevenues(Integer restaurantId){
        return restaurantDao.getMonthlyRevenues(restaurantId);
    }

}
