package main.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.RestaurantReview;

@Mapper
@Repository
public interface RestaurantReviewDao extends BaseMapper<RestaurantReview>{
    public RestaurantReview selectByRestaurantId(Integer id);
}
