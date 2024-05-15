package main.service;

import java.util.List;

import main.pojo.Order;

public interface OrderService {
    public List<Order> selectByUserId(Integer id);
}
