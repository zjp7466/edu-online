package com.dashuju.content.service.impl;

import com.dashuju.content.model.dto.CourseBaseInfoDto;
import com.dashuju.content.model.dto.CoursePreviewDto;
import com.dashuju.content.model.dto.TeachplanDto;
import com.dashuju.content.service.CourseBaseInfoService;
import com.dashuju.content.service.CoursePublishService;
import com.dashuju.content.service.TeachplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursePublishServiceImpl implements CoursePublishService {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Autowired
    TeachplanService teachplanService;


    @Override
    public CoursePreviewDto getCoursePreviewInfo(Long courseId) {
        //课程基本信息、营销信息
        CourseBaseInfoDto courseBaseInfo = courseBaseInfoService.getCourseBaseInfo(courseId);
        //课程计划信息
        List<TeachplanDto> teachplanTree= teachplanService.findTeachplanTree(courseId);
        CoursePreviewDto coursePreviewDto = new CoursePreviewDto();
        coursePreviewDto.setCourseBase(courseBaseInfo);
        coursePreviewDto.setTeachplans(teachplanTree);
        return coursePreviewDto;
    }
}

/**
 * @description TODO
 * @author 74667
 * @date 2023/4/26 15:29
 * @version 1.0
 */