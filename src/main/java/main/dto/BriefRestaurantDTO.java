package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefRestaurantDTO {
    private Integer restaurantId;
    private String restaurantName;
    private String location;
    private String briefIntro;
}
