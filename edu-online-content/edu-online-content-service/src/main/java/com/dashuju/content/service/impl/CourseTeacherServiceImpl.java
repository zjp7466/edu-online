package com.dashuju.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dashuju.content.mapper.CourseTeacherMapper;
import com.dashuju.content.model.po.CourseTeacher;
import com.dashuju.content.service.CourseTeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTeacherServiceImpl implements CourseTeacherService {

    @Autowired
    CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> courset(Long courseId) {
        LambdaQueryWrapper<CourseTeacher> lqw = new LambdaQueryWrapper();
        lqw.eq(CourseTeacher::getCourseId,courseId);
        List<CourseTeacher> courseTeacher = courseTeacherMapper.selectList(lqw);
        return courseTeacher;
    }

    @Override
    public CourseTeacher editCourseTeacher(CourseTeacher courseTeacher) {
        Long teacherId = courseTeacher.getId();
        if (teacherId != null){
            //update
            CourseTeacher courseTeacher1 = courseTeacherMapper.selectById(teacherId);
            BeanUtils.copyProperties(courseTeacher,courseTeacher1);
            courseTeacherMapper.updateById(courseTeacher1);
        }else {
            //add
            courseTeacherMapper.insert(courseTeacher);
        }
        return courseTeacherMapper.selectById(teacherId);
    }

    @Override
    public void deleteCourseTeacher(Long courseId, Long teacherId) {
        LambdaQueryWrapper<CourseTeacher> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CourseTeacher::getCourseId,courseId).eq(CourseTeacher::getId,teacherId);
        courseTeacherMapper.delete(lqw);
    }
}
/**
 * @description TODO
 * @author 74667
 * @date 2023/4/23 15:02
 * @version 1.0
 */