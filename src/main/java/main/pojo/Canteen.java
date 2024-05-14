package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canteen {
    private Integer canteenId;
    private String canteenName;
    private String canteenLocation;
}
