package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDao;
import main.pojo.Order;
import main.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;
    @Override
    public List<Order> selectByUserId(Integer id) {
        return orderDao.selectByUserId(id);
    }

}
