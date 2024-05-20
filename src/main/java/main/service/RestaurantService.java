package main.service;

import java.sql.Timestamp;
import java.util.List;

import main.pojo.LoyalCustomerDistribution;
import main.pojo.Restaurant;
import main.pojo.RestaurantSummary;
import main.pojo.RestaurantDetails;
public interface RestaurantService {
    public List<Restaurant> selectAll();
    public Restaurant selectById(Integer id);
    public Restaurant selectByAccount(String account);
    public boolean insert(Restaurant restaurant);
    public boolean update(Restaurant restaurant);
    public boolean deleteById(Integer id);
    public List<Restaurant> getRestaurantsByKeyword(String keyword);
    public List<RestaurantSummary> getRestaurantSummariesByKeyword(String keyword);
    public RestaurantDetails getRestaurantDetailsById(Integer id);
    public List<LoyalCustomerDistribution> getLoyalCustomerDistribution(Integer restaurantId,Integer threshold,Timestamp startTimeStamp);
}
