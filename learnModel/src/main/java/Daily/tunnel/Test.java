package Daily.tunnel;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:09 2020/7/9
 * @ Modified By：
 * @Version: 1.0.0
 */
public class Test {

    int a = 6;
    static int b = 666;

    public static void main(String[] args) {
        System.out.println("Math1: " + Math.round(8.8));
        System.out.println("Math2: " + Math.round(8.5));
        System.out.println("Math3: " + Math.round(8.3));
        System.out.println("Math4: " + Math.round(-8.8));
        System.out.println("Math5: " + Math.round(-8.5));
        System.out.println("Math6: " + Math.round(-8.3));
        System.out.println("Math7: " + Math.round(-8.51));
//        System.out.println(a);
        System.out.println(b);
    }

    public static void staticMethod(String args) {
//        System.out.println(a);
        System.out.println(b);
//        this.pus();
    }

    private int pus(){
        String string = "5";
        this.staticMethod(string);
        System.out.println(a);
        System.out.println(b);
        return 0;
    }
}
