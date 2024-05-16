package main.service.impl;


import main.dao.RestaurantDao;
import main.pojo.Restaurant;
import main.service.RestaurantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantDao restaurantDao;
    @Override
    public List<Restaurant> selectAll(){
        return restaurantDao.selectAll();
    }

    @Override
    public Restaurant selectById(Integer id){
        return restaurantDao.selectById(id);
    }

    @Override
    public Restaurant selectByAccount(String account){
        QueryWrapper<Restaurant> qw = new QueryWrapper<>();
        qw.eq("account", account);
        return restaurantDao.selectOne(qw);
    }
    @Override
    public boolean insert(Restaurant restaurant){
        return restaurantDao.insert(restaurant) > 0 ? true : false;
    }

    @Override
    public boolean update(Restaurant restaurant){
        return restaurantDao.updateById(restaurant) > 0 ? true : false;
    }

    @Override
    public boolean deleteById(Integer id){
        return restaurantDao.deleteById(id) > 0 ? true : false;
    }
    @Override
    public List<Restaurant> getRestaurantsByKeyword(String keyword){
        return restaurantDao.getRestaurantsByKeyword(keyword);
    } 

}
