package com.thinkInJava.book.MS.Main;

public class equals2 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s7 = "abc";
        String s2 = new String("abc");
        String s8= new String("abc");
        String s3 = "abc";
        String s4 = "xxx";
        String s5 = "abc" + "xxx";
        String s6 = s3 + s4;
        String s9= new String("abcxxx");

        System.out.println(s1 == s2);
        System.out.println(s1 == s7);
        System.out.println(s2.equals(s8));
        System.out.println(s2 == s8);
        System.out.println(s1.equals(s2));
        System.out.println(">>>>>>>>>>>>>");
        System.out.println(s1 == s5);
        System.out.println();
        System.out.println(s9 == s5);
        System.out.println(">>>>>>>>>>>>>");
        System.out.println(s9.equals(s5));
        System.out.println(s1 == s6);
        System.out.println(s9 + ""+ s5);
        System.out.println(s5.equals(s6));
        System.out.println();
        /**
         * 返回字符串对象的规范表示形式。
         * 字符串最初位空，由类字符串私下维护。
         * 调用intern方法时，如果池中已包含equals（object）方法确定的与此string对象相等的字符串
         * 则返回池中的字符串。否则，此字符串对象将添加到池中，并返回对此字符串对象的引用。
         * 因此，对于任意两个字符串s和t，s.intern()==t.intern()在且仅当s.equals（t）为true时为true
         *
         */
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
