package me.jinwenjie.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

// https://github.com/auth0/java-jwt
public class JWTUtil {
    private static final String SECRET = "KMHprIUvOvvFuCWa";
    private static final String USERID = "uid";
    private static final String ADMIN = "admin";
    private static final String ISSUER = "jinwenjie.me";

    // 7 days
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    // jwt sign normal user
    public static String sign(Integer userId) {
        return sign(userId, false, EXPIRE_TIME);
    }

    // jwt sign admin user
    public static String sign(Integer userId, Boolean admin) {
        return sign(userId, admin, EXPIRE_TIME);
    }

    // jwt sign full
    public static String sign(Integer userId, Boolean admin, long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
            return JWT.create().withClaim(USERID, userId).withClaim(ADMIN, admin).withExpiresAt(date).withIssuer(ISSUER).sign(algorithmHS);
        } catch (Exception e) {
            return null;
        }
    }

    // jwt verify
    public static boolean verify(String token) {
        try {
            Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithmHS).withIssuer(ISSUER).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static Integer getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USERID).asInt();
        } catch (Exception e) {
            return -1;
        }
    }

    public static Boolean checkAdmin(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(ADMIN).asBoolean();
        } catch (Exception e) {
            return false;
        }
    }
}
