package com.dashuju.content.service;

import com.dashuju.base.model.PageParams;
import com.dashuju.base.model.PageResult;
import com.dashuju.content.model.dto.AddCourseDto;
import com.dashuju.content.model.dto.CourseBaseInfoDto;
import com.dashuju.content.model.dto.EditCourseDto;
import com.dashuju.content.model.dto.QueryCourseParamsDto;
import com.dashuju.content.model.po.CourseBase;

public interface CourseBaseInfoService {

    /**
     * 课程分页查询
     * @param pageParams
     * @param queryCourseParamsDto
     * @return
     */
    PageResult<CourseBase> courseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    /**
     * 添加课程基本信息
     * @param companyId
     * @param addCourseDto
     * @return
     */
    CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);

    /**
     * 根据id查询课程
     * @param courseId
     * @return
     */
    CourseBaseInfoDto getCourseBaseInfo(long courseId);

    /**
     * 课程修改
     * @param companyId
     * @param dto
     * @return
     */
    CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto dto);
}
/**
 * @description TODO
 * @author 74667
 * @date 2023/4/22 21:10
 * @version 1.0
 */