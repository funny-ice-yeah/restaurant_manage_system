package main.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.AllergyDao;
import main.dao.NutritionDao;
import main.dao.IngredientDao;
import main.dao.DishReviewDao;

import main.dao.DishDao;
import main.dao.FavoriteDishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.dao.PriceDao;
import main.dao.UserDao;

import main.pojo.Dish;
import main.pojo.DishAnalysis;
import main.pojo.DishDetail;
import main.pojo.DishReview;
import main.pojo.Price;
import main.pojo.User;

import main.service.DishService;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    DishDao dishDao;

    @Autowired
    UserDao userDao;

    @Autowired
    FavoriteDishDao favoriteDishDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    AllergyDao allergyDao;

    @Autowired
    NutritionDao nutritionDao;

    @Autowired
    IngredientDao ingredientDao;

    @Autowired
    DishReviewDao dishReviewDao;

    @Autowired
    PriceDao priceDao;

    @Override
    public List<Dish> selectByRestaurantId(Integer id){
        return dishDao.selectByRestaurantId(id);
    }

    @Override
    public List<Dish> selectMainDishsByRestaurantId(Integer id){
        return dishDao.selectMainDishsByRestaurantId(id);
    }

    @Override
    public Dish selectById(Integer id){//dishId
        return dishDao.selectById(id);
    }

    @Override
    public DishDetail selecDetailByDishId(Integer id){
        Dish dish = dishDao.selectById(id);
        String allergies= String.join("、", allergyDao.selectalleriesByDishId(id));
        String nutritions = String.join("、", nutritionDao.selectNutritionsByDishId(id));
        String ingredients = String.join("、", ingredientDao.selectIngredientsByDishId(id));
        List<DishReview> dishReviews = dishReviewDao.selectByDishId(id);
        return new DishDetail(dish, allergies, nutritions, ingredients, dishReviews);
    }


    public DishAnalysis analyzeOneDish(Integer id){
        Dish dish = dishDao.selectById(id);
        Integer dish_id = dish.getDishId();
        Float averageRating = dishReviewDao.getAverageRatingByDishId(dish_id);
        Integer totalSales = orderDetailDao.getTotalSalesByDishId(dish_id);
        List<Integer> TopCustomerIds = orderDetailDao.getTopCustomerUserIdByDishId(dish_id);
        List<User> TopCustomers = new ArrayList<>();
        for(Integer userId:TopCustomerIds){
            User user = userDao.selectById(userId);
            TopCustomers.add(user);
        }
        return new DishAnalysis(dish, averageRating, totalSales, TopCustomers);
    }

    @Override
    public List<DishAnalysis> analyzeDishByRestaurantId(Integer id){
        List<Dish> dishes = dishDao.selectByRestaurantId(id);
        List<DishAnalysis> dishAnalysisList = new ArrayList<>();
        for(Dish dish : dishes){
            dishAnalysisList.add(analyzeOneDish(dish.getDishId()));
        }
        return dishAnalysisList; 
    } 

    @Override 
    public boolean update(Dish dish){
        Dish oldDish = dishDao.selectById(dish.getDishId());
        if(oldDish.getCurrentPrice() != dish.getCurrentPrice()){
            Price price = new Price();
            price.setDishId(dish.getDishId());
            price.setPrice(dish.getCurrentPrice());
            priceDao.insert(price);
        }
        return dishDao.updateById(dish) > 0;
    }

    @Override
    @Transactional
    public boolean insert(Dish dish){
        boolean dishInsertSuccess = dishDao.insert(dish) > 0 ;  
        Price price = new Price();
        price.setDishId(dish.getDishId());
        price.setPrice(dish.getCurrentPrice());
        return dishInsertSuccess && priceDao.insert(price) > 0;
    }

    @Override
    public boolean delete(Integer id){
        return dishDao.deleteById(id) > 0;
    }

    @Override
    public List<Dish> selectByKeywordRestaurantId(String keyword, Integer id) {
        QueryWrapper<Dish> qw = new QueryWrapper<>();
        qw.like("dish_name", keyword);
        qw.eq("restaurant_id", id);
        return dishDao.selectList(qw);
    }

    @Override
    public List<Price> selectPricesById(Integer id) {
        QueryWrapper<Price> qw = new QueryWrapper<>();
        qw.eq("dish_id", id);
        qw.orderBy(true, true, "create_at");
        return priceDao.selectList(qw);
    }


}
