package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Nutrition;

@Mapper
@Repository
public interface NutritionDao extends BaseMapper<Nutrition>{
    public List<Nutrition> selectByDishId(Integer id);
    public List<String> selectNutritionsByDishId(Integer id);
}
