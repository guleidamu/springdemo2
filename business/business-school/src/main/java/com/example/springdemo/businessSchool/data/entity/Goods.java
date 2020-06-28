package com.example.springdemo.businessSchool.data.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:21 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
@Data
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Date createDate;

    private Date updateDate;

    private String goodsDetail;
}
