package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.DishAnalysis;
import main.pojo.Restaurant;
import main.pojo.RestaurantDetails;
import main.pojo.RestaurantReview;
import main.pojo.RestaurantSummary;

import main.service.RestaurantReviewService;
import main.service.RestaurantService;
import main.service.DishService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    RestaurantReviewService restaurantReviewService;
    @Autowired
    DishService dishService;

    @GetMapping("/search")
    public ResponseEntity<List<RestaurantSummary>> searchRestaurants(@RequestParam("keyword") String keyword){
        List<RestaurantSummary> restaurantSummaries = restaurantService.getRestaurantSummariesByKeyword(keyword);
        return ResponseEntity.ok(restaurantSummaries);        
    }

    @GetMapping("/details")
    public ResponseEntity<RestaurantDetails> selectRestaurantDetailsById(@RequestParam("id") Integer id) {
        RestaurantDetails restaurantDetails = restaurantService.getRestaurantDetailsById(id);
        return ResponseEntity.ok(restaurantDetails);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<RestaurantReview>> selectRestaurantReview(@RequestParam("id") Integer id) {
        List<RestaurantReview> restaurantReview = restaurantReviewService.selectByRestaurantId(id);
        return ResponseEntity.ok(restaurantReview);
    }

    @GetMapping("selectAll")
    public ResponseEntity<List<Restaurant>> selelctAll(){
        List<Restaurant> restaurants = restaurantService.selectAll();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("analyzeDishes")
    public ResponseEntity<List<DishAnalysis>> analyzeAllDishesByRestaurantId(@RequestParam("id") Integer id) {
        List<DishAnalysis> dishAnalysis = dishService.analyzeDishByRestaurantId(id);
        return ResponseEntity.ok(dishAnalysis);
    }
    

    @PostMapping
    public boolean insert(@RequestBody Restaurant restaurant){
        return restaurantService.insert(restaurant);
    }

    @PutMapping
    public boolean update(@RequestBody Restaurant restaurant){
        return restaurantService.update(restaurant);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(@RequestParam("restaurantId") Integer id){
        return restaurantService.deleteById(id);
    }


    
    
    
}
