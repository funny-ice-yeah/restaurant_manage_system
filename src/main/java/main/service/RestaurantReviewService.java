package main.service;

import main.dto.RestaurantReviewDTO;
import main.pojo.RestaurantReview;

import java.util.List;

public interface RestaurantReviewService {
    public List<RestaurantReview> selectByRestaurantId(Integer id);
    public List<RestaurantReviewDTO> selectByUserId(Integer id);
    public boolean insert(RestaurantReview restaurantReview);
    public boolean update(RestaurantReview restaurantReview);
    public boolean deleteByUserId(Integer id);
    public boolean deleteByReviewId(Integer id);
}
