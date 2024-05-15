package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Nutrition;
@Mapper
@Repository
public interface NutritionDao {
    public List<Nutrition> getNutritionByDishId(Integer id);
    public int createNutrition(Nutrition nutrition);
    public int deleteNutrition(Nutrition nutrition);
}
