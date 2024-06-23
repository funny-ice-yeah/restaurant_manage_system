package main.service.impl;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
import main.pojo.Allergy;
import main.pojo.Dish;
import main.pojo.DishAnalysis;
import main.pojo.DishDetail;
import main.pojo.DishReview;
import main.pojo.Ingredient;
import main.pojo.Nutrition;
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

    @Override
    public boolean deleteDetail(String type, String name, Integer id) {
        if(type.equals("ingredients")){
            QueryWrapper<Ingredient> qw = new QueryWrapper<>();
            qw.eq("dish_id", id);
            qw.eq("ingredient", name);
            return ingredientDao.delete(qw) > 0;
        }else if(type.equals("nutritions")){
            QueryWrapper<Nutrition> qw = new QueryWrapper<>();
            qw.eq("dish_id", id);
            qw.eq("nutrition", name);
            return nutritionDao.delete(qw) > 0;
        }else{
            QueryWrapper<Allergy> qw = new QueryWrapper<>();
            qw.eq("dish_id", id);
            qw.eq("allergy", name);
            return allergyDao.delete(qw) > 0;
        }
    }

    @Override
    public boolean insertDetail(String type, String name, Integer id) {
        if(type.equals("ingredients")){
            QueryWrapper<Ingredient> qw = new QueryWrapper<>();
            qw.eq("dish_id", id);
            qw.eq("ingredient", name);
            if(ingredientDao.selectOne(qw) != null) return false;
            Ingredient ingredient = new Ingredient(id, name);
            return ingredientDao.insert(ingredient) > 0;
        }else if(type.equals("nutritions")){
            QueryWrapper<Nutrition> qw = new QueryWrapper<>();
            qw.eq("dish_id", id);
            qw.eq("nutrition", name); 
            if(nutritionDao.selectOne(qw) != null) return false;
            Nutrition nutrition = new Nutrition(id, name);
            return nutritionDao.insert(nutrition) > 0;
        }else{
            QueryWrapper<Allergy> qw = new QueryWrapper<>();
            qw.eq("dish_id", id);
            qw.eq("allergy", name); 
            if(allergyDao.selectOne(qw) != null) return false;
            Allergy allergy = new Allergy(id, name);
            return allergyDao.insert(allergy) > 0;
        }
    }

    @Override
    public boolean uploadImage(MultipartFile file, Integer id) {
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String path0 = applicationHome.getDir().getAbsolutePath() + "\\static\\images\\dish\\";
        String path1 = applicationHome.getDir().getParentFile().getParentFile() + "\\src\\main\\resources\\static\\images\\dish\\";
        String originFileName = file.getOriginalFilename();
        @SuppressWarnings("null")
        String[] splitFileName = originFileName.split("\\.");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = splitFileName[0] + uuid + "." + splitFileName[1];
        path0 = path0 + fileName;
        path1 = path1 + fileName;
        try{
            file.transferTo(new File(path0));
            Path source = Paths.get(path0);
            Path target = Paths.get(path1);
            Files.copy(source, target); 
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        Dish dish = dishDao.selectById(id);
        dish.setImageUrl("http://127.0.0.1:8080/images/dish/"+fileName);
        return dishDao.updateById(dish) > 0;
    }

    @Override
    public Map<String, Object> selectPageByRestaurantId(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Dish> pageInfo = new PageInfo<>(dishDao.selectByRestaurantId(id));
        Map<String, Object> result = new HashMap<>();
        result.put("data", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }


}
