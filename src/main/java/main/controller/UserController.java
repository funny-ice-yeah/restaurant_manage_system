package main.controller;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

import main.pojo.Dish;
import main.pojo.DishSalesData;
import main.pojo.FavoriteDish;
import main.pojo.User;
import main.service.DishService;
import main.service.FavoriteDishService;
import main.service.OrderDetailService;
import main.service.RestaurantService;
import main.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DishService dishService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private FavoriteDishService favoriteDishService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/selectAll")
    public ResponseEntity<List<User>> listUser(){
        List<User> userList = userService.selectAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/selectById")
    public ResponseEntity<User> getUserById(@RequestParam("userId") Integer id){
        User user = userService.selectById(id);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/favouriteDishSales")
    public ResponseEntity<List<DishSalesData>> getFavouriteDishSales(@RequestParam("userId") Integer userId,@RequestParam("period") String period) {
        //提供一个由dish_id得到对应的canteen_name和restaurant_name的方法并且在这里返回用来区分不同食堂同名餐厅的同名菜。
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

        List<FavoriteDish> favoriteDishs = favoriteDishService.selectByUserId(userId);
        String[] orderMethods = {"线上","排队"};
        List<DishSalesData> dishSalesDatas = new ArrayList<>();

        for(FavoriteDish favoriteDish : favoriteDishs){
            Integer dishId = favoriteDish.getDishId();
            Dish dish = dishService.selectById(userId);
            String dishName = dish.getDishName();
            String restaurantNamebelongTo = restaurantService.selectById(dish.getRestaurantId()).getRestaurantName();
            for(String method : orderMethods){
                Integer totalSales = orderDetailService.getTotalSalesByDishIdAndOrdermethodBeforeParticularTime(dishId, startTimeStamp, method);
                dishSalesDatas.add(new DishSalesData(dishName, restaurantNamebelongTo, totalSales));
            }
        }
        
        return ResponseEntity.ok(dishSalesDatas);
    }
    
    @PostMapping
    public boolean createUser(@RequestBody User user){
        return userService.insert(user);
    }

    @PutMapping
    public boolean updateUser(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteUserById(@RequestParam("userId") Integer id){
        return userService.deleteById(id);
    }
}
