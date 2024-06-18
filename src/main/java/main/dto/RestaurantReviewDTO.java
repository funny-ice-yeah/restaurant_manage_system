package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReviewDTO {
    private String reviewId;
    private String restaurantName;
    private Integer rating;
    private String content;
}
