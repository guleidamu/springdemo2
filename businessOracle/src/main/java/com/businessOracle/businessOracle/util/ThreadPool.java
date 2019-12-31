package com.businessOracle.businessOracle.util;



import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool<T> {

    //单个线程处理的数据量
    private int singleCount;
    //处理的总数据量
    private int listSize;
    //开启的线程数
    private int runSize;

    //操作的数据集
    private List<T> list;

    //计数器
    private CountDownLatch begin,end;
    //线程池
    private ExecutorService executorService;
    //回调
    private CallBackTest callBackTest;

    public void setCallBackTest(CallBackTest callBackTest){
        this.callBackTest = callBackTest;
    }

    public ThreadPool(int singleCount, List<T> list){
        this.singleCount = singleCount;
        this.list = list;
        if(list != null){
            this.listSize = list.size();
            this.runSize = (this.listSize / this.singleCount)+1;
        }
    }

    public void excute() throws InterruptedException{
        executorService = Executors.newFixedThreadPool(runSize);
        begin = new CountDownLatch(1);
        end = new CountDownLatch(runSize);
        //创建线程
        int startIndex = 0;
        int endIndex = 0;
        List<T> newList = null;
        for(int i = 0; i < runSize; i++){
            //计算每个线程对应的数据
            if(i <(runSize - 1)){
                startIndex = i * singleCount;
                endIndex = (i + 1) * singleCount;
                newList = list.subList(startIndex, endIndex);
            }else{
                startIndex = i * singleCount;
                endIndex = listSize;
                newList = list.subList(startIndex, endIndex);
            }
            //创建线程类处理数据
            MyThread<T> myThread = new MyThread<T>(newList,begin,end) {
                @Override
                public void method(List<T> list) {
//                callBackTest.callBackTestMethod(list);
                callBackTest.callBackTestMethod(list);
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        //计数器减一
        begin.countDown();
        end.await();
        //关闭线程池
        executorService.shutdown();
    }

}
