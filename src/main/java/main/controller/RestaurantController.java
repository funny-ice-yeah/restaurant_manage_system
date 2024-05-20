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
import main.pojo.LoyalCustomerDistribution;
import main.pojo.Restaurant;
import main.pojo.RestaurantDetails;
import main.pojo.RestaurantSummary;

import main.service.RestaurantReviewService;
import main.service.RestaurantService;
import main.service.UserService;
import main.service.DishService;
import main.service.OrderDetailService;
import main.service.OrderService;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    UserService userService;

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



    @GetMapping("/selectAll")
    public ResponseEntity<List<Restaurant>> selelctAll(){
        List<Restaurant> restaurants = restaurantService.selectAll();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/selectById")
    public ResponseEntity<Restaurant> selectById(@RequestParam("restaurantId") Integer id){
        return ResponseEntity.ok(restaurantService.selectById(id));
    }
    @GetMapping("/analyzeDishes")
    public ResponseEntity<List<DishAnalysis>> analyzeAllDishesByRestaurantId(@RequestParam("id") Integer id) {
        List<DishAnalysis> dishAnalysis = dishService.analyzeDishByRestaurantId(id);
        return ResponseEntity.ok(dishAnalysis);
    }
    
    @GetMapping("/loyalCustomerDistribution")
    public ResponseEntity<List<LoyalCustomerDistribution>> getLoyalCustomerDistribution(@RequestParam("restaurantId") Integer restaurantId, 
                                                                                        @RequestParam("period") String period,
                                                                                        @RequestParam("threshold") Integer threshold) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime;
        
        switch (period) {
            case "周":
                startTime = now.minus(1,ChronoUnit.WEEKS);
                break;
            case "月":
                startTime = now.minus(1,ChronoUnit.MONTHS);
            case "年":
                startTime = now.minus(1,ChronoUnit.YEARS);
            default:
                return ResponseEntity.badRequest().build();
        }

        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        List<LoyalCustomerDistribution> loyalCustomerDistributions = restaurantService.getLoyalCustomerDistribution(restaurantId, threshold, startTimeStamp);
        return ResponseEntity.ok(loyalCustomerDistributions);

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
