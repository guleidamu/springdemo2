package com.example.springdemo.businessSchool.config.util;

public class replaceConfig {
    public static String replaceString(String initialData) {
        String initialData1 = initialData.substring(0,initialData.length()-1);
        String initialData2 = initialData.substring(1,initialData.length());
//        String initialData3 = initialData.replace
        return initialData;
    }

    public static void main(String arg[]) {
        String initialData = ",Houston Rocket";
        String afterData = replaceString(initialData);
        System.out.println(afterData);
    }
}
