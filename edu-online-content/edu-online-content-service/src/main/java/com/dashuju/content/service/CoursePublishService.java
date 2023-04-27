package com.dashuju.content.service;

import com.dashuju.content.model.dto.CoursePreviewDto;

public interface CoursePublishService {

    /**
     * @description 获取课程预览信息
     * @param courseId 课程id
     * @return com.dashuju.content.model.dto.CoursePreviewDto
     */
    public CoursePreviewDto getCoursePreviewInfo(Long courseId);


}
/**
 * @description 课程预览、发布接口
 * @author 74667
 * @date 2023/4/26 15:28
 * @version 1.0
 */