package com.thinkInJava.book.SpecialChar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialChar {

    public boolean isSpecialChar(String str){
        String regEx = "[ -_`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
//        System.out.println(p.);
        if(m.find()){
            return true;
        }else{
            return false;
        }
    }


    public String containSpecialChar(String str){
        String regEx = "[ -_`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        System.out.println("");
        if(m.find()){
            return m.toString();
        }else{
            return "";
        }
    }

    public String isData(String str){
        String[] s = new String[]{"abc", "cde","number"};
        for(int i = 0; i<s.length; i++){
            if (s[i].equalsIgnoreCase(str)){
                return s[i];
            }
        }
        return "";
    }

    public void isIllegale(String str){
        String regEx = "[a-zA-Z0-9_]+";
        Boolean flag=str.matches(regEx);
        if (flag){
            System.out.println("数据是合法的" + str);
        }else{
            System.out.println("数据是非法的" + str);
        }
    }

    public void isChina(String str){
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = pattern.matcher(str);
        if(m.find()){
            System.out.println("包含中文");
        }else{
            System.out.println("不包含中文");
        }
    }
}
