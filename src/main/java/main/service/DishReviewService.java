package main.service;

import java.util.List;

import main.pojo.DishReview;
public interface DishReviewService {
    public List<DishReview> selectByDishId(Integer id);
    public List<DishReview> selectByUserId(Integer id);
    public List<DishReview> selectByRestaurantId(Integer id);
    public boolean insert(DishReview dishReview);
    public boolean update(DishReview dishReview);
    public boolean deleteByUserId(Integer id);
}
