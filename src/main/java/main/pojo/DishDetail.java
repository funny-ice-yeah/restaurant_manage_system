package main.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDetail {
    private Dish dish;
    private String allergies;
    private String nutritions;
    private String ingredients;
    private List<DishReview> dishReviews;
}
