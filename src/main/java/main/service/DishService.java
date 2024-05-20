package main.service;

import java.util.List;


import main.pojo.Dish;

public interface DishService {
    public List<Dish> selectByRestaurantId(Integer id);
    public List<Dish> selectMainDishsByRestaurantId(Integer id);
    public Dish selectById(Integer id);
}
