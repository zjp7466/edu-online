package com.dashuju.content.controller;

import com.dashuju.base.model.PageParams;
import com.dashuju.base.model.PageResult;
import com.dashuju.content.model.dto.AddCourseDto;
import com.dashuju.content.model.dto.CourseBaseInfoDto;
import com.dashuju.content.model.dto.QueryCourseParamsDto;
import com.dashuju.content.model.po.CourseBase;
import com.dashuju.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "关于课程信息", tags = "关于课程信息")
@RestController
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParams){
        return courseBaseInfoService.courseBaseList(pageParams,queryCourseParams);
    }

    @ApiOperation("新增课程基础信息")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody AddCourseDto addCourseDto){
        Long companyId = 1232141425L;
        return courseBaseInfoService.createCourseBase(companyId,addCourseDto);
    }


}
/**
 * @description 关于课程信息
 * @author 74667
 * @date 2023/4/22 18:44
 * @version 1.0
 **/