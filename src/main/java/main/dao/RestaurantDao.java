package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.dto.BriefRestaurantDTO;
import main.dto.RestaurantDTO;
import main.pojo.MonthlyRevenue;
import main.pojo.Restaurant;

@Mapper
@Repository
public interface RestaurantDao extends BaseMapper<Restaurant>{
    public List<BriefRestaurantDTO> selectAll4U();
    public List<RestaurantDTO> selectAll4M();
    public BriefRestaurantDTO selectByRestaurantId(@Param("restaurantId") Integer restaurantId);
    public Restaurant selectByName(String name);
    public List<BriefRestaurantDTO> getRestaurantsByKeyword(String keyword);
    public List<MonthlyRevenue> getMonthlyRevenues(@Param("restaurantId") Integer restaurantId);
    public RestaurantDTO selectFullByRestaurantId(@Param("restaurantId") Integer restaurantId);
}
