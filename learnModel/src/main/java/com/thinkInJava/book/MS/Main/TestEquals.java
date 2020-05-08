package com.thinkInJava.book.MS.Main;

import com.thinkInJava.book.MS.Model.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * ==比较基本类型，比较的是值是否相等，比较的是引用类型，比较地址是否相等。
 * new出来的对象，==，都是false
 * equals如果没有重写，那就相当于==（那就是调用Object类的equals，那就是引用==），重写另当别论
 */
public class TestEquals {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println("s1=s2?" + s1==s2);
        System.out.println("s1.equals(s2)" + s1.equals(s2));
        //HashSet底层数据结构是HashMap，可以直接点击进去
        Set<String> set01 = new HashSet<>();
        set01.add(s1);
        set01.add(s2);
        System.out.println("s1,s2的hashCode（）" + s1.hashCode()+"\t" + s2.hashCode());
        System.out.println("set01.size()" + set01.size());

        System.out.println(">>>>>>>>>>>>>>>>>");

        Person p1 = new Person("abc");
        Person p2 = new Person("abc");
        System.out.println("p1,p2的hashCode（）"+p1.hashCode() + "\t" + p2.hashCode());
        System.out.println((p1 == p2));
        //如果Person对象修饰是用@Data（@Data会重写equals），那这个equals方法调用的是不一样的方法
        System.out.println(p1.equals(p2));

        Set<Person> set02 = new HashSet<>();
        set02.add(p1);
        set02.add(p2);
        System.out.println("set02.size()" + set02.size());

    }
}
