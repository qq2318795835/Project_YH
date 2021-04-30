package cn.datasupermacy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtUtil {
    // Token过期时间12销售
    public static final long EXPIRE_TIME =12 * 60 * 60 * 1000;

    /* *
     * @Author lsc
     * <p> 校验token是否正确 </p>
     * @Param token
     * @Param uloginname
     * @Param secret
     * @Return boolean
     */
    public static boolean verify(String token, String uloginname, String upass) {
        try {
            // 设置加密算法
            Algorithm algorithm = Algorithm.HMAC256(upass);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("uloginname", uloginname)
                    .build();
            // 效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }



    /* *
     * @Author lsc
     * <p>生成签名,30min后过期 </p>
     * @Param [uloginname, secret]
     * @Return java.lang.String
     */
    public static String sign(String uloginname, String upass) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(upass);
        // 附带uloginname信息
        return JWT.create()
                .withClaim("uloginname", uloginname)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    /* *
     * @Author lsc
     * <p> 获得用户名 </p>
     * @Param [request]
     * @Return java.lang.String
     */
    public static String getuloginnameByToken(HttpServletRequest request)  {
        String token = request.getHeader("Authorization");
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("uloginname")
                .asString();
    }

    /**
     * 解密token得到uloginname
     * @param token
     * @return
     */
    public static String getuloginnameByToken2(String token)  {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("uloginname")
                .asString();
    }
}
