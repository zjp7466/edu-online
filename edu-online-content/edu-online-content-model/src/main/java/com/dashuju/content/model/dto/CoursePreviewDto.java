package com.dashuju.content.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class CoursePreviewDto {

    //课程基本信息,课程营销信息
    CourseBaseInfoDto courseBase;


    //课程计划信息
    List<TeachplanDto> teachplans;

    //师资信息暂时不加...


}

/**
 * @description 课程预览数据模型
 * @author 74667
 * @date 2023/4/26 15:28
 * @version 1.0
 */