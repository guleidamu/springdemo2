package com.thinkInJava.book.tryCatch;

import lombok.extern.slf4j.Slf4j;

import java.rmi.RemoteException;

@Slf4j
public class ThrowDemo {

    private final static Double PI = 3.141592654;
    private final static Float P = 3.141592654F;
    private Integer number =null;

    /**
     * 2个浮点数相除：1.0/0.0 不会报错，无穷大 Infinity。0.0可以做除数，用Exception抛出异常
     * @param no1
     * @param no2
     * @return
     * @throws Exception
     */
    public Float getQuotient (Float no1, Float no2) throws Exception{
        Float quotient;
        quotient = no1/no2;
        return quotient;
    }

    public Float getCircleAcreage (Float radius) throws Exception{
        Float acreage;
        acreage = radius * P;
        return acreage;
    }

    /**
     * throw new Exception 要添加try Catch或者throws
     */
    public int throwException (int no1, int no2){
        log.info("getQuotientInt: ");
        try {
            throw new RemoteException();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
//        return 0;
        int quotient;
        quotient = no1/no2;
        return quotient;
    }

    /**
     * 当0作为除数时会报错，ArithmeticException：/by zero
     * @param no1
     * @param no2
     * @return
     * @throws Exception
     */
    public int getQuotientInt (int no1, int no2) throws Exception{
        log.info("getQuotientInt: ");
        int quotient;
        quotient = no1/no2;
        return quotient;
    }

    /**
     * 用浮点型除以整型
     * @param no1
     * @param no2
     * @return
     * @throws Exception
     */
    public float getQuotientFloatInt (float no1, int no2) throws Exception{
        float quotient;
        quotient = no1/no2;
        return quotient;
    }

    //查看throws遇到一个异常，是否还会继续下一个异常:不会再执行下去。
    public int getQuotientFloatInt()  throws Exception{
        int i = 0, j = 1;
        int k = 1/0;
        String numberToString = number.toString();

        return k;
    }

    //throws 里面包含try catch。会报哪个错误：报那个会让程序挂掉的异常，tryCatch还是照常执行
    public int tryCatchAndException()  throws Exception{
        int i = 0, j = 1;
        int k = 0;
        try {
            k = 1/0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        String numberToString = number.toString();

        return k;
    }


}
