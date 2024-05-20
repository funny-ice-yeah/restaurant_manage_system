package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.FavoriteRestaurant;

@Mapper
@Repository
public interface FavoriteRestaurantDao extends BaseMapper<FavoriteRestaurant>{
    public List<FavoriteRestaurant> selectByUserId(Integer id);
}
