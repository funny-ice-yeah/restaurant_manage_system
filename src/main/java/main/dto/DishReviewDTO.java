package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishReviewDTO {
    private Integer reviewId;
    private String dishName;
    private Integer rating;
    private String content;
}
