package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Dish;
import main.pojo.DishDetail;
import main.service.DishService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishService dishService;

    @GetMapping("/selectById")
    public ResponseEntity<Dish> selectById(@RequestParam("dishId") Integer id){
        return ResponseEntity.ok(dishService.selectById(id));
    }



    @GetMapping("/selectByRestaurantId")
    public ResponseEntity<List<Dish>> selectByRestaurantId(@RequestParam("restaurantId") Integer id){
        return ResponseEntity.ok(dishService.selectByRestaurantId(id));
    }
    
    @GetMapping("/Details")
    public ResponseEntity<DishDetail> selectDetailByDishId(@RequestParam("dishId") Integer id) {
        DishDetail dishDetail = dishService.selecDetailByDishId(id);
        return ResponseEntity.ok(dishDetail);
    }
    

}
