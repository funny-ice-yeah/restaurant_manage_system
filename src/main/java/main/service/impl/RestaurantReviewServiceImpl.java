package main.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import main.dao.RestaurantReviewDao;
import main.dto.RestaurantReviewDTO;
import main.pojo.RestaurantReview;
import main.service.RestaurantReviewService;

@Service
public class RestaurantReviewServiceImpl implements RestaurantReviewService {
    @Autowired
    private RestaurantReviewDao restaurantReviewDao;

    @Override
    public List<RestaurantReview> selectByRestaurantId(Integer id) {
        return restaurantReviewDao.selectByRestaurantId(id);
    }
    @Override
    public List<RestaurantReviewDTO> selectByUserId(Integer id) {
        return restaurantReviewDao.selectByUserId(id);
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
    @Override
    public Map<String, Object> selectPageByRestaurantId(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RestaurantReview> restaurantReviews = restaurantReviewDao.selectByRestaurantId(id);
        PageInfo<RestaurantReview> pageInfo = new PageInfo<>(restaurantReviews);
        Map<String, Object> result = new HashMap<>();
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }
    @Override
    public Map<String, Object> selectPageByUserId(Integer id, Integer pageNum, Integer pageSize) { 
        PageHelper.startPage(pageNum, pageSize);
        List<RestaurantReviewDTO> restaurantReviewDTOs = restaurantReviewDao.selectByUserId(id);
        PageInfo<RestaurantReviewDTO> pageInfo = new PageInfo<>(restaurantReviewDTOs);
        Map<String, Object> result = new HashMap<>();
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }
    
}
