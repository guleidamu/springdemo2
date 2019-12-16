package com.thinkInJava.book.tryCatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class mainTest {

    private static Float no1 = 34F;
    private static Float no2 = 0F;
    private static Float radius = 8F;
    private static int int1 = 10;
    private static int int2 = 0;

    public static void main(String[] args) {
        ThrowDemo throwDemo = new ThrowDemo();
        try {
            Float quotient = throwDemo.getQuotient(no1,no2);
            log.info("quotient:" + quotient);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("",e);
        }

        try {
            Float data = throwDemo.getCircleAcreage(radius);
            log.info("data: " + data );
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            throwDemo.getQuotientInt(int1, int2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Float n = throwDemo.getQuotientFloatInt(no1, int1);
            log.info("n: " + n);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            throwDemo.getQuotientFloatInt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            throwDemo.tryCatchAndException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
