package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Integer restaurantId;
    private String restaurantName;
    private String account;
    private String password;
    private String location;
    private String briefIntro;
    private Integer cateenId;
}
