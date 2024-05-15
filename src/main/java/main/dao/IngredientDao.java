package main.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Ingredient;

@Mapper
@Repository
public interface IngredientDao {
    public List<Ingredient> getIngredientByDishId(Integer id);
    public int createIngredient(Ingredient ingredient);
    public int deleteIngredient(Ingredient ingredient);
}
