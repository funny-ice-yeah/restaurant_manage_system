package main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Price;

@Mapper
@Repository
public interface PriceDao {
    public List<Price> getPriceByDishId(Integer id);
    public int createPrice(Price price);
    public int deletePrice(Price price);
}
