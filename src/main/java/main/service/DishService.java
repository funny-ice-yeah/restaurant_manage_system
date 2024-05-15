package main.service;

import java.util.List;


import main.pojo.Dish;

public interface DishService {
    public List<Dish> selectByRestaurantId(Integer id);
    public Dish selectById(Integer id);
    public Integer countQuantityById(Integer id, String method);
    public Integer countFavoriteById(Integer id);
}
