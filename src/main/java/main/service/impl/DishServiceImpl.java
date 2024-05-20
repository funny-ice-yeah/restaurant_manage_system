package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.DishDao;
import main.dao.FavoriteDishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.Dish;
import main.service.DishService;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    DishDao dishDao;

    @Autowired
    FavoriteDishDao favoriteDishDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Override
    public List<Dish> selectByRestaurantId(Integer id){
        return dishDao.selectByRestaurantId(id);
    }

    @Override
    public List<Dish> selectMainDishsByRestaurantId(Integer id){
        return dishDao.selectMainDishsByRestaurantId(id);
    }

    @Override
    public Dish selectById(Integer id){
        return dishDao.selectById(id);
    }


}
