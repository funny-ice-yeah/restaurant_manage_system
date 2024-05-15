package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.FavoriteRestaurant;

@Mapper
@Repository
public interface FavoriteRestaurantDao {
    public List<FavoriteRestaurant> selectByUserId(Integer id);
}
