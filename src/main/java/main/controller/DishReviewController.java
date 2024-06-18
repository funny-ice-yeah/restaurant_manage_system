package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.dto.DishReviewDTO;
import main.pojo.DishReview;
import main.service.DishReviewService;
import main.service.DishService;

@RestController
@RequestMapping("/dishReview")
public class DishReviewController {
    @Autowired
    DishReviewService dishReviewService;

    @Autowired
    DishService dishService;
    

    @GetMapping("/selectByUserId")
    public ResponseEntity<List<DishReviewDTO>> selectByUserId(@RequestParam("userId")Integer id){
        return ResponseEntity.ok(dishReviewService.selectByUserId(id));
    }

    @GetMapping("/selectByDishId")
    public ResponseEntity<List<DishReview>> selectByDishId(@RequestParam("dishId")Integer id){
        return ResponseEntity.ok(dishReviewService.selectByDishId(id));
    }

    @GetMapping("/selectByRestaurantId")
    public ResponseEntity<List<DishReview>> selectByRestaurantId(@RequestParam("restaurantId")Integer id){
        return ResponseEntity.ok(dishReviewService.selectByRestaurantId(id));
    }
    @PostMapping
    public boolean insert(@RequestBody DishReview dishReview){
        return dishReviewService.insert(dishReview);
    }

    @PutMapping
    public boolean update(@RequestBody DishReview dishReview){
        return dishReviewService.update(dishReview);
    }

    @DeleteMapping("/deleteByUserId")
    public boolean deleteByUserId(@RequestParam("userId") Integer id){
        return dishReviewService.deleteByUserId(id);
    }

    @DeleteMapping("/deleteByReviewId")
    public boolean deleteByReviewId(@RequestParam("reviewId") Integer id){
        return dishReviewService.deleteByReviewId(id);
    }
}
