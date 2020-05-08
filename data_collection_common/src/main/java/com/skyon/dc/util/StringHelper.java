package com.skyon.dc.util;

public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj == null ? "" : obj.toString();
    }
}
