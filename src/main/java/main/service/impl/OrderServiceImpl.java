package main.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.DishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.ActivityOneDay;
import main.pojo.Dish;
import main.pojo.Order;
import main.pojo.OrderDetail;
import main.pojo.OrderFrequency;
import main.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    DishDao dishDao;
    
    @Override
    public List<Order> selectByUserId(Integer id) {
        return orderDao.selectByUserId(id);
    }

    @Override
    public boolean insert(Map<String, Object> data){
        Order order = new Order();
        order.setOrderStatus("准备中");
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderMethod("线上");
        order.setTotalPrice(0f);
        order.setUserId((Integer)data.get("userId"));
        order.setRestaurantId((Integer)data.get("restaurantId"));
        orderDao.insert(order);

        float price = 0f;
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> dishes = (List<Map<String, Object>>) data.get("dishes");
        for(Map<String, Object> map: dishes){
            Dish dish = dishDao.selectById((Integer)map.get("dishId"));
            OrderDetail orderDetail = new OrderDetail(); 
            orderDetail.setDishId(dish.getDishId());
            orderDetail.setOrderId(order.getOrderId());
            int quantity = (Integer)map.get("quantity");
            orderDetail.setQuantity(quantity);
            price += quantity * dish.getCurrentPrice();
            orderDetailDao.insert(orderDetail);
        }
        
        order.setTotalPrice(price);
        orderDao.updateById(order);
        return true;
    }

    @Override
    public List<Integer> getLoyalCustomerIds(Integer restaurantId, Timestamp startTime, Integer threshold){
        return orderDao.getLoyalCustomerIds(restaurantId, startTime, threshold); 
    }

    @Override
    public List<OrderFrequency> getOrderFrequencyForRestaurantByPeriod(Integer restaurantId, Timestamp startsTime, String period){
        return orderDao.getOrderFrequencyForRestaurantByPeriod(restaurantId, startsTime, period);
    }
    
    @Override
    public List<ActivityOneDay> getActivityInOneDayForRestaurant(Integer restaurantId, Timestamp startTime){
        return orderDao.getActivityInOneDayForRestaurant(restaurantId, startTime);
    }

    @Override
    public List<Order> selelctByRestaurantId(Integer id) {
        QueryWrapper<Order> qw = new QueryWrapper<>();
        qw.eq("restaurant_id", id);
        return orderDao.selectList(qw);
    }



}
