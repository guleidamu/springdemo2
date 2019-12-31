package com.businessOracle.businessOracle.main;

import com.businessOracle.businessOracle.util.CallBack;
import com.businessOracle.businessOracle.util.CallBackTest;
import com.businessOracle.businessOracle.util.ThreadPool;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreadMainTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("hello" + i);
        }
        ThreadPool<String> tool = new ThreadPool(2, list);
        tool.setCallBackTest(new CallBackTest() {
            @Override
            public void callBackTestMethod(List list) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("yy：" + Thread.currentThread().getId() + ": " + list.get(i) + " ");
                }
                System.out.println("<><<<<<<");
            }
        });
        try {
            tool.excute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        log.info("以下是ids》》》》》");
//        for (int i = 0; i < ids.size(); i++) {
//            log.info("ids：" + ids.get(i));
//        }
    }
}
