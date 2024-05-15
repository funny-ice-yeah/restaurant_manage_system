package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Dish;

@Mapper
@Repository
public interface DishDao {
    public Dish getDish(Integer id);
    public List<Dish> getDishByRestaurantId(Integer Id);
    public int createDish(Dish dish);
    public int updateDish(Dish dish);
    public int deleteDish(Integer id);
}
