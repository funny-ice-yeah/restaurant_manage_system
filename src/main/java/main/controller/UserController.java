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

import main.pojo.User;
import main.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/selectAll")
    public ResponseEntity<List<User>> listUser(){
        List<User> userList = userService.selectAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/selectById")
    public ResponseEntity<User> getUserById(@RequestParam("id") Integer id){
        User user = userService.selectById(id);
        return ResponseEntity.ok(user);
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
    public boolean deleteUserById(@RequestParam("id") Integer id){
        return userService.deleteById(id);
    }
}
