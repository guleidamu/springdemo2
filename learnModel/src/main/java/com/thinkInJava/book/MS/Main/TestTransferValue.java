package com.thinkInJava.book.MS.Main;

import com.thinkInJava.book.MS.Model.Person;

/**
 * 基本类型传值，引用类型传地址
 * Person person = new Person()
 * 引用            对象
 * 球场上肯定有胜利者，为什么不能是我
 */
public class TestTransferValue {

    public void changeValue1(int age){
        age = 30;
    }

    public void changeValue2(Person person){
        person.setPersonName("XXXX");
    }

    public void changeValue3(String str){
        str = "xxxx";
    }

    public static void main(String[] args) {
        TestTransferValue testTransferValue = new TestTransferValue();
        int age =20;
        testTransferValue.changeValue1(age);
        System.out.println("age ........" + age);

        Person person = new Person("abc");
        Person person1 = new Person("abc");
//        person1.setPersonName("");
        testTransferValue.changeValue2(person);
        System.out.println("person ........" + person.getPersonName());
        System.out.println("person1 ........" + person1.getPersonName());


        String str = "abc";
        testTransferValue.changeValue3(str);
        System.out.println("String----" + str);
    }
}
