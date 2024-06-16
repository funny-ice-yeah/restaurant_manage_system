package main.scheduler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.time.Duration;
import main.dao.MessageDao;
import main.dao.OrderDao;
import main.pojo.Message;
import main.pojo.Order;

@Component
public class OrderTask {
    @Autowired
    OrderDao orderDao;

    @Autowired
    MessageDao messageDao;

    @Scheduled(cron = "0 * * * * ?")
    public void checkOrder(){
        QueryWrapper<Order> qw = new QueryWrapper<>();
        qw.in("order_status", "已预订", "确认中");
        List<Order> orders = orderDao.selectList(qw);

        for(Order order: orders){
            Timestamp orderTime = order.getOrderTime();
            LocalDateTime localDateTime = orderTime.toLocalDateTime();
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(now, localDateTime);
            if(order.getOrderStatus().equals("已预订") && duration.toMinutes() <= 30){
                Message message = new Message();
                message.setSubject("订单确认通知");
                message.setContent("请确认或取消订单");
                message.setOrderId(order.getOrderId());
                message.setUserId(order.getUserId());
                messageDao.insert(message);
                order.setOrderStatus("确认中");
                orderDao.updateById(order);
            }
            if(order.getOrderStatus().equals("确认中") && duration.toMinutes() <= 20){
                Message message = new Message();
                message.setSubject("订单变化通知");
                message.setContent("订单已自动确认"); 
                message.setOrderId(order.getOrderId());
                message.setUserId(order.getUserId());
                messageDao.insert(message);
                order.setOrderStatus("准备中");
                orderDao.updateById(order);
            }
        }

    }
}
