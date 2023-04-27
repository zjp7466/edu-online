package com.dashuju.content.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="EditCourseDto", description="修改课程基本信息")
public class EditCourseDto extends AddCourseDto {

    @ApiModelProperty(value = "课程id", required = true)
    private Long id;

}

/**
 * @description 添加课程dto
 * @author 74667
 * @date 2023/4/23 13:30
 * @version 1.0
 */