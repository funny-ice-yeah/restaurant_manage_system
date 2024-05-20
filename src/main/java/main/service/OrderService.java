package main.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import main.pojo.Order;

public interface OrderService {
    public List<Order> selectByUserId(Integer id);
    public boolean insert(Map<String, Object> data);
    List<Integer> getLoyalCustomerIds(Integer restaurantId, Timestamp startTime, Integer threshold);    
}
