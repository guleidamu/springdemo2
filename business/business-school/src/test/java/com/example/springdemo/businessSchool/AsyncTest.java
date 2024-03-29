package com.example.springdemo.businessSchool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 16:34 2020/6/24
 * @ Modified By：
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusinessSchoolApplication.class)
public class AsyncTest {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTest.class);

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @Test
    public void asyncTest() throws InterruptedException, ExecutionException {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<String> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<String> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<String> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        //join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        float exc = (float)(System.currentTimeMillis() - start)/1000;
        logger.info("Elapsed time: " + exc + " seconds");
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }
}
