package main.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @TableId(type=IdType.AUTO)
    private Integer dishId;
    private String dishName;
    private String category;
    private Float currentPrice;
    private String description;
    private String imageUrl;
    private Integer isMainDish;
    private Integer restaurantId;
}
