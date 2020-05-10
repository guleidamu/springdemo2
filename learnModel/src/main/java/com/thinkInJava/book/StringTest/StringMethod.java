package com.thinkInJava.book.StringTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringMethod {

    public static void main(String[] args) {
        StringMethod stringMethod = new StringMethod();
        log.info(stringMethod.getNewName(" ")+"n");
    }
    public String getNewName(String name){
        return String.format("dcs_new_tableName_%s",name ==null?"":name.trim());
    }
}
