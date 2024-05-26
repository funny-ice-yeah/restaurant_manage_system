package main.service;

import java.sql.Timestamp;
import java.util.List;

import main.pojo.CustomerOrderSales;
import main.pojo.OrderDetail;

public interface OrderDetailService {
    public Integer getTotalSalesByDishIdAndOrdermethodBeforeParticularTime(Integer dishId,Timestamp startTime, String OrderMethod);
    public List<CustomerOrderSales> getOrderDetailsByRestaurantIdAndUserId(Integer restaurantId, Integer userId, Timestamp startTime);    
    public List<OrderDetail> selectByOrderId(Integer id);
}
