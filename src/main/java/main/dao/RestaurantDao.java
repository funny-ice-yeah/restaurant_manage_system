package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Restaurant;

@Mapper
@Repository
public interface RestaurantDao {
    public List<Restaurant> listRestaurant();
    public Restaurant getRestaurantByName(String name);
    public Restaurant getRestaurant(Integer id);
    public int createRestaurant(Restaurant restaurant);
    public int updateRestaurant(Restaurant restaurant);
    public int deleteRestaurant(Restaurant restaurant);
}
