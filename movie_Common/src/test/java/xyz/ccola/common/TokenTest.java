package xyz.ccola.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Name: TokenTest
 * @ Author: Cola
 * @ Time: 2022/12/16 23:24
 * @ Description: TokenTest
 */
public class TokenTest {

    @Test
    public void testToken(){
        // 生成 Token
        Map<Object, Object> map = new HashMap<>();
        map.put("id",1);
        String token = JwtUtil.createToken(map);

        System.out.println("生成的 Token 为 " + token);
        // 解析
        Map parseMap = JwtUtil.parseToken(token);
        Object id = parseMap.get("id");
        System.out.println(id);
    }
}
