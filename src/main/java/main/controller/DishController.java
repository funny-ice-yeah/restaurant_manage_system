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
    public ResponseEntity<Dish> selectById(Integer id){
        return ResponseEntity.ok(dishService.selectById(id));
    }

    @GetMapping("/countFavorite")
    public Integer countFavorite(@RequestParam("id") Integer id) {
        return dishService.countFavoriteById(id);
    }

    @GetMapping("/countQuantity")
    public Integer countQuantity(@RequestParam("id") Integer id, @RequestParam("method") String method) {
        return dishService.countQuantityById(id, method);
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
