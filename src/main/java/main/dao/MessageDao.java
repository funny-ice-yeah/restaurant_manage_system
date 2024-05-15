package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Message;



@Mapper
@Repository
public interface MessageDao extends BaseMapper<Message>{
    public List<Message> selectByUserId(Integer id);
}
