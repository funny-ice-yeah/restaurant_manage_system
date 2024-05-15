package main.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Allergy;


@Mapper
@Repository
public interface AllergyDao {
    public List<Allergy> getAllergyByDishId(Integer id);
    public int createAllergy(Allergy allergy);
    public int deleteAllergy(Allergy allergy);
}
