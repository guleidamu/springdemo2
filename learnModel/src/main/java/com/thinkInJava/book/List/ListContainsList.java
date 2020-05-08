package com.thinkInJava.book.List;

import java.util.ArrayList;
import java.util.List;

public class ListContainsList {
    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        List<String> stringList3 = new ArrayList<>();
        List<String> stringList4 = new ArrayList<>();
        List<String> stringList5 = new ArrayList<>();
        List<String> stringList6 = new ArrayList<>();

        stringList1.add("a");
        stringList1.add("b");
        stringList1.add("c");
        stringList1.add("d");
        stringList1.add("aa");
        stringList1.add("ab");
        stringList1.add("ac");
        stringList1.add("ad");

        stringList2.add("a");
//        stringList2.add("b");
        stringList2.add("c");
//        stringList2.add("d");
        stringList2.add("aa");
        stringList2.add("ab");
        stringList2.add("ac");
        stringList2.add("ad");

        stringList3.add("ak");
//        stringList3.add("b");
        stringList3.add("c");
//        stringList3.add("d");
        stringList3.add("aa");
//        stringList3.add("ab");
//        stringList3.add("ac");
//        stringList3.add("ad");

        stringList4.add("a");
        stringList4.add("b");
        stringList4.add("c");
        stringList4.add("d");
        stringList4.add("aa");
        stringList4.add("ab");
        stringList4.add("ac");
        stringList4.add("ad");

        stringList5.add("a");

        stringList6.add("a");
        stringList6.add("b");


        if(stringList1.contains(stringList2)){
            System.out.println("stringList1.contains(stringList2)");
        } else {
            System.out.println("stringList1.NoContains(stringList2)");
        }
        if(stringList1.contains(stringList3)){
            System.out.println("stringList1.contains(stringList3)");
        } else {
            System.out.println("stringList1.NoContains(stringList3)");
        }

        if(stringList1.contains(stringList4)){
            System.out.println("stringList1.contains(stringList4)");
        } else {
            System.out.println("stringList1.NoContains(stringList4)");
        }

        if(stringList1.contains(stringList5)){
            System.out.println("stringList1.contains(stringList5)");
        } else {
            System.out.println("stringList1.NoContains(stringList5)");
        }

        if(stringList1.contains(stringList6)){
            System.out.println("stringList1.contains(stringList6)");
        } else {
            System.out.println("stringList1.NoContains(stringList6)");
        }

        if(stringList1.contains("a")){
            System.out.println("stringList1.contains(\"a\")");
        } else {
            System.out.println("stringList1.NoContains(\"a\")");
        }
    }
}
