package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.FavoriteRestaurant;
import main.pojo.Restaurant;

@Mapper
@Repository
public interface FavoriteRestaurantDao {
    public List<Restaurant> getFavoriteRestaurant(Integer id);
    public List<Restaurant> getFavoriteRestaurantByUserId(Integer id);
    public int createFavoriteRestaurant(FavoriteRestaurant favoriteRestaurant);
    public int updateFavoriteRestaurant(FavoriteRestaurant favoriteRestaurant);
    public int deleteFavoriteRestaurant(Integer id);
}
