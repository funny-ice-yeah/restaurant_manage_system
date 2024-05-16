package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSummary {
    private String restaurantName;
    private String briefIntro;
    private List<String> mainDishes;
}
