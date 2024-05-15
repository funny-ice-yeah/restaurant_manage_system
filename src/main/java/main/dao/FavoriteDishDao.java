package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.FavoriteDish;

@Mapper
@Repository
public interface FavoriteDishDao extends BaseMapper<FavoriteDish>{
    public List<FavoriteDish> selectByUserId(Integer id);
    public List<FavoriteDish> selectByDishId(Integer id);
}
