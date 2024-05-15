package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Dish;
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
    

}
