package main.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @TableId(type=IdType.AUTO)
    private Integer restaurantId;
    private String restaurantName;
    private String account;
    private String password;
    private String location;
    private String briefIntro;
    private Integer cateenId;
}
