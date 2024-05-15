package main.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canteen {
    @TableId(type=IdType.AUTO)
    private Integer canteenId;
    private String canteenName;
    private String canteenLocation;
}
