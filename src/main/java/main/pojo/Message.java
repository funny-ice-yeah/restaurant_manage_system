package main.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @TableId(type=IdType.AUTO)
    private Integer messageId;
    private String subject;
    private String content;
    private Integer userId;
    private Integer orderId;
}
