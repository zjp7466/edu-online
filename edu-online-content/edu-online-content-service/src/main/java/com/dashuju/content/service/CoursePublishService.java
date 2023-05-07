package com.dashuju.content.service;

import com.dashuju.content.model.dto.CoursePreviewDto;
import com.dashuju.content.model.po.CoursePublish;

import java.io.File;

public interface CoursePublishService {

    /**
     * @description 获取课程预览信息
     * @param courseId 课程id
     * @return com.dashuju.content.model.dto.CoursePreviewDto
     */
    CoursePreviewDto getCoursePreviewInfo(Long courseId);

    /**
     * @description 提交审核
     * @param courseId  课程id
     * @return void
     */
    void commitAudit(Long companyId,Long courseId);

    /**
     * @description 课程发布接口
     * @param companyId 机构id
     * @param courseId 课程id
     * @return void
     */
    void publish(Long companyId,Long courseId);
    /**
     * @description 课程静态化
     * @param courseId  课程id
     * @return File 静态化文件
     */
    public File generateCourseHtml(Long courseId);
    /**
     * @description 上传课程静态化页面
     * @param file  静态化文件
     * @return void
     */
    public void  uploadCourseHtml(Long courseId,File file);

    public CoursePublish getCoursePublish(Long courseId);

}
/**
 * @description 课程预览、发布接口
 * @author 74667
 * @date 2023/4/26 15:28
 * @version 1.0
 */