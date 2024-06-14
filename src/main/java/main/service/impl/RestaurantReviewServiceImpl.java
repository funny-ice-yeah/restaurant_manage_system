package main.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.RestaurantReviewDao;
import main.pojo.RestaurantReview;
import main.service.RestaurantReviewService;

@Service
public class RestaurantReviewServiceImpl implements RestaurantReviewService {
    @Autowired
    private RestaurantReviewDao restaurantReviewDao;

    @Override
    public List<RestaurantReview> selectByRestaurantId(Integer id) {
        QueryWrapper<RestaurantReview> qw = new QueryWrapper<>();
        qw.eq("restaurant_id", id);
        return restaurantReviewDao.selectList(qw);
    }
    @Override
    public List<RestaurantReview> selectByUserId(Integer id) {
        QueryWrapper<RestaurantReview> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return restaurantReviewDao.selectList(qw);
    }
    @Override
    public boolean insert(RestaurantReview restaurantReview) {
        return restaurantReviewDao.insert(restaurantReview) > 0;
    }
    @Override
    public boolean update(RestaurantReview restaurantReview) {
        return restaurantReviewDao.updateById(restaurantReview) > 0;
    }
    @Override
    public boolean deleteByUserId(Integer id) {
        QueryWrapper<RestaurantReview> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return restaurantReviewDao.delete(qw) > 0;
    }

    @Override
    public boolean deleteByReviewId(Integer id){
        QueryWrapper<RestaurantReview> qw = new QueryWrapper<>();
        qw.eq("review_id", id);
        return restaurantReviewDao.delete(qw) > 0;
    }
    
}
