package main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Order;
import main.pojo.OrderDetail;
import main.service.DishService;
import main.service.OrderDetailService;
import main.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    DishService dishService;

    @GetMapping("/selectByUserId")
    public ResponseEntity<List<Order>> selectByUserId(@RequestParam("userId")Integer id){
        return ResponseEntity.ok(orderService.selectByUserId(id));
    }

    @GetMapping("/selectPageByUserId")
    public ResponseEntity<Map<String, Object>> selectPageByUserId(@RequestParam("userId")Integer id, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum){
        return ResponseEntity.ok(orderService.selectPageByUserId(id, pageNum, pageSize));
    }


    @GetMapping("/selectByRestaurantId")
    public ResponseEntity<List<Order>> selectByRestaurantId(@RequestParam("restaurantId")Integer id){
        return ResponseEntity.ok(orderService.selelctByRestaurantId(id));
    }

    @GetMapping("/selectPageByRestaurantId")
    public ResponseEntity<Map<String, Object>> selectPageByRestaurantId(@RequestParam("restaurantId")Integer id, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum){
        return ResponseEntity.ok(orderService.selectPageByRestaurantId(id, pageNum, pageSize));
    }

    @GetMapping("/selectOrderDetailByOrderId")
    public ResponseEntity<List<OrderDetail>> selectOrderDetailByOrderId(@RequestParam("orderId")Integer id){
        return ResponseEntity.ok(orderDetailService.selectByOrderId(id));
    }

    @PostMapping
    public boolean insert(@RequestBody Map<String, Object> data){
        return orderService.insert(data);
    }

    @PutMapping
    public boolean update(@RequestBody Order order){
        return orderService.update(order);
    }

}
