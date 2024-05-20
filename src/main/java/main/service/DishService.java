package main.service;

import java.util.List;


import main.pojo.Dish;
import main.pojo.DishAnalysis;
import main.pojo.DishDetail;

public interface DishService {
    public List<Dish> selectByRestaurantId(Integer id);
    public List<Dish> selectMainDishsByRestaurantId(Integer id);
    public Dish selectById(Integer id);
    public DishDetail selecDetailByDishId(Integer id);
    public List<DishAnalysis> analyzeDishByRestaurantId(Integer id);
    public boolean update(Dish dish);
    public boolean insert(Dish dish);
    public boolean delete(Integer id);
}
