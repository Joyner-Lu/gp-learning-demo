package com.joyner.gp_learning.jwt_token.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.Test;

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
public class JWTTokenTest {


    @Test
    public void testGeToken() {
        String token = JWTTokenUtils.createToken();
        System.out.println("token:" + token);
    }

    @Test
    public void verify() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4cCI6MTYxNTk4MTk5NCwiaWF0IjoxNjE1OTgxOTkyLCJhZ2UiOiIyOCJ9.qrztyubMRM0nJ0TgNaUcgq7COVmv4zUeaiJwrU_ZvbY";

        DecodedJWT decodedJWT = JWTTokenUtils.decodeToken(token);
        System.out.println(decodedJWT.getPayload());


        Map<String, Claim> stringClaimMap = JWTTokenUtils.verifyToken(token);
        System.out.println();

    }

    @Test
    public void decode() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4cCI6MTYxNTk4MTk5NCwiaWF0IjoxNjE1OTgxOTkyLCJhZ2UiOiIyOCJ9.qrztyubMRM0nJ0TgNaUcgq7COVmv4zUeaiJwrU_ZvbY";

        DecodedJWT decodedJWT = JWTTokenUtils.decodeToken(token);
        System.out.println(decodedJWT.getClaim("name").asString());

    }

}
