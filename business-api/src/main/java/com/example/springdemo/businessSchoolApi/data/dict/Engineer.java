package com.example.springdemo.businessSchoolApi.data.dict;

public enum Engineer {

    初级工程师("1","初级工程师"),
    中级工程师("2","中级工程师"),
    高级工程师("3","高级工程师")
    ;

    private  String state;
    private String stateInfo;

    Engineer(String state, String stateInfo){
        this.state =state;
        this.stateInfo = stateInfo;
    }
}
