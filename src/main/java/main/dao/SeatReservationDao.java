package main.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import main.pojo.SeatReservation;

@Mapper
@Repository
public interface SeatReservationDao {
    public List<SeatReservation> getSeatReservationByUserId(Integer id);
    public List<SeatReservation> getSeatReservationBySeatId(Integer id);
    public int createSeatReservation(SeatReservation seatReservation);
    public int updateSeatReservation(SeatReservation seatReservation);
    public int deleteSeatReservation(Integer id);
}
