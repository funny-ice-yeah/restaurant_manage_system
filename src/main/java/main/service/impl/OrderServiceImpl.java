package main.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.time.Duration;
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
    @Transactional
    public boolean insert(Map<String, Object> data){
        Order order = new Order();

        String orderTime = (String) data.get("orderTime");
        LocalDateTime localDateTime = LocalDateTime.parse(orderTime);
        order.setOrderTime(Timestamp.valueOf(localDateTime));

        LocalDateTime curDateTime = LocalDateTime.now();
        Duration duration = Duration.between(curDateTime, localDateTime);
        if(duration.toMinutes() <= 20){
            order.setOrderStatus("准备中");
        }else{
            order.setOrderStatus("已预订");
        }

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
            if(order.getOrderStatus().equals("已完成")){
                message.setContent("订单已完成");
            }else if(order.getOrderStatus().equals("准备中")){
                if(!oldOrder.getOrderStatus().equals("确认中")) return false;
                message.setContent("订单已确认");
            }else if(order.getOrderStatus().equals("已取消")){
                if(!oldOrder.getOrderStatus().equals("确认中")) return false;
                message.setContent("订单已取消");
            }
            message.setOrderId(order.getOrderId());
            message.setUserId(order.getUserId());
            messageDao.insert(message);
            oldOrder.setOrderStatus(order.getOrderStatus());
            return orderDao.updateById(oldOrder) > 0;
        }
        return false;
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



    @Override
    public Map<String, Object> selectPageByUserId(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orderDao.selectByUserId(id)); 
        Map<String, Object> result = new HashMap<>();
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }



    @Override
    public Map<String, Object> selectPageByRestaurantId(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orderDao.selectByRestaurantId(id)); 
        Map<String, Object> result = new HashMap<>();
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }



}
