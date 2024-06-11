package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    private String password;
    private String userName;
    private String gender; 
    private Integer age;
    private String role;
    private String roleId;    
}
