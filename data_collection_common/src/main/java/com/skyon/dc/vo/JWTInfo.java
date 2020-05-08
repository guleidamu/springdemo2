package com.skyon.dc.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class JWTInfo implements Serializable {

    private String userId;
    private String userName;
    private String mac;

    public JWTInfo(String userId, String userName, String mac) {
        this.userId = userId;
        this.userName = userName;
        this.mac = mac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JWTInfo jwtInfo = (JWTInfo) o;
//        return Objects.equals(userId, jwtInfo.userId) &&
//                Objects.equals(userName, jwtInfo.userName) &&
//                Objects.equals(mac, jwtInfo.mac);
        if(userName != null ? !userName.equals(jwtInfo.userName) : jwtInfo.userName != null){
            return false;
        }
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId ==null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode():0;
        result = 31 * result + (userId != null ? userId.hashCode():0);
        return result;
    }
}
