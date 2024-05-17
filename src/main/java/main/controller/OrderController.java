package main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Order;

import main.service.DishService;
import main.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    DishService dishService;

    @GetMapping("/selectById")
    public ResponseEntity<List<Order>> selectByUserId(Integer id){
        return ResponseEntity.ok(orderService.selectByUserId(id));
    }

    @PostMapping
    public boolean insert(@RequestBody Map<String, Object> data){
        return orderService.insert(data);
    }

}
