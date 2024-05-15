package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.FavoriteDish;

@Mapper
@Repository
public interface FavoriteDishDao {
    public FavoriteDish getFavoriteDish(Integer id);
    public List<FavoriteDish> getFavoriteDishByUserId(Integer id);
    public int createFavoriteDish(FavoriteDish favoriteDish);
    public int updateFavoriteDish(FavoriteDish favoriteDish);
    public int deleteFavoriteDish(Integer id);
}
