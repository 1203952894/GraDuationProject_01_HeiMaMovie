package xyz.ccola.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Name: User
 * @ Author: Cola
 * @ Time: 2022/12/16 20:06
 * @ Description: User
 */
@TableName("tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /*
    主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /*
    用户名
     */
    private String username;
    /*
    密码
     */
    private String password;
}
