package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDistribution {
    private Integer dishId;
    private String dishName;
    private Integer totalPurchase;    
}
