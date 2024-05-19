package main.service;

import java.util.List;

import main.pojo.FavoriteDish;

public interface FavoriteDishService {
    public List<FavoriteDish> selectFavoriteDishsByUserId(Integer id);
}
