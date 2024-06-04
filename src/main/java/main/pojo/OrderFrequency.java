package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFrequency {
    String period;//按周的格式为"年-周数"（2024-18为2024年的第18周）；按月的格式为“年-月”；按年的格式为“年”
    Integer orderNum;
}
