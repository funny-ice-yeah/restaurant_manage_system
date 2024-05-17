package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.DishReview;
import main.service.DishReviewService;

@RestController
@RequestMapping("/dishReview")
public class DishReviewController {
    @Autowired
    DishReviewService dishReviewService;

    @GetMapping("/selectByUserId")
    public ResponseEntity<List<DishReview>> selectByUserId(Integer id){
        return ResponseEntity.ok(dishReviewService.selectByUserId(id));
    }

    @GetMapping("/selectByDishId")
    public ResponseEntity<List<DishReview>> selectByDishId(Integer id){
        return ResponseEntity.ok(dishReviewService.selectByDishId(id));
    }
}
