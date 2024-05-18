package main.service.impl;

import java.util.ArrayList;
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
import main.dao.UserDao;

import main.pojo.Allergy;
import main.pojo.Dish;
import main.pojo.DishAnalysis;
import main.pojo.DishDetail;
import main.pojo.DishReview;
import main.pojo.Ingredient;
import main.pojo.Nutrition;
import main.pojo.Order;
import main.pojo.OrderDetail;
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
