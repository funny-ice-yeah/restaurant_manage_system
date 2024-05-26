package main.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.OrderDetailDao;
import main.pojo.CustomerOrderSales;
import main.pojo.OrderDetail;
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

    @Override
    public List<OrderDetail> selectByOrderId(Integer id) {
        QueryWrapper<OrderDetail> qw = new QueryWrapper<>();
        qw.eq("order_Id", id);
        return orderDetailDao.selectList(qw);
    }
}
