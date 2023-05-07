package com.dashuju.content.controller;

import com.dashuju.base.model.PageParams;
import com.dashuju.base.model.PageResult;
import com.dashuju.content.model.dto.AddCourseDto;
import com.dashuju.content.model.dto.CourseBaseInfoDto;
import com.dashuju.content.model.dto.EditCourseDto;
import com.dashuju.content.model.dto.QueryCourseParamsDto;
import com.dashuju.content.model.po.CourseBase;
import com.dashuju.content.service.CourseBaseInfoService;
import com.dashuju.content.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "关于课程信息", tags = "关于课程信息")
@RestController
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    @PreAuthorize("hasAnyAuthority('xc_teachmanager_course_list')")
    public PageResult<CourseBase> list(PageParams pageParams,
                                       @RequestBody(required = false) QueryCourseParamsDto queryCourseParams){
        //取出用户身份
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        //机构id
        String companyId = user.getCompanyId();
        return courseBaseInfoService.queryCourseBaseList(Long.parseLong(companyId),pageParams,queryCourseParams);
    }

    @ApiOperation("新增课程基础信息")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated AddCourseDto addCourseDto, BindingResult bindingResult){
        Long companyId = 1232141425L;
        return courseBaseInfoService.createCourseBase(companyId,addCourseDto);
    }

    @ApiOperation("根据课程id查询课程基础信息")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId){
//        SecurityUtil.XcUser user = SecurityUtil.getUser();
//        System.out.println(user);
        return courseBaseInfoService.getCourseBaseInfo(courseId);
    }

    @ApiOperation("修改课程基础信息")
    @PutMapping("/course")
    public CourseBaseInfoDto modifyCourseBase(@RequestBody @Validated EditCourseDto editCourseDto, BindingResult bindingResult){
        Long companyId = 1232141425L;
        return courseBaseInfoService.updateCourseBase(companyId,editCourseDto);
    }

}
/**
 * @description 关于课程信息
 * @author 74667
 * @date 2023/4/22 18:44
 * @version 1.0
 **/