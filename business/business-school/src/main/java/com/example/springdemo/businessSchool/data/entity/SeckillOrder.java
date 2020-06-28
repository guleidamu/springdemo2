package com.example.springdemo.businessSchool.data.entity;

import lombok.*;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 18:18 2020/6/21
 * @ Modified By：
 * @Version: 1.0.0
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeckillOrder {

    private Long id;

    private Long userId;

    private Long orderId;

    private Long goodsId;


}
