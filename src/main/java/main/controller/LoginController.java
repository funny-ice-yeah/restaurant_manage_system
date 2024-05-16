package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import main.service.ManagerService;
import main.service.RestaurantService;
import main.service.UserService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import main.pojo.Manager;
import main.pojo.Restaurant;
import main.pojo.User;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    ManagerService managerService;

    @PostMapping("/user")
    public ResponseEntity<User> userLogin(@RequestBody User user, HttpSession session) {
        System.out.println(user.getRoleId());
        System.out.println(user.getPassword());;
        User resultUser = userService.selectByRoleId(user.getRoleId());
        if (resultUser != null && resultUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("account", user.getRoleId());
            session.setAttribute("role", 0);
        }
        return ResponseEntity.ok(resultUser);
    }

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> restaurantLogin(@RequestBody Restaurant restaurant, HttpSession session){
        Restaurant resultRestaurant = restaurantService.selectByAccount(restaurant.getAccount());
        if(resultRestaurant != null && resultRestaurant.getPassword().equals(restaurant.getPassword())){
            session.setAttribute("account", resultRestaurant.getAccount());
            session.setAttribute("role", 1);
        }
        return ResponseEntity.ok(resultRestaurant);
    }
    @PostMapping("/manager")
    public ResponseEntity<Manager> managerLogin(@RequestBody Manager manager, HttpSession session){
        Manager resultManager = managerService.selectByAccount(manager.getAccount());
        if(resultManager != null && resultManager.getPassword().equals(manager.getPassword())){
            session.setAttribute("account", resultManager.getAccount());
            session.setAttribute("role", 1);
        }
        return ResponseEntity.ok(resultManager);
    } 

    @GetMapping("/verify")
    public ResponseEntity<Object> isLogin(HttpSession session){
        Integer role = (Integer)session.getAttribute("role");
        if(role == null){
            return ResponseEntity.ok(null);
        }
        switch(role){
            case 0:{
                String roleId = (String)session.getAttribute("account");
                return ResponseEntity.ok(userService.selectByRoleId(roleId));
            }
            case 1:{
                String account = (String)session.getAttribute("account");
                return ResponseEntity.ok(restaurantService.selectByAccount(account));
            }
            case 2:{
                String account = (String)session.getAttribute("account");
                return ResponseEntity.ok(managerService.selectByAccount(account));
            }
        }
        return null;
    }

}
