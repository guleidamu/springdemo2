package com.skyon.dc.runner;

import com.skyon.dc.config.KeyConfiguration;
import com.skyon.dc.util.RsaKeyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * 生成公钥/私钥
 */
@Configuration
public class AuthServerRunner implements CommandLineRunner{
    private static final String REDIS_SERVICE_PRI_KEY = "DC:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "DC:AUTH:CLIENT:PUB";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
        if(redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)) {
            keyConfiguration.setServicePriKey(
                    RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString()));
            keyConfiguration.setServicePubKey(
                    RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
        } else {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(keyConfiguration.getSecret());
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
        }
    }
}

