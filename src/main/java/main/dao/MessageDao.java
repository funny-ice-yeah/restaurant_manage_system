package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Message;



@Mapper
@Repository
public interface MessageDao {
    public List<Message> getMessageByUserId(Integer id);
    public int createMessage(Message message);
    public int updateMessage(Message message);
    public int deleteMessage(Message message);
}
