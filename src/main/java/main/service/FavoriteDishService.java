package main.service;

import java.sql.Timestamp;
import java.util.List;

import main.pojo.DishSalesData;
import main.pojo.FavoriteDish;

public interface FavoriteDishService {
    public List<FavoriteDish> selectByUserId(Integer id); 
    public boolean insert(FavoriteDish favoriteDish);
    public boolean deleteByDishUserId(Integer dishId, Integer userId);
    public Integer countFavoriteById(Integer id);
    public Integer countQuantityById(Integer id, String method);
    public List<DishSalesData> getFavouriteDishSales(Integer userId,Timestamp startTimeStamp);

}
