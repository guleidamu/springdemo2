package com.skyon.dc.config;

import com.skyon.dc.util.JWTHelper;
import com.skyon.dc.vo.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientTokenUtil {

    @Autowired
    private KeyConfiguration keyConfiguration;

    public String generateToken(JWTInfo jwtInfo,int expire) throws  Exception{
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getServicePriKey(),expire);
    }

    public JWTInfo getInfoFromToken(String token) throws Exception{
        return JWTHelper.getInfoFormToken(token, keyConfiguration.getServicePubKey());
    }

}
