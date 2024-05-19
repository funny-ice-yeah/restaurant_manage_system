package main.service;

import java.sql.Timestamp;

public interface OrderDetailService {
    public Integer getTotalSalesByDishIdAndOrdermethodBeforeParticularTime(Integer dishId,Timestamp startTime, String OrderMethod);
}
