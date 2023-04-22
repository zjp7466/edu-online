package com.dashuju.content.model.dto;

import com.dashuju.content.model.po.CourseCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {

    List<CourseCategoryTreeDto> childrenTreeNodes;

}
/**
 * @description 课程分类树形表
 * @author 74667
 * @date 2023/4/22 22:50
 * @version 1.0
 */