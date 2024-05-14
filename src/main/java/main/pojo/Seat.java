package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private Integer seatId;
    private String location;
    private Integer canteenId;
    private String status;
}
