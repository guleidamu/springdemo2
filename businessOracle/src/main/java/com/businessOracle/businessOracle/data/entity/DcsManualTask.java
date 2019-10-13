package com.businessOracle.businessOracle.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DcsManualTask implements Serializable {

    private String id;

    private String projectId;

    private String autoTaskId;

    private String cnName;

    private String enName;

    private String insertUser;

    private String insertTime;

    private String enabled;

    private String dataUsers;

    private String checkUsers;
}
