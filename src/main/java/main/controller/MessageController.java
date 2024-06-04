package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Message;
import main.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
   
    @GetMapping("/selectByUserId")
    public ResponseEntity<List<Message>> selectByUserId(@RequestParam("userId") Integer id){
        return ResponseEntity.ok(messageService.selectByUserId(id));
    }
}
