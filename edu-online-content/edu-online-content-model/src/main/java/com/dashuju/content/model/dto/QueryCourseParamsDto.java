package com.dashuju.content.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryCourseParamsDto {

    //审核状态
    private String auditStatus;

    //课程名称
    private String courseName;

    //发布状态
    private String publishStatus;

}
/**
 * @description 课程查询参数dto
 * @author 74667
 * @date 2023/4/22 18:38
 * @version 1.0
 */