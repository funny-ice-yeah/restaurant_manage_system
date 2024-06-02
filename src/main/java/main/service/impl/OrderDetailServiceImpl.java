package main.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.CustomerOrderSales;
import main.pojo.Order;
import main.pojo.OrderDetail;
import main.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailDao orderDetailDao;
    
    @Autowired
    OrderDao orderDao;
    
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

    @Override
    public Map<String, Integer> selectSalesById(Integer id){
        Map<String, Integer> sales = new HashMap<>();
        List<OrderDetail> orderDetails = orderDetailDao.selectByDishId(id);
        int onlineSales = 0;
        int offlineSales = 0;
        for(OrderDetail orderDetail: orderDetails){
            Order order = orderDao.selectById(orderDetail.getOrderId());
            if(order.getOrderMethod().equals("排队")){
                offlineSales += orderDetail.getQuantity();
            }else if(order.getOrderMethod().equals("线上")){
                onlineSales += orderDetail.getQuantity();
            }
        }
        sales.put("online", onlineSales);
        sales.put("offline", offlineSales);
        return sales;
    }
}
