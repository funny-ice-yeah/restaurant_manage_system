package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.FavoriteDish;
import main.service.FavoriteDishService;

@RestController
@RequestMapping("/favoriteDish")
public class FavoriteDishController {
    @Autowired
    FavoriteDishService favoriteDishService;

    @GetMapping("/selectByUserId")
    public ResponseEntity<List<FavoriteDish>> selectByUserId(@RequestParam("userId") Integer id){
        return ResponseEntity.ok(favoriteDishService.selectByUserId(id));
    }

    @PostMapping
    public boolean insert(@RequestBody FavoriteDish favoriteDish){
        return favoriteDishService.insert(favoriteDish);
    }

    @DeleteMapping
    public boolean deleteByDishUserId(@RequestParam("dishId") Integer dishId, @RequestParam("userId") Integer userId){
        return favoriteDishService.deleteByDishUserId(dishId, userId);
    }

    @GetMapping("/countFavorite")
    public Integer countFavorite(@RequestParam("dishId") Integer id) {
        return favoriteDishService.countFavoriteById(id);
    }

    @GetMapping("/countQuantity")
    public Integer countQuantity(@RequestParam("dishId") Integer id, @RequestParam("method") String method) {
        return favoriteDishService.countQuantityById(id, method);
    }

}
