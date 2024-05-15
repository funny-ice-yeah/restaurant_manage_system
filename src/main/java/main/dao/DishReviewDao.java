package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.DishReview;

@Mapper
@Repository
public interface DishReviewDao extends BaseMapper<DishReview>{
    public List<DishReview> selectByDishId(Integer id);
}
