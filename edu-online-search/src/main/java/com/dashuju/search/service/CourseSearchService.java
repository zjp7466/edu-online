package com.dashuju.search.service;


import com.dashuju.base.model.PageParams;
import com.dashuju.search.dto.SearchCourseParamDto;
import com.dashuju.search.dto.SearchPageResultDto;
import com.dashuju.search.po.CourseIndex;

/**
 * @description 课程搜索service
 */
public interface CourseSearchService {


    /**
     * @description 搜索课程列表
     * @param pageParams 分页参数
     * @param searchCourseParamDto 搜索条件
     * @return com.dashuju.base.model.PageResult<com.dashuju.search.po.CourseIndex> 课程列表
    */
    SearchPageResultDto<CourseIndex> queryCoursePubIndex(PageParams pageParams, SearchCourseParamDto searchCourseParamDto);

 }
