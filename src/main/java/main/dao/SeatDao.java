package main.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.Seat;

@Mapper
@Repository
public interface SeatDao {
    public Seat getSeat(Integer id);
    public int createSeat(Seat seat);
    public int updateSeat(Seat seat);
    public int deleteSeat(Integer id);
}
