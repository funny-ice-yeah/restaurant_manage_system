package main.dao;

import java.util.List;
import java.sql.Timestamp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.ActivityOneDay;
import main.pojo.Order;
import main.pojo.OrderFrequency;

@Mapper
@Repository
public interface OrderDao extends BaseMapper<Order>{
    public List<Order> selectByUserId(Integer id);
    public List<Order> selectByRestaurantId(Integer id);
    public List<Integer> getLoyalCustomerIds(@Param("restaurantId") Integer restaurantId,@Param("startTime") Timestamp startTime,@Param("threshold") Integer threshold);    
    public List<OrderFrequency> getOrderFrequencyForRestaurantByPeriod(@Param("restaurandId") Integer restaurantId,@Param("startTime") Timestamp startsTime,@Param("Period") String period);
    public List<ActivityOneDay> getActivityInOneDayForRestaurant(@Param("restaurantId") Integer restaurantId,@Param("startTime") Timestamp startTime);    

}
