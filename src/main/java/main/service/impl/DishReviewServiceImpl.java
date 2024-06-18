package main.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.DishDao;
import main.dao.DishReviewDao;
import main.dto.DishReviewDTO;
import main.pojo.Dish;
import main.pojo.DishReview;
import main.service.DishReviewService;

@Service
public class DishReviewServiceImpl implements DishReviewService{
    @Autowired
    private DishReviewDao dishReviewDao;

    @Autowired
    private DishDao dishDao;

    @Override
    public List<DishReview> selectByDishId(Integer id) {
        QueryWrapper<DishReview> qw = new QueryWrapper<>();
        qw.eq("dish_id", id);
        return dishReviewDao.selectList(qw);
    }

    @Override
    public List<DishReviewDTO> selectByUserId(Integer id) {
        return dishReviewDao.selectByUserId(id);
    }

    @Override
    public boolean insert(DishReview dishReview) {
        return dishReviewDao.insert(dishReview) > 0;
    }

    @Override
    public boolean update(DishReview dishReview) {
        return dishReviewDao.updateById(dishReview) > 0;
    }

    @Override
    public boolean deleteByUserId(Integer id) {
        QueryWrapper<DishReview> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return dishReviewDao.delete(qw) > 0;
    }

    @Override
    public List<DishReview> selectByRestaurantId(Integer id) {
        List<Dish> dishes = dishDao.selectByRestaurantId(id);
        List<DishReview> dishReviews = new ArrayList<>();
        for(Dish dish: dishes){
            List<DishReview> result = dishReviewDao.selectByDishId(dish.getDishId());
            dishReviews.addAll(result);
        }
        return dishReviews;
    }

    @Override
    public boolean deleteByReviewId(Integer id){
        QueryWrapper<DishReview> qw = new QueryWrapper<>();
        qw.eq("review_id", id);
        return dishReviewDao.delete(qw) > 0;
    }
}
