package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.User;

@Mapper
@Repository
public interface UserDao extends BaseMapper<User>{
    public List<User> selectAll();
}