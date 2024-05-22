package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishSalesData {
    private String dishName;
    private String location;
    private String method;
    private Integer totalSales;
}
