package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Manager;
import main.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/selectById")
    public ResponseEntity<Manager> selectById(@RequestParam("managerId") Integer id){
        return ResponseEntity.ok(managerService.selectById(id));
    }

    @PutMapping
    public boolean update(@RequestBody Manager manager){
        return managerService.update(manager);
    }
}
