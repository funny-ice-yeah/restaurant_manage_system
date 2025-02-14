package main.controller;

import java.util.List;
import java.util.Map;

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

import main.service.RestaurantReviewService;
import main.dto.RestaurantReviewDTO;
import main.pojo.RestaurantReview;

@RestController
@RequestMapping("/restaurantReview")
public class RestaurantReviewController {
    @Autowired
    private RestaurantReviewService restaurantReviewService;

    @GetMapping("/selectByRestaurantId")
    public List<RestaurantReview> selectByRestaurantId(@RequestParam("restaurantId") Integer id) {
        return restaurantReviewService.selectByRestaurantId(id);
    }

    @GetMapping("/selectByUserId")
    public List<RestaurantReviewDTO> selectByUserId(@RequestParam("userId") Integer id) {
        return restaurantReviewService.selectByUserId(id);
    }

    @GetMapping("/selectPageByRestaurantId")
    public ResponseEntity<Map<String, Object>> selectByRestaurantId(@RequestParam("restaurantId") Integer id, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return ResponseEntity.ok(restaurantReviewService.selectPageByRestaurantId(id, pageNum, pageSize));
    }

    @GetMapping("/selectPageByUserId")
    public ResponseEntity<Map<String, Object>> selectByUserId(@RequestParam("userId") Integer id, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return ResponseEntity.ok(restaurantReviewService.selectPageByUserId(id, pageNum, pageSize));
    }

    @PostMapping
    public boolean insert(@RequestBody RestaurantReview restaurantReview) {
        return restaurantReviewService.insert(restaurantReview);
    }

    @PutMapping
    public boolean update(@RequestBody RestaurantReview restaurantReview) {
          return restaurantReviewService.update(restaurantReview);
    }

    @DeleteMapping("/deleteByUserId")
    public boolean deleteByUserId(@RequestParam("userId") Integer id) {
        return restaurantReviewService.deleteByUserId(id);
    }

    @DeleteMapping("/deleteByReviewId")
    public boolean deleteByReviewId(@RequestParam("reviewId") Integer id) {
        return restaurantReviewService.deleteByReviewId(id);
    }
}
