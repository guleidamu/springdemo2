package com.thinkInJava.book.dataTest;

import com.thinkInJava.book.SpecialChar.SpecialChar;

public class CheckData {

    public static void main(String[] args) {
        CheckData checkData  = new CheckData();
        checkData.checkDataF();
    }

    private String name = "r2345234dfgdfSGSFG";
    private String name1 = "r2345234dfgdfSGSF_G";
    private String name2 = "r2345234dfgdfSGSF_G*(()";
    private String name3 = " r2345234dfgdfSGSF_G*(()";
    private String name4 = "ruguo如";
    private void checkDataF(){
        SpecialChar specialChar = new SpecialChar();
        specialChar.isIllegale(name);
        specialChar.isIllegale(name1);
        specialChar.isIllegale(name2);
        specialChar.isIllegale(name3);
        specialChar.isChina(name4);
//        if(specialChar.isSpecialChar(name)){
//            System.out.println("包含特殊字段");
//        }else {
//            System.out.println("不包含特殊字段");
//        }
    }
}
