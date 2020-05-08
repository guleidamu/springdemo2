package com.skyon.dc.util;


import com.skyon.dc.consant.CommonConstants;
import com.skyon.dc.vo.JWTInfo;
import io.jsonwebtoken.*;
import org.joda.time.DateTime;

/**
 * 非对称加密
 */
public class JWTHelper {
    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     * 密钥加密token
     * @param jwtInfo
     * @param priKey
     * @param expire seconds秒
     * @return
     * @throws Exception
     */
    public static String generateToken(JWTInfo jwtInfo, byte priKey[], int expire) throws Exception{
        String compactJws = Jwts.builder().setSubject(jwtInfo.getMac())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getUserId())
                .claim(CommonConstants.JWT_KEY_USER_NAME, jwtInfo.getUserName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey)).compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws  Exception{
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }

    public static JWTInfo getInfoFormToken(String token, byte[] pubKey) throws Exception{
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new JWTInfo(StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)),
               StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_NAME)),body.getSubject());
    }

}
