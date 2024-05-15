package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.DishReview;

@Mapper
@Repository
public interface DishReviewDao {
    public List<DishReview> getDishReviewByDishId(Integer id);
    public DishReview getDishReview(Integer id);
    public int createDishReview(DishReview dishReview);
    public int updateDishReview(DishReview dishReview);
    public int deleteDishReview(DishReview dishReview);
}
