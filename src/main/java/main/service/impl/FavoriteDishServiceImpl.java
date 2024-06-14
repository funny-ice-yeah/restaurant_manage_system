package main.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.DishDao;
import main.dao.FavoriteDishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.dao.RestaurantDao;
import main.pojo.Dish;
import main.pojo.DishSalesData;
import main.pojo.FavoriteDish;
import main.pojo.Order;
import main.pojo.OrderDetail;


import main.service.FavoriteDishService;

@Service
public class FavoriteDishServiceImpl implements FavoriteDishService{
    @Autowired
    FavoriteDishDao favoriteDishDao;

    @Autowired 
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    DishDao dishDao;

    @Autowired
    RestaurantDao restaurantDao;

    @Override
    public List<FavoriteDish> selectByUserId(Integer id) {
        return favoriteDishDao.selectByUserId(id);
    }

    @Override
    public boolean insert(FavoriteDish favoriteDish) {
        QueryWrapper<FavoriteDish> qw = new QueryWrapper<>();
        qw.eq("user_id", favoriteDish.getUserId());
        qw.eq("dish_id", favoriteDish.getDishId());
        if(favoriteDishDao.selectOne(qw) != null){
            return false;
        }
        return favoriteDishDao.insert(favoriteDish) > 0;
    }

    @Override
    public Integer countFavoriteById(Integer id) {
        return favoriteDishDao.selectByDishId(id).size();
    }

    @Override
    public Integer countQuantityById(Integer id, String method) {
        int quantity = 0;
        List<OrderDetail> orderDetails = orderDetailDao.selectByDishId(id);
        for(OrderDetail orderDetail: orderDetails){
            Order order = orderDao.selectById(orderDetail.getOrderId());
            if(order.getOrderMethod() == method) quantity += orderDetail.getQuantity();
        } 
        return quantity;
    }

    @Override
    public boolean deleteByDishUserId(Integer dishId, Integer userId) {
        QueryWrapper<FavoriteDish> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        qw.eq("dish_id", dishId);
        return favoriteDishDao.delete(qw) > 0;
    }

    @Override
    public List<DishSalesData> getFavouriteDishSales(Integer userId,Timestamp startTimeStamp, String orderMethod){
        List<FavoriteDish> favoriteDishs = favoriteDishDao.selectByUserId(userId);
        String[] orderMethods = null;
        if(orderMethod.equals("所有")){
            orderMethods = new String[]{"线上", "排队"};
        }else{
            orderMethods = new String[]{orderMethod};
        }

        List<DishSalesData> dishSalesDatas = new ArrayList<>();

        for(FavoriteDish favoriteDish : favoriteDishs){
            Integer dishId = favoriteDish.getDishId();
            Dish dish = dishDao.selectById(userId);
            String dishName = dish.getDishName();
            String location = dishDao.selectLocationByDishId(dish.getDishId());
            for(String method : orderMethods){
                Integer totalSales = orderDetailDao.selectTotalSalesByDishIdAndOrdermethodBeforeParticularTime(dishId, startTimeStamp, method);
                dishSalesDatas.add(new DishSalesData(dishName, location, method, totalSales));
            }
        }
        return dishSalesDatas;

    }
}
