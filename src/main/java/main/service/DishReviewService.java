package main.service;

import java.util.List;

import main.pojo.DishReview;
public interface DishReviewService {
    public List<DishReview> selectByDishId(Integer id);
    public List<DishReview> selectByUserId(Integer id);
}
