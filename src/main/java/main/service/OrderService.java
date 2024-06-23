package main.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import main.pojo.ActivityOneDay;
import main.pojo.Order;
import main.pojo.OrderFrequency;

public interface OrderService {
    public List<Order> selectByUserId(Integer id);
    public Map<String, Object> selectPageByUserId(Integer id, Integer pageNum, Integer pageSize);
    public List<Order> selelctByRestaurantId(Integer id);
    public Map<String, Object> selectPageByRestaurantId(Integer id, Integer pageNum, Integer pageSize);
    public boolean insert(Map<String, Object> data);
    public boolean update(Order order);
    List<Integer> getLoyalCustomerIds(Integer restaurantId, Timestamp startTime, Integer threshold);
    List<OrderFrequency> getOrderFrequencyForRestaurantByPeriod(Integer restaurantId, Timestamp startsTime, String period);
    List<ActivityOneDay> getActivityInOneDayForRestaurant(Integer restaurantId, Timestamp startTime);    
}
