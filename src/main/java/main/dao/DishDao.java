package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Dish;

@Mapper
@Repository
public interface DishDao extends BaseMapper<Dish>{
    public List<Dish> selectByRestaurantId(Integer Id);
    public List<Dish> selectMainDishsByRestaurantId(Integer id);

}
