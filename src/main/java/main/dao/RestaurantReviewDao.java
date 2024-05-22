package main.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.RestaurantReview;
import main.pojo.UserReviewHabit;

import java.util.List;
@Mapper
@Repository
public interface RestaurantReviewDao extends BaseMapper<RestaurantReview>{
    public List<RestaurantReview> selectByRestaurantId(Integer id);
    public UserReviewHabit selectUserReviewHabitsByRestaurantIdGivenCondition(@Param("restaurantId") Integer restaurantId,@Param("condition") String condition);
}
