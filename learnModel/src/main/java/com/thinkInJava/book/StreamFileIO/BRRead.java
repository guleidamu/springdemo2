package com.thinkInJava.book.StreamFileIO;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author damu
 */
@Slf4j
public class BRRead {

    public static void main(String[] args) throws Exception{
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下‘q'键退出。");
        //读取字符
        do{
            c = (char) br.read();
            System.out.println(c);
        }while ( c != 'q');
        log.info("<<<br:" +br);
        if(null != br){
            br.close();
        }
        log.info("<<<>>>br:" +br);
    }
}
