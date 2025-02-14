package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private Integer restaurantId;
    private String restaurantName;
    private String location;
    private String account;
    private String password;
    private Integer canteenId; 
    private String briefIntro;    
}

