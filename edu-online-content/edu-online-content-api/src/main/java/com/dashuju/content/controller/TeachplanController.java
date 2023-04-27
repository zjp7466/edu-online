package com.dashuju.content.controller;

import com.dashuju.content.model.dto.BindTeachplanMediaDto;
import com.dashuju.content.model.dto.SaveTeachplanDto;
import com.dashuju.content.model.dto.TeachplanDto;
import com.dashuju.content.model.po.CourseTeacher;
import com.dashuju.content.service.CourseTeacherService;
import com.dashuju.content.service.TeachplanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "课程计划编辑接口",tags = "课程计划编辑接口")
@RestController
public class TeachplanController {

    @Autowired
    TeachplanService teachplanService;

    @Autowired
    CourseTeacherService courseTeacherService;

    @ApiOperation("查询课程计划树形结构")
    @ApiImplicitParam(value = "courseId",name = "课程Id",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId){
        return teachplanService.findTeachplanTree(courseId);
    }

    @ApiOperation("课程计划创建或修改")
    @PostMapping("/teachplan")
    public void saveTeachplan( @RequestBody SaveTeachplanDto teachplan){
        teachplanService.saveTeachplan(teachplan);
    }

    @ApiOperation("课程计划delete")
    @DeleteMapping("/teachplan/{courseId}")
    public void deleteTeachplan(@PathVariable Long courseId){
        teachplanService.deleteTeachplan(courseId);
    }

    @ApiOperation("查询课程师资")
    @GetMapping("/courseTeacher/list/{courseId}")
    public List<CourseTeacher> courseTeacher(@PathVariable Long courseId){
        return courseTeacherService.courset(courseId);
    }

    @ApiOperation("添加/修改课程师资")
    @PostMapping("/courseTeacher")
    public CourseTeacher editCourseTeacher(@RequestBody CourseTeacher courseTeacher){
        return courseTeacherService.editCourseTeacher(courseTeacher);
    }

    @ApiOperation("删除课程师资")
    @DeleteMapping("courseTeacher/course/{courseId}/{teacherId}")
    public void deleteCourseTeacher(@PathVariable Long courseId, @PathVariable Long teacherId){
        courseTeacherService.deleteCourseTeacher(courseId,teacherId);
    }

    @ApiOperation(value = "课程计划和媒资信息绑定")
    @PostMapping("/teachplan/association/media")
    public void associationMedia(@RequestBody BindTeachplanMediaDto bindTeachplanMediaDto){
        teachplanService.associationMedia(bindTeachplanMediaDto);
    }

    @ApiOperation(value = "课程计划和媒资信息删除")
    @PostMapping("/teachplan/association/media/{teachPlanId}/{mediaId}")
    public void deleteAssociationMedia(@PathVariable(value = "teachPlanId") Long teachPlanId,
            @PathVariable(value = "mediaId")String mediaId){//前端存在bug
        //todo
    }
}
/**
 * @description 关于课程计划/content/teachplan/association/media/null/34543a9d58aeabcbbeaf276c6ba45a86
 * @author 74667
 * @date 2023/4/23 13:46
 * @version 1.0
 */