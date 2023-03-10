package xyz.ccola.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.ccola.domain.User;

/**
 * @ Name: UserMapper
 * @ Author: Cola
 * @ Time: 2022/12/16 20:09
 * @ Description: UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
