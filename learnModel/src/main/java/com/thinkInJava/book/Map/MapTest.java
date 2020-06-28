package com.thinkInJava.book.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {
    public void addElement(){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> table = new Hashtable<>();
        map.put("you","are beautiful");
        int hashCode = map.hashCode();
        System.out.println("hashCode: " + hashCode);
    }

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.addElement();
    }

}
