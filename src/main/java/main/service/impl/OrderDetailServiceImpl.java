package main.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDetailDao;
import main.pojo.CustomerOrderSales;
import main.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailDao orderDetailDao;
    
    @Override
    public Integer getTotalSalesByDishIdAndOrdermethodBeforeParticularTime(Integer dishId,Timestamp startTime, String OrderMethod){
        return orderDetailDao.selectTotalSalesByDishIdAndOrdermethodBeforeParticularTime(dishId, startTime, OrderMethod);
    }

    @Override
    public List<CustomerOrderSales> getOrderDetailsByRestaurantIdAndUserId(Integer restaurantId, Integer userId, Timestamp startTime){
        return orderDetailDao.getOrderDetailsByRestaurantIdAndUserId(restaurantId, userId, startTime);
    }
}
