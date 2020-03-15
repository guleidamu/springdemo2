package com.businessOracle.businessOracle.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel("学生查询条件")
public class SearchStudentDto extends BaseSearchDto{

    @ApiModelProperty(value = "学生名称")
    @NotNull(message = "学生名称不能为空")
    private String name;

//    @Size(min = 10,max =100,message = "数值应该在10 - 100内")
//    private String number;
    @Min(value = 2,message = "数值要大于等于2")
    private Integer num;
}
