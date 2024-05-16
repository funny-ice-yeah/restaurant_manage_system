package main.service;

import java.util.List;

import main.pojo.Restaurant;
import main.pojo.RestaurantSummary;
public interface RestaurantService {
    public List<Restaurant> selectAll();
    public Restaurant selectById(Integer id);
    public Restaurant selectByAccount(String account);
    public boolean insert(Restaurant restaurant);
    public boolean update(Restaurant restaurant);
    public boolean deleteById(Integer id);
    public List<Restaurant> getRestaurantsByKeyword(String keyword);
    public List<RestaurantSummary> getRestaurantSummariesByKeyword(String keyword);
}
