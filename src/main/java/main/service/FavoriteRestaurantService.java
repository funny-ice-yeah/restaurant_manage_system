package main.service;

import java.util.List;

import main.pojo.FavoriteRestaurant;

public interface FavoriteRestaurantService {
    public List<FavoriteRestaurant> selectByUserId(Integer id);
    public boolean insert(FavoriteRestaurant favoriteRestaurant); 
    public boolean deleteByRestaurantUserId(Integer restaurantId, Integer userId);
}
