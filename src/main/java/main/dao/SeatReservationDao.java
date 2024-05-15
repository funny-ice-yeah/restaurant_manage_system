package main.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import main.pojo.SeatReservation;

@Mapper
@Repository
public interface SeatReservationDao extends BaseMapper<SeatReservation>{
    public List<SeatReservation> selectByUserId(Integer id);
    public List<SeatReservation> selectBySeatId(Integer id);
}
