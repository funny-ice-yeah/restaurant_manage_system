package main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import main.dao.CanteenDao;
import main.dao.SeatDao;
import main.dao.SeatReservationDao;
import main.pojo.Canteen;
import main.pojo.Seat;
import main.pojo.SeatReservation;
import main.service.CanteenService;

@Service
public class CanteenServiceImpl implements CanteenService{
    @Autowired
    private CanteenDao canteenDao;

    @Autowired
    private SeatDao seatDao;

    @Autowired
    private SeatReservationDao seatReservationDao;

    @Override
    public List<Canteen> selectAllCanteen() {
        return canteenDao.selectList(null);
    }

    @Override
    public List<Seat> selectSeatByCanteenId(Integer id) {
        QueryWrapper<Seat> qw = new QueryWrapper<>();
        qw.eq("seat_id", id);
        return seatDao.selectList(qw);
    }

    @Override
    public List<SeatReservation> selecSeatReservationByUserId(Integer id) {
        QueryWrapper<SeatReservation> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        return seatReservationDao.selectList(qw);
    }

    @Override
    public Boolean insertSeatReservation(SeatReservation seatReservation) {
        Seat seat = seatDao.selectById(seatReservation.getSeatId());
        seat.setStatus("已预约");
        seatDao.updateById(seat);
        return seatReservationDao.insert(seatReservation) > 0;
    }

    @Override
    public Boolean updateSeatReservation(SeatReservation seatReservation) {
        return seatReservationDao.updateById(seatReservation) > 0;
    }
    
}
