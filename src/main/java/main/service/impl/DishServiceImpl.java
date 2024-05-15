package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.DishDao;
import main.dao.FavoriteDishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.Dish;
import main.pojo.Order;
import main.pojo.OrderDetail;
import main.service.DishService;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    DishDao dishDao;

    @Autowired
    FavoriteDishDao favoriteDishDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Override
    public List<Dish> selectByRestaurantId(Integer id){
        return dishDao.selectByRestaurantId(id);
    }

    @Override
    public Dish selectById(Integer id){
        return dishDao.selectById(id);
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
}
