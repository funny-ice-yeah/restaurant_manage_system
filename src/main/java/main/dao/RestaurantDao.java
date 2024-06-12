package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.dto.RestaurantDTO;
import main.pojo.MonthlyRevenue;
import main.pojo.Restaurant;

@Mapper
@Repository
public interface RestaurantDao extends BaseMapper<Restaurant>{
    public List<RestaurantDTO> selectAll();
    public Restaurant selectByName(String name);
    public List<RestaurantDTO> getRestaurantsByKeyword(String keyword);
    public List<MonthlyRevenue> getMonthlyRevenues(@Param("restaurantId") Integer restaurantId);
}
