package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Order;

@Mapper
@Repository
public interface OrderDao extends BaseMapper<Order>{
    public List<Order> selectByUserId(Integer id);
    public List<Order> selectByRestaurantId(Integer id);
}
