package main.service;

import java.util.List;
import java.util.Map;

import main.dto.DishReviewDTO;
import main.pojo.DishReview;
public interface DishReviewService {
    public List<DishReview> selectByDishId(Integer id);
    public Map<String, Object> selectPageByUserId(Integer id, Integer pageNum, Integer pageSize);
    public List<DishReviewDTO> selectByUserId(Integer id);
    public List<DishReview> selectByRestaurantId(Integer id);
    public boolean insert(DishReview dishReview);
    public boolean update(DishReview dishReview);
    public boolean deleteByUserId(Integer id);
    public boolean deleteByReviewId(Integer id);
}
