package main.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private Integer managerId;
    private String account;
    private String managerName;
    private String password;
}
