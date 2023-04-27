package com.dashuju.content.service;

import com.dashuju.content.model.dto.BindTeachplanMediaDto;
import com.dashuju.content.model.dto.SaveTeachplanDto;
import com.dashuju.content.model.dto.TeachplanDto;
import com.dashuju.content.model.po.TeachplanMedia;

import java.util.List;

public interface TeachplanService {
    /**
     * 查询课程计划
     * @param courseId
     * @return
     */
    List<TeachplanDto> findTeachplanTree(long courseId);

    void saveTeachplan(SaveTeachplanDto teachplanDto);

    void deleteTeachplan(Long id);

    /**
     * @description 教学计划绑定媒资
     * @param bindTeachplanMediaDto
     * @return com.dashuju.content.model.po.TeachplanMedia
     */
    public TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);

}
/**
 * @description 关于课程计划
 * @author 74667
 * @date 2023/4/23 13:53
 * @version 1.0
 */