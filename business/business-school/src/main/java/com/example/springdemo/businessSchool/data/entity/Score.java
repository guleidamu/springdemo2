package com.example.springdemo.businessSchool.data.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:28 2020/7/2
 * @ Modified By：
 * @Version: 1.0.0
 */
@Entity   //注解表示这个是实体类
@Table(name ="score ")   //表示这个类对应的表名是product_
public class Score implements Serializable {

    @Id  //表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //表示自增长方式
    @Column(name = "id")  //表示对应的表score的字段名
    private Integer id;


    @Column(name = "sno")  //表示对应的表score的字段名
    private String sno;

    @Column(name = "cno")  //表示对应的表score的字段名
    private String cno;

    @Column(name = "score")  //表示对应的表score的字段名
    private BigDecimal score;

    @Column(name = "create_time")  //表示对应的表score的字段名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @Column(name = "update_time")  //表示对应的表score的字段名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }


}
