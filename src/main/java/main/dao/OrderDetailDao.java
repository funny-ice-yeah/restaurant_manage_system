package main.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.CustomerOrderSales;
import main.pojo.OrderDetail;

@Mapper
@Repository
public interface OrderDetailDao  extends BaseMapper<OrderDetail>{
    public List<OrderDetail> selectByDishId(Integer id);
    public List<OrderDetail> selectByOrderId(Integer id);
    public Integer getTotalSalesByDishId(Integer id);
    public List<Integer> getTopCustomerUserIdByDishId(Integer id);
    public Integer selectTotalSalesByDishIdAndOrdermethodBeforeParticularTime(@Param("DishId")Integer id,@Param("TimeStamp")Timestamp timestamp,@Param("OrderMethod") String orderMethod);
    public List<CustomerOrderSales> getOrderDetailsByRestaurantIdAndUserId(@Param("restaurantId") Integer restaurantId,@Param("userId") Integer userId,@Param("startTime") Timestamp startTime);
}
