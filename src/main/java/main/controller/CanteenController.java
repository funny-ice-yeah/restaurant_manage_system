package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.service.CanteenService;
import main.pojo.Canteen;
import main.pojo.Seat;
import main.pojo.SeatReservation;

@RestController
@RequestMapping("/canteen")
public class CanteenController {
    @Autowired
    CanteenService canteenService;

    @GetMapping("/selectAllCanteen")
    public ResponseEntity<List<Canteen>> selectAllCanteen() {
        return ResponseEntity.ok(canteenService.selectAllCanteen());
    }

    @GetMapping("/selectSeatByCanteenId")
    public ResponseEntity<List<Seat>> selectSeatByCanteenId(@RequestParam("canteenId") Integer id){
        return ResponseEntity.ok(canteenService.selectSeatByCanteenId(id));
    }

    @PostMapping("insertSeatReservation")
    public boolean insertSeatReservation(@RequestBody SeatReservation seatReservation){
        return canteenService.insertSeatReservation(seatReservation);
    }

    @PutMapping("updateSeatReservation")
    public boolean updateSeatReservation(@RequestBody SeatReservation seatReservation){
        return canteenService.updateSeatReservation(seatReservation);
    }
}
