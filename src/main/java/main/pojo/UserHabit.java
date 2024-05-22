package main.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHabit {
    private Integer totalOrderNum;
    private List<DishSalesSummary> dishSalesSummaries;   
}
