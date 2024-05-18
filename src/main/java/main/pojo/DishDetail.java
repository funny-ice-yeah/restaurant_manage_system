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
    private List<Allergy> allergies;
    private List<Nutrition> nutritions;
    private List<Ingredient> ingredients;
    private List<DishReview> dishReviews;
}
