package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.pojo.Message;
import main.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    
    public ResponseEntity<List<Message>> selectByUserId(Integer id){
        return ResponseEntity.ok(messageService.selectByUserId(id));
    }
}
