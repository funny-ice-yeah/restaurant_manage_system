package main.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Allergy;


@Mapper
@Repository
public interface AllergyDao extends BaseMapper<Allergy>{
    public List<Allergy> selectByDishId(Integer id);
}
