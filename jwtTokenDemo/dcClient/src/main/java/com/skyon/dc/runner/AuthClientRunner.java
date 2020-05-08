package com.skyon.dc.runner;

import com.skyon.dc.config.KeyConfiguration;
import com.skyon.dc.util.RsaKeyHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {


    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String REDIS_SERVICE_PUB_KEY = "DC:AUTH:CLIENT:PUB";

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载客户pubKey");
        try {
            refreshServicePubKey();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshServicePubKey() throws IOException{
        if(redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)){
            keyConfiguration.setServicePubKey(
                    RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
        }
    }
}
