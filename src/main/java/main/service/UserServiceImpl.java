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
    public List<User> selectAll(){
        return userDao.selectAll();
    }

    @Override
    public User selectById(Integer id){
        return userDao.selectById(id);
    }
    @Override
    public boolean insert(User user){
        return userDao.insert(user) > 0 ? true : false;
    }

    @Override
    public boolean update(User user){
        return userDao.updateById(user) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(Integer id){
        return userDao.deleteById(id) > 0 ? true : false;
    }

}
