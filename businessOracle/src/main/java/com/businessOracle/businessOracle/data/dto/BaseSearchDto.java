package com.businessOracle.businessOracle.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "BaseSearchDto",description = "基础查询条件Dto")
public class BaseSearchDto implements Serializable {

    @ApiModelProperty("页码")
    @NotNull(message = "pageCode(页码)不能为空")
    private Integer pageCode;

    @ApiModelProperty("页大小")
    @NotNull(message = "pageSize(页大小)不能为空")
        private Integer pageSize;
}