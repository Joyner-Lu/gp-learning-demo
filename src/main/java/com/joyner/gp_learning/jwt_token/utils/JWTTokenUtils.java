package com.joyner.gp_learning.jwt_token.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class JWTTokenUtils {

    /**
     * 共用秘钥-保存在服务端，客户端不会知道秘钥的，以防止被攻击
     */
    public static String SECRET = "FreeMaNong";


    /**
     * 生产token
     */
    public static String createToken() {
        //签发日期
        Date iatDate = new Date();

        //过期日期 1分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, 2);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create().withHeader(map)
                .withClaim("name", "Free码农")
                .withClaim("age", "28")
                .withClaim("org", "今日头条")
                .withExpiresAt(expiresDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 解密token
     */
    public static Map<String, Claim> verifyToken(String token) {
        Verification verification = JWT.require(Algorithm.HMAC256(SECRET));
        JWTVerifier verifier = verification.build();
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = verifier.verify(token);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("出错");
        }
        return decodedJWT.getClaims();
    }

    public static DecodedJWT decodeToken(String token) {
        DecodedJWT decode = JWT.decode(token);
        return decode;
    }

}
