package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.FavoriteRestaurantDao;
import main.pojo.FavoriteRestaurant;
import main.service.FavoriteRestaurantService;

@Service
public class FavoriteRestaurantServiceImpl implements FavoriteRestaurantService{
    @Autowired
    FavoriteRestaurantDao favoriteRestaurantDao;

    @Override
    public List<FavoriteRestaurant> selectByUserId(Integer id) {
        QueryWrapper<FavoriteRestaurant> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return favoriteRestaurantDao.selectByUserId(id);
    }

    @Override
    public boolean insert(FavoriteRestaurant favoriteRestaurant) {
        QueryWrapper<FavoriteRestaurant> qw = new QueryWrapper<>();
        qw.eq("user_id", favoriteRestaurant.getUserId());
        qw.eq("restaurant_id", favoriteRestaurant.getRestaurantId());
        if(favoriteRestaurantDao.selectOne(qw) != null){
            return false;
        }
        return favoriteRestaurantDao.insert(favoriteRestaurant) > 0;
    }

    @Override
    public boolean deleteByRestaurantUserId(Integer restaurantId, Integer userId){
        QueryWrapper<FavoriteRestaurant> qw = new QueryWrapper<>();
        qw.eq("restaurant_id", restaurantId);
        qw.eq("user_id", userId);
        return favoriteRestaurantDao.delete(qw) > 0;
    }
    
}
