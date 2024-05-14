package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer messageId;
    private String subject;
    private String content;
    private Integer userId;
    private Integer orderId;
}
