package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.UserDao;
import main.dto.UserDTO;
import main.pojo.User;
import main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll(){
        return userDao.selectAll();
    }

    @Override
    public User selectByRoleId(String id){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("role_id", id);
        return userDao.selectOne(qw);
    }
    @Override
    public User selectById(Integer id){
        return userDao.selectById(id);
    }
    @Override
    public boolean insert(User user){
        return userDao.insert(user) > 0;
    }

    @Override
    public boolean update(User user){
        return userDao.updateById(user) > 0;
    }

    @Override
    public boolean deleteById(Integer id){
        return userDao.deleteById(id) > 0;
    }

    @Override
    public UserDTO convert2Dto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setAge(user.getAge());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleId(user.getRoleId());
        userDTO.setUserName(user.getUserName());
        userDTO.setGender(user.getGender() == 0 ? "男":"女");
        userDTO.setRole(user.getRole() == 0 ? "学生":"职工");
        return userDTO;
    }

    @Override
    public User convert2Pojo(UserDTO userDTO){
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setAge(userDTO.getAge());
        user.setPassword(userDTO.getPassword());
        user.setRoleId(userDTO.getRoleId());
        user.setUserName(userDTO.getUserName());
        user.setGender("男".equals(userDTO.getGender()) ? 0:1);
        user.setRole("学生".equals(userDTO.getRole())  ? 0:1);
        return user;
    }

}
