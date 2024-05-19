package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.FavoriteDishDao;
import main.pojo.FavoriteDish;
import main.service.FavoriteDishService;

@Service
public class FavoriteDishServiceImpl implements FavoriteDishService{
    @Autowired
    FavoriteDishDao favoriteDishDao;
    
    @Override
    public List<FavoriteDish> selectFavoriteDishsByUserId(Integer id){
        return favoriteDishDao.selectByUserId(id);
    }

}
