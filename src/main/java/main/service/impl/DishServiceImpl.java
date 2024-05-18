package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.AllergyDao;
import main.dao.NutritionDao;
import main.dao.IngredientDao;
import main.dao.DishReviewDao;

import main.dao.DishDao;
import main.dao.FavoriteDishDao;
import main.dao.OrderDao;
import main.dao.OrderDetailDao;
import main.pojo.Allergy;
import main.pojo.Dish;
import main.pojo.DishDetail;
import main.pojo.DishReview;
import main.pojo.Ingredient;
import main.pojo.Nutrition;
import main.pojo.Order;
import main.pojo.OrderDetail;
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

    @Autowired
    AllergyDao allergyDao;

    @Autowired
    NutritionDao nutritionDao;

    @Autowired
    IngredientDao ingredientDao;

    @Autowired
    DishReviewDao dishReviewDao;

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
        List<Allergy> allergies= allergyDao.selectByDishId(id);
        List<Nutrition> nutritions = nutritionDao.selectByDishId(id);
        List<Ingredient> ingredients = ingredientDao.selectByDishId(id);
        List<DishReview> dishReviews = dishReviewDao.selectByDishId(id);
        return new DishDetail(dish, allergies, nutritions, ingredients, dishReviews);
    }

    @Override
    public Integer countFavoriteById(Integer id) {
        return favoriteDishDao.selectByDishId(id).size();
    }

    @Override
    public Integer countQuantityById(Integer id, String method) {
        int quantity = 0;
        List<OrderDetail> orderDetails = orderDetailDao.selectByDishId(id);
        for(OrderDetail orderDetail: orderDetails){
            Order order = orderDao.selectById(orderDetail.getOrderId());
            if(order.getOrderMethod() == method) quantity += orderDetail.getQuantity();
        } 
        return quantity;
    }
}
