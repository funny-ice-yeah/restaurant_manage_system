package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import main.pojo.OrderDetail;

@Mapper
@Repository
public interface OrderDetailDao {
    public List<OrderDetail> selectByDishId(Integer id);
    public List<OrderDetail> selectByOrderId(Integer id);
}
