package com.example.springdemo.businessSchoolApi.data.dict;

public enum SexType implements IEnum {
    男("1","男"),
    女("2","女")
    ;

    private  String state;
    private String stateInfo;

    SexType(String state, String stateInfo){
        this.state =state;
        this.stateInfo = stateInfo;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {

    }

    @Override
    public String getStateInfo() {
        return stateInfo;
    }

    @Override
    public void setStateInfo(String stateInfo) {

    }
}
