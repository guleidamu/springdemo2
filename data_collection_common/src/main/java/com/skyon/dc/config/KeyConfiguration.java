package com.skyon.dc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class KeyConfiguration {
    @Value("${jwt.secret}")
    private String secret;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
}
