package main.service.impl;

import main.dao.RestaurantDao;
import main.dao.CanteenDao;

import main.pojo.Restaurant;
import main.pojo.RestaurantDetails;
import main.pojo.RestaurantSummary;
import main.pojo.Dish;

import main.service.RestaurantService;
import main.service.DishService;

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
    private DishService dishService;

    @Autowired
    private CanteenDao canteenDao;
    
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
        return restaurantDao.insert(restaurant) > 0 ? true : false;
    }

    @Override
    public boolean update(Restaurant restaurant){
        return restaurantDao.updateById(restaurant) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(Integer id){
        return restaurantDao.deleteById(id) > 0 ? true : false;
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
            List<Dish> mainDishs = dishService.selectMainDishsByRestaurantId(restaurant.getRestaurantId());
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
        List<Dish> menu= dishService.selectByRestaurantId(id);
        return new RestaurantDetails(restaurant, menu);
    }

 
}
