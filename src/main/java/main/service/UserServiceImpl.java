package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import main.dao.UserDao;
import main.pojo.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser(){
        return userDao.listUser();
    }

    @Override
    public User getUser(Integer id){
        return userDao.getUser(id);
    }
    @Override
    public boolean createUser(User user){
        return userDao.createUser(user) > 0 ? true : false;
    }

    @Override
    public boolean updateUser(User user){
        return userDao.updateUser(user) > 0 ? true : false;
    }

    @Override
    public boolean deleteUser(Integer id){
        return userDao.deleteUser(id) > 0 ? true : false;
    }

}
