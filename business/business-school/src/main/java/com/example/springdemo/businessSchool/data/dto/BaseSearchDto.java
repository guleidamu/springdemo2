package com.example.springdemo.businessSchool.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "BaseSearchDto",description = "基础查询条件Dto")
public class BaseSearchDto implements Serializable {

    @ApiModelProperty("页码")
    private Integer pageCode;

    @ApiModelProperty("页大小")
    private Integer pageSize;
}
