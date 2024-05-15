package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao {
    public List<OrderDao> getOrder(Integer id);
    public List<OrderDao> getOrderByUserId(Integer id);
    public List<OrderDao> getOrderByRestaurantId(Integer id);
    public int createOrder(OrderDao order);
    public int updateOrder(OrderDao order);
    public int deleteOrder(OrderDao order);
}
