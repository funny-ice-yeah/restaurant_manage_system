package main.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.RestaurantReview;

@Mapper
@Repository
public interface RestaurantReviewDao {
    public RestaurantReview getRestaurantReviewByRestaurantId(Integer id);
    public int createRestaurantReview(RestaurantReview restaurantReview);
    public int updateRestaurantReview(RestaurantReview restaurantReview);
    public int deleteRestaurantReview(RestaurantReview restaurantReview);
}
