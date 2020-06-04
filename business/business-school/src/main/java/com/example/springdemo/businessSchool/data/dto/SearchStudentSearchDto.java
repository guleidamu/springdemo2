package com.example.springdemo.businessSchool.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("学生查询条件")
public class SearchStudentSearchDto extends BaseSearchDto {

    @ApiModelProperty(value = "学生名称")
    @NotNull(message = "学生名称不能为空")
    private String sname;

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Data birthday;
//
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private String birth;
}
