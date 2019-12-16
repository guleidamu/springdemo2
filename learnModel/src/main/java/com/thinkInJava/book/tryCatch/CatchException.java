package com.thinkInJava.book.tryCatch;

import lombok.extern.slf4j.Slf4j;
/*
使用try和catch关键字可以捕获异常。Try/catch代码放在异常可能发生的地方。
Try/catch代码中的代码称为保护代码，
try{
	//程序代码
}catch(exception e)
{
	//catch 块
}
Catch语法包含要捕获异常类型的声明。当保护代码块中发生一个异常时，try后面的catch块就会被检查。如果发生的异常包含在catch块中，异常会被传递到该catch块，这和传递一个参数到方法是一样。

 */
@Slf4j
public class CatchException {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public static void main(String[] args) {
        try {
            int a[] = new int[]{2,5};
            log.info("获取的a[3]：" + a[3]);
        } catch (Exception e) {
//            e.printStackTrace();
            log.info("这个是info"+e.getMessage() + ">>>>",e);
            log.error("这个是error"+e.getMessage()+">>>>",e);
        }
        try {//catch是捕捉try里面的异常，
            // 用空指针异常去捕捉“java.lang.ArithmeticException: / by zero”，将捕捉不到
            int s = 5/0;
        } catch (Exception e) {
            //e.printStackTrace();
            log.info(e.getMessage(), e);
        }
        try {
            CatchException catchException = null;
            String testName = catchException.getName();
        } catch (ArithmeticException e) {
            //e.printStackTrace();
            log.info("ArithmeticException:"+e.getMessage()+":end", e);
//            log.info();
        }catch (NullPointerException e){
            //e.printStackTrace();
            log.info("NullPointerException:"+e.getMessage()+":end", e);
//            log.info();
        }catch (ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
            log.info("ArrayIndexOutOfBoundsException:"+e.getMessage()+":end", e);
//            log.info();
        }

    }


}
