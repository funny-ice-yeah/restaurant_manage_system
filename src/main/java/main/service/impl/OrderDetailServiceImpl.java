package main.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.OrderDetailDao;
import main.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailDao orderDetailDao;
    
    @Override
    public Integer getTotalSalesByDishIdAndOrdermethodBeforeParticularTime(Integer dishId,Timestamp startTime, String OrderMethod){
        return orderDetailDao.selectTotalSalesByDishIdAndOrdermethodBeforeParticularTime(dishId, startTime, OrderMethod);
    }
}
