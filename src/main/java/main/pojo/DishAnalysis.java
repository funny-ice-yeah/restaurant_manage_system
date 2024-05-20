package main.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishAnalysis {
    private Dish dish;
    private Float averageRating;
    private Integer totalSales;
    private List<User> TopCustomers;
}
