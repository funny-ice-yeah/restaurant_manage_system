package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.FavoriteDishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
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

    @Override
    public List<FavoriteDish> selectByUserId(@RequestParam("userId") Integer id) {
        return favoriteDishDao.selectByUserId(id);
    }

    @Override
    public boolean insert(FavoriteDish favoriteDish) {
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
    
}
