package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.MessageDao;
import main.pojo.Message;
import main.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageDao messageDao;

    @Override
    public List<Message> selectByUserId(Integer id) {
        return messageDao.selectByUserId(id);
    }

    
}
