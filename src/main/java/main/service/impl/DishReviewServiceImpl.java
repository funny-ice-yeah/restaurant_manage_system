package main.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.DishReviewDao;
import main.pojo.DishReview;
import main.service.DishReviewService;

@Service
public class DishReviewServiceImpl implements DishReviewService{
    @Autowired
    private DishReviewDao dishReviewDao;

    @Override
    public List<DishReview> selectByDishId(Integer id) {
        QueryWrapper<DishReview> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return dishReviewDao.selectList(qw);
    }

    @Override
    public List<DishReview> selectByUserId(Integer id) {
        QueryWrapper<DishReview> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return dishReviewDao.selectList(qw);
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
}
