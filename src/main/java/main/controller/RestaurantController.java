package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Restaurant;
import main.service.RestaurantService;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    
    @GetMapping("/searchByKeyword")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam("keyword") String keyword){
        List<Restaurant> restaurantList = restaurantService.getRestaurantsByKeyword(keyword);
        return ResponseEntity.ok(restaurantList);        
    }

    @GetMapping("selectAll")
    public ResponseEntity<List<Restaurant>> selelctAll(){
        List<Restaurant> restaurants = restaurantService.selectAll();
        return ResponseEntity.ok(restaurants);
    }
    
}
