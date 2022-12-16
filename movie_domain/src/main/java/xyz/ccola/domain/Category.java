package xyz.ccola.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Name: Category
 * @ Author: Cola
 * @ Time: 2022/12/16 20:25
 * @ Description: Category 导航类
 */
@TableName("tb_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    /*
    主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /*
    栏目名称
     */
    private String name;
}
