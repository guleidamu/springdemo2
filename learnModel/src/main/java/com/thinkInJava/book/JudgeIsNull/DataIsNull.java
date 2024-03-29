package com.thinkInJava.book.JudgeIsNull;

import com.thinkInJava.book.object.Circle;
import com.thinkInJava.book.object.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DataIsNull {

    public static void main(String[] args) {
        DataIsNull dataIsNull = new DataIsNull();
        String str = "";
////        dataIsNull.StringIsNull(str);
//        dataIsNull.CollectionIsNull();
//        Circle circle = new Circle();
//        System.out.println(circle.toString());
//        dataIsNull.ObjectNull(circle);
        dataIsNull.StringIsNull(str);
    }

    //    private void StringIsNull(){
//        String data = "";
//        String data1 = null;
//        Integer length = data.length();
//        Integer length1 = data1.length();
//        log.info("length的长度：" + length);
//        log.info("length1的长度：" + length1);
//    }
    private void StringIsNull(String str) {
        String testData = "";
        if (null == testData || testData.length() <= 0) {
            log.info("testData是null");
        } else {
            log.info("testData不是null");
        }
        String testData1;
        if("".equals(str) ){
            System.out.println("");
        }
        if(null == str){
            System.out.println("null");
        }
        if(str.length() ==0 ){
            System.out.println("str.length() ==0");
        }
        if( str == null || str.length() == 0 ){
            System.out.println("str == null || str.length() == 0");
        }
        /**
         *     public static boolean isEmpty(String str) {
         *         return str == null || str.length() == 0;
         *     }
         */
        if (StringUtils.isEmpty(testData)) {
            log.info("test是null");
        } else {
            log.info("不是Null");
        }
    }

    public void ObjectNull(Circle circle1){
        Circle circle = new Circle();
        Circle circle2 = null;
        circle2.getRightHeight();
        if(null == circle){
            System.out.println("null 等于circle");
        }

        if(null == circle1){
            System.out.println("null 等于circle");
        }

        if(ObjectUtils.isEmpty(circle)){
            System.out.println("用ObjectUtils判空");
        }
    }

    private void CollectionIsNull() {
        Circle circle = new Circle();
        Student student = new Student();
        List<Circle> circleList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        if (ObjectUtils.isEmpty(circle)) {
            log.info("circle是空");
        } else if (true) {
            log.info("circle不为空");
        } else {
            log.info("test log");
        }

        if (ObjectUtils.isEmpty(student)) {
            log.info("student是空");
        } else{
            log.info("student不为空");
        }

        if (CollectionUtils.isEmpty(circleList)) {
            log.info("circleList是空");
        } else if (true) {
            log.info("circleList不为空");
        } else {
            log.info("test log");
        }

        if (CollectionUtils.isEmpty(map)) {
            log.info("map是空");
        } else if (true) {
            log.info("map不为空");
        } else {
            log.info("test log");
        }
    }
}
