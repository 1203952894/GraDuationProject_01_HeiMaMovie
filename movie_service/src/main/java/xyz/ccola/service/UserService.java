package xyz.ccola.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.ccola.domain.User;

/**
 * @ Name: UserService
 * @ Author: Cola
 * @ Time: 2022/12/16 20:08
 * @ Description: UserService
 */
public interface UserService extends BaseMapper<User> {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User login(String username, String password);
}
