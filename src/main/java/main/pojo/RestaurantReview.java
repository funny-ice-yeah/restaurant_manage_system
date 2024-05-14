package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReview {
    private Integer reviewId;
    private String content;
    private Integer rating;
    private Integer userId;
    private Integer restaurantId;
}
