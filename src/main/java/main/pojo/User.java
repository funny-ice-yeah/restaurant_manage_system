package main.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @TableId(type=IdType.AUTO)
   private Integer userId;
   private String password;
   private String userName;
   private Integer gender; 
   private Integer age;
   private Integer role;
   private String roleId;
}
