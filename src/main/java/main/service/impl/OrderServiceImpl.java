package main.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.DishDao;
import main.dao.MessageDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.ActivityOneDay;
import main.pojo.Dish;
import main.pojo.Message;
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

    @Autowired
    MessageDao messageDao;
    
    @Override
    public List<Order> selectByUserId(Integer id) {
        return orderDao.selectByUserId(id);
    }

    @Override
    public boolean insert(Map<String, Object> data){
        Order order = new Order();
        order.setOrderStatus("准备中");
        String orderTime = (String) data.get("orderTime");
        LocalDateTime localDateTime = LocalDateTime.parse(orderTime);
        order.setOrderTime(Timestamp.valueOf(localDateTime));
        order.setOrderMethod((String)data.get("orderMethod"));
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
    public boolean update(Order order){
        Order oldOrder = orderDao.selectById(order.getOrderId());
        if(!order.getOrderStatus().equals(oldOrder.getOrderStatus())){
            Message message = new Message();
            message.setSubject("订单状态变化");
            message.setContent("您的订单状态已由"+oldOrder.getOrderStatus()+"转变为"+order.getOrderStatus());
            message.setOrderId(order.getOrderId());
            message.setUserId(order.getUserId());
            messageDao.insert(message);
        }
        return orderDao.updateById(order) > 0;
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
