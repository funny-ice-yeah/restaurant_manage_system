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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import main.pojo.Dish;
import main.pojo.DishDetail;
import main.pojo.Price;
import main.service.DishService;
import main.service.OrderDetailService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private OrderDetailService orderDetailService;


    @GetMapping("/selectById")
    public ResponseEntity<Dish> selectById(@RequestParam("dishId") Integer id){
        return ResponseEntity.ok(dishService.selectById(id));
    }

    @GetMapping("/selectByKeywordRestaurantId")
    public ResponseEntity<List<Dish>> selectByKeywordRestaurantId(@RequestParam("keyword") String keyword, @RequestParam("restaurantId") Integer id){
        return ResponseEntity.ok(dishService.selectByKeywordRestaurantId(keyword, id));
    }


    @GetMapping("/selectByRestaurantId")
    public ResponseEntity<List<Dish>> selectByRestaurantId(@RequestParam("restaurantId") Integer id){
        return ResponseEntity.ok(dishService.selectByRestaurantId(id));
    }

    @GetMapping("/selectPageByRestaurantId")
    public ResponseEntity<Map<String, Object>> selectPageByRestaurantId(@RequestParam("restaurantId") Integer id, @RequestParam("pageSize")Integer pageSize, @RequestParam("pageNum") Integer pageNum){
        return ResponseEntity.ok(dishService.selectPageByRestaurantId(id, pageNum, pageSize));
    }

    @GetMapping("/selectMainDishByRestaurantId")
    public ResponseEntity<List<Dish>> selectMainDishByRestaurantId(@RequestParam("restaurantId") Integer id){
        return ResponseEntity.ok(dishService.selectMainDishsByRestaurantId(id));
    }
    
    @GetMapping("/details")
    public ResponseEntity<DishDetail> selectDetailByDishId(@RequestParam("dishId") Integer id) {
        DishDetail dishDetail = dishService.selecDetailByDishId(id);
        return ResponseEntity.ok(dishDetail);
    }

    @GetMapping("/selectSalesById")
    public ResponseEntity<Map<String, Integer>> selectSalesById(@RequestParam("dishId") Integer id){
        return ResponseEntity.ok(orderDetailService.selectSalesById(id));
    }

    @GetMapping("/selectPricesById")
    public ResponseEntity<List<Price>> selectPricesById(@RequestParam("dishId") Integer id){
        return ResponseEntity.ok(dishService.selectPricesById(id));
    }


    @PutMapping
    public boolean update(@RequestBody Dish dish){
        return dishService.update(dish);
    }
    
    @PostMapping
    public boolean insert(@RequestBody Dish dish){
        return dishService.insert(dish);
    }

    @PostMapping("/insertDetail")
    public boolean insertDetail(@RequestParam("dishId") Integer id, @RequestParam("name") String name, @RequestParam("type") String type){
        return dishService.insertDetail(type, name, id);
    }

    @PostMapping("/uploadImage")
    public boolean uploadImage(@RequestParam("file")MultipartFile file, @RequestParam("dishId") Integer id){
        return dishService.uploadImage(file, id);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(@RequestParam("dishId") Integer id){
        return dishService.delete(id);
    }

    @DeleteMapping("/deleteDetail")
    public boolean deleteDetail(@RequestParam("dishId") Integer id, @RequestParam("name") String name, @RequestParam("type") String type){
        return dishService.deleteDetail(type, name, id);
    }
}
