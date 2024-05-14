package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.User;

@Mapper
@Repository
public interface UserDao {
    public List<User> listUser();
    public User getUserById(Integer id);
    public int createUser(User user);
    public int updateUser(User user);
    public int deleteUserById(Integer id);
}