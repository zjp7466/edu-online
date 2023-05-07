package com.dashuju.learning.service;

import com.dashuju.base.model.PageResult;
import com.dashuju.learning.model.dto.MyCourseTableParams;
import com.dashuju.learning.model.dto.XcChooseCourseDto;
import com.dashuju.learning.model.dto.XcCourseTablesDto;
import com.dashuju.learning.model.po.XcCourseTables;


public interface MyCourseTablesService {

    /**
     * @description 添加选课
     * @param userId 用户id
     * @param courseId 课程id
     * @return com.dashuju.learning.model.dto.XcChooseCourseDto
     */
    XcChooseCourseDto addChooseCourse(String userId, Long courseId);

    /**
     * @description 判断学习资格
     * @param userId
     * @param courseId
     * @return XcCourseTablesDto 学习资格状态 [{"code":"702001","desc":"正常学习"},{"code":"702002","desc":"没有选课或选课后没有支付"},{"code":"702003","desc":"已过期需要申请续期或重新支付"}]
     */
    XcCourseTablesDto getLearningStatus(String userId, Long courseId);
    //添加选课
    boolean saveChooseCourseSuccess(String chooseCourseId);
    /**
     * @description 我的课程表
     * @param params
     * @return com.dashuju.base.model.PageResult<com.xuecheng.learning.model.po.XcCourseTables>
     */
    PageResult<XcCourseTables> mycoursetables(MyCourseTableParams params);

}

/**
 * @description 我的课程表service接口
 * @author 74667
 * @date 2023/5/4 13:24
 * @version 1.0
 */