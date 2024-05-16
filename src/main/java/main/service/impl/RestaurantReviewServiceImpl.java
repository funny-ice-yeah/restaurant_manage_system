package main.service.impl;
import java.util.List;

import main.dao.RestaurantReviewDao;
import main.pojo.RestaurantReview;
import main.service.RestaurantReviewService;

public class RestaurantReviewServiceImpl implements RestaurantReviewService {
    private RestaurantReviewDao restaurantReviewDao;
    public List<RestaurantReview> getRestaurantReviewById(Integer id){
        return restaurantReviewDao.selectByRestaurantId(id);       
    }
    
}
