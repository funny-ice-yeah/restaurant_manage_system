package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private Integer dishId;
    private String dishName;
    private String category;
    private Float price;
    private String description;
    private String imageUrl;
    private Integer isMainDish;
    private Integer restaurantId;
    private String ingredient;
    private String allergy;
    private String nutrition;
}
