package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Order;
import main.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    public ResponseEntity<List<Order>> selectByUserId(Integer id){
        return ResponseEntity.ok(orderService.selectByUserId(id));
    }
}
