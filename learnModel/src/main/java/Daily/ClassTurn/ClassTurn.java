package Daily.ClassTurn;

import java.io.UnsupportedEncodingException;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:12 2020/7/13
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ClassTurn {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
        ab = new B();
        String k = "123";
        int i = 5;
        int kdz = Integer.parseInt(k);
        System.out.println( "kdz:" + kdz);
        int kdz1 = Integer.valueOf(k);
        System.out.println("kdz1:" + kdz1);
        String idz = String.valueOf(i);
        System.out.println("idz:" + idz);

        String you = "你好";
        System.out.println("you>>>" + you);
        try {
            String s2 = new String(you.getBytes("GB2312"),"ISO-8859-1");
            System.out.println("s2>>>" + s2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
