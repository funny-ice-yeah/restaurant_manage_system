package main.pojo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private String orderStatus;
    private Timestamp orderTime;
    private String orderMethod;
    private Float totalPrice;
    private Timestamp createdAt;
    private Integer userId;
    private Integer restaurantId;
}
