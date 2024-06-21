package main.service;

import java.sql.Timestamp;
import java.util.List;

import main.dto.BriefRestaurantDTO;
import main.dto.RestaurantDTO;
import main.pojo.LoyalCustomerDistribution;
import main.pojo.MonthlyRevenue;
import main.pojo.Restaurant;
import main.pojo.RestaurantSummary;
import main.pojo.UserGroupAnalysis;
import main.pojo.RestaurantDetails;
public interface RestaurantService {
    public List<BriefRestaurantDTO> selectAll4U();
    public List<RestaurantDTO> selectAll4M();
    public BriefRestaurantDTO selectById(Integer id);
    public Restaurant selectByAccount(String account);
    public List<RestaurantDTO> selectPage4M(Integer pageSize, Integer pageNum);
    public boolean insert(Restaurant restaurant);
    public boolean update(Restaurant restaurant);
    public boolean deleteById(Integer id);
    public List<BriefRestaurantDTO> getRestaurantsByKeyword(String keyword);
    public List<RestaurantSummary> getRestaurantSummariesByKeyword(String keyword);
    public RestaurantDetails getRestaurantDetailsById(Integer id);
    public List<LoyalCustomerDistribution> getLoyalCustomerDistribution(Integer restaurantId,Integer threshold,Timestamp startTimeStamp);
    public List<UserGroupAnalysis> getUserGroupAnalysis(Integer restaurantId);
    public List<MonthlyRevenue> getMonthlyRevenues(Integer restaurantId); 
}
