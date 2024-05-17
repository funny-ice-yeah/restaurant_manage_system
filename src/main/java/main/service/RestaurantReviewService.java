package main.service;

import main.pojo.RestaurantReview;

import java.util.List;

public interface RestaurantReviewService {
    public List<RestaurantReview> selectByRestaurantId(Integer id);
    public List<RestaurantReview> selectByUserId(Integer id);
}
