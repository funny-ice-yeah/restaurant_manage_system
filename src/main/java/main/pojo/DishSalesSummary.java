package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishSalesSummary {
    private Integer dishId;
    private String dishName;
    private Integer totalSales;
}
