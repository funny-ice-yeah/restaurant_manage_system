package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.service.RestaurantReviewService;
import main.pojo.RestaurantReview;
@RestController
@RequestMapping("/restaurantReview")
public class RestaurantReviewController {
   @Autowired
   private RestaurantReviewService restaurantReviewService;
   
   @GetMapping("/selectByRestaurantId")
   public List<RestaurantReview> selectByRestaurantId(@RequestParam("restaurantId") Integer id){
        return restaurantReviewService.selectByRestaurantId(id);
   }

   @GetMapping("/selectByUserId")
   public List<RestaurantReview> selectByUserId(@RequestParam("userId") Integer id){
        return restaurantReviewService.selectByUserId(id);
   }
}
