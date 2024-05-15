package main.service;

import java.util.List;

import main.pojo.Message;


public interface MessageService {
    public List<Message> selectByUserId(Integer id);
}
