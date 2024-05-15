package main.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.Seat;

@Mapper
@Repository
public interface SeatDao extends BaseMapper<Seat>{
}
