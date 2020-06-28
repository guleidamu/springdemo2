package com.example.springdemo.businessSchool.constant.redis;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:45 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
public class GoodsKey extends BasePrefix {

    private GoodsKey(String prefix) {
        super(prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey("gl");
    public static GoodsKey getGoodsDetail = new GoodsKey("gd");
    public static GoodsKey getSeckillGoodsStock= new GoodsKey( "gs");

}
