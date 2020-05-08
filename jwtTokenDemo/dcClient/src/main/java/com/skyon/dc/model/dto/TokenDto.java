package com.skyon.dc.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDto implements Serializable {

    private String userId;

    private String userName;

    private String mac;

    private Integer expire;
}
