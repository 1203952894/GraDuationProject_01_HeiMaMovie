package xyz.ccola.common;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Name: JwtUtil
 * @ Author: Cola
 * @ Time: 2022/12/16 20:17
 * @ Description: JwtUtil
 *  JSON Web Token 用于管理员权限鉴定
 */

public class JwtUtil {

    /**
     *  Token 生成
     * @param claims  载荷体 Payload
     * @return 根据 载荷体 以及盐值生成的 Token
     */
    public static String createToken(Map claims) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))//设置有效时间为1天
                .setClaims(claims) //设置响应数据体
                .signWith(SignatureAlgorithm.HS256, "ColaAndXiaoEr") //设置加密方法和加密盐
                .compact();
    }

    /**
     * Token 解析
     * @param token 需要鉴定的 Token
     * @return 以 Map 形式返回相应 Token 中的载荷体 Payload
     */
    public static Map parseToken(String token) {
        return Jwts.parser().setSigningKey("ColaAndXiaoEr")
                .parseClaimsJws(token)
                .getBody();
    }


}
