package main.controller;

import org.springframework.web.bind.annotation.RestController;

import main.pojo.FavoriteRestaurant;
import main.service.FavoriteRestaurantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/favoriteRestaurant")
public class FavoriteRestaurantController {
    @Autowired
    FavoriteRestaurantService favoriteRestaurantService;

    @GetMapping("/selectByUserId")
    public ResponseEntity<List<FavoriteRestaurant>> selectRestaurantReview(@RequestParam("userId") Integer id) {
        List<FavoriteRestaurant> favoriteRestaurants = favoriteRestaurantService.selectByUserId(id);
        return ResponseEntity.ok(favoriteRestaurants);
    }

    @PostMapping
    public boolean insert(@RequestBody FavoriteRestaurant favoriteRestaurant){
        return favoriteRestaurantService.insert(favoriteRestaurant);
    }


}
