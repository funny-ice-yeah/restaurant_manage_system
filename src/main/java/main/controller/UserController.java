package main.controller;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

import main.pojo.DishSalesData;
import main.pojo.User;
import main.service.FavoriteDishService;
import main.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteDishService favoriteDishService;

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
    public ResponseEntity<List<DishSalesData>> getFavouriteDishSales(@RequestParam("userId") Integer userId,@RequestParam("period") String period, @RequestParam("method") String method) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime;
        
        switch (period) {
            case "周":
                startTime = now.minus(1,ChronoUnit.WEEKS);
                break;
            case "月":
                startTime = now.minus(1,ChronoUnit.MONTHS);
                break;
            case "年":
                startTime = now.minus(1,ChronoUnit.YEARS);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        List<DishSalesData> dishSalesDatas = favoriteDishService.getFavouriteDishSales(userId, startTimeStamp, method);        
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
