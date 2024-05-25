package main.pojo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatReservation {
    private Integer seatId;
    private Integer userId;
    private Timestamp time;
    private Timestamp createdAt;
    private String status;
}
