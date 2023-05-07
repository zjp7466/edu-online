package com.dashuju.learning.service;

import com.dashuju.base.model.RestResponse;

public interface LearningService {
    /**
     * @description 获取教学视频
     * @param courseId 课程id
     * @param teachplanId 课程计划id
     * @param mediaId 视频文件id
     * @return com.dashuju.base.model.RestResponse<java.lang.String>
     */
    RestResponse<String> getVideo(String userId, Long courseId, Long teachplanId, String mediaId);

}
/**
 * @description 学习过程管理service接口
 * @author 74667
 * @date 2023/5/5 22:21
 * @version 1.0
 */