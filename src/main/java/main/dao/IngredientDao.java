package main.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Ingredient;

@Mapper
@Repository
public interface IngredientDao extends BaseMapper<Ingredient>{
    public List<Ingredient> selectByDishId(Integer id);
    public List<String> selectIngredientsByDishId(Integer id);
}
