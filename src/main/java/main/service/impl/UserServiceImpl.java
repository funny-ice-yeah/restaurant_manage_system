package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.UserDao;
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

}
