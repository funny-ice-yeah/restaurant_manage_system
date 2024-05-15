package main.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishReview {
    @TableId(type=IdType.AUTO)
    private Integer reviewId;
    private String content;
    private Integer rating;
    private Integer userId;
    private Integer dishId;
}
