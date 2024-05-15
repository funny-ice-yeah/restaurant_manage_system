package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Restaurant;

@Mapper
@Repository
public interface RestaurantDao extends BaseMapper<Restaurant>{
    public List<Restaurant> selectAll();
    public Restaurant selectByName(String name);
    public List<Restaurant> getRestaurantsByKeyword(String keyword);
}
