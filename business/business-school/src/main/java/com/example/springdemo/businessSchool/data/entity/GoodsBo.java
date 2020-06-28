package com.example.springdemo.businessSchool.data.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:30 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsBo {

    private BigDecimal seckillPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

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
