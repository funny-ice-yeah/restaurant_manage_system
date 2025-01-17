package main.pojo;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("`order`")
public class Order {
    @TableId(type=IdType.AUTO)
    private Integer orderId;
    private String orderStatus;
    private Timestamp orderTime;
    private String orderMethod;
    private Float totalPrice;
    private Timestamp createAt;
    private Integer userId;
    private Integer restaurantId;
}
