package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityOneDay {
    String period;//早晨，中午，晚上，深夜
    Integer orderNum;
}
