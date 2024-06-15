package main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import main.pojo.Dish;
import main.pojo.DishAnalysis;
import main.pojo.DishDetail;
import main.pojo.Price;

public interface DishService {
    public List<Dish> selectByRestaurantId(Integer id);
    public List<Dish> selectMainDishsByRestaurantId(Integer id);
    public List<Dish> selectByKeywordRestaurantId(String keyword, Integer id);
    public Dish selectById(Integer id);
    public DishDetail selecDetailByDishId(Integer id);
    public List<DishAnalysis> analyzeDishByRestaurantId(Integer id);
    public List<Price> selectPricesById(Integer id);
    public boolean update(Dish dish);
    public boolean insert(Dish dish);
    public boolean insertDetail(String type, String name, Integer id);
    public boolean uploadImage(MultipartFile file, Integer id);
    public boolean delete(Integer id);
    public boolean deleteDetail(String type, String name, Integer id);
}
