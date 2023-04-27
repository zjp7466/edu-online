package com.dashuju.content.service;

import com.dashuju.content.model.po.CourseTeacher;

import java.util.List;

public interface CourseTeacherService {

    List<CourseTeacher> courset(Long courseId);

    /**
     * add/update课程教师信息
     * @param courseTeacher
     * @return po
     */
    CourseTeacher editCourseTeacher(CourseTeacher courseTeacher);

    /**
     * delete teacherinfo
     * @param courseId
     * @param teacherId
     */
    void deleteCourseTeacher(Long courseId, Long teacherId);
}
/**
 * @description TODO
 * @author 74667
 * @date 2023/4/23 15:02
 * @version 1.0
 */