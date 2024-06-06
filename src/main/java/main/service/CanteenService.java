package main.service;
import java.util.List;

import main.pojo.Canteen;
import main.pojo.Seat;
import main.pojo.SeatReservation;;

public interface CanteenService {
    public List<Canteen> selectAllCanteen();
    public List<Seat> selectSeatByCanteenId(Integer id);
    public List<SeatReservation> selecSeatReservationByUserId(Integer id);
    public Boolean insertSeatReservation(SeatReservation seatReservation);
    public Boolean updateSeatReservation(SeatReservation seatReservation);
}
