package com.thinkInJava.book.beginNow;

public class test1 {

    public static void main(String arg[]){
        String v1 = "66";
        int vaint = 0;
        String v4 = null;
        try {
            vaint = Integer.parseInt(v1);
            String v2 = "666 ";
//            int vaint2 = IntegerAndInt.parseInt(v2);
            String v3 = v2.trim();
            v4 = "666k";
            String v5 = "";
            String v6 = v5.trim();
            int vaint5 = Integer.parseInt(v5);
            String v7 = "88.88";
            float valueFloat = Float.parseFloat(v7);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int vaint4 = Integer.parseInt(v4);
        int v8 = 88;
        int v9 = 88;
        if(v8 ==v9){

        }

        System.out.println("转换后的v1的int值" +vaint);
        System.out.println("转换后的v4的int值" +vaint4);
    }
}
