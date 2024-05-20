package main.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoyalCustomerDistribution {
    private Integer userId;
    private String userName;
    private List<CustomerOrderDistribution> customerOrderDistributions;
     
}

