package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import main.pojo.Restaurant;
import main.pojo.RestaurantDetails;
import main.pojo.RestaurantReview;
import main.pojo.RestaurantSummary;
import main.service.RestaurantReviewService;
import main.service.RestaurantService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    RestaurantReviewService restaurantReviewService;

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
        List<RestaurantReview> restaurantReview = restaurantReviewService.getRestaurantReviewById(id);
        return ResponseEntity.ok(restaurantReview);
    }
    
    
    
}
