package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Dish;

@Mapper
@Repository
public interface DishDao extends BaseMapper<Dish>{
    public List<Dish> selectByRestaurantId(Integer Id);
    public List<Dish> selectMainDishsByRestaurantId(Integer id);
    public String selectLocationByDishId(Integer Id);

    @Options(useGeneratedKeys = true, keyProperty = "dishId")
    @Insert("INSERT INTO dish (dish_name, category, current_price, description, image_url, is_main_dish, restaurant_id) " +
            "VALUES (#{dishName}, #{category}, #{currentPrice}, #{description}, #{imageUrl}, #{isMainDish}, #{restaurantId})")
    public int insert(Dish dish);

}
