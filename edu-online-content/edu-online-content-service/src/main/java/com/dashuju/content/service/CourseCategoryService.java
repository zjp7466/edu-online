package com.dashuju.content.service;

import com.dashuju.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

public interface CourseCategoryService {

    List<CourseCategoryTreeDto> queryTreeNodes(String id);

}
/**
 * @description 关于课程分类
 * @author 74667
 * @date 2023/4/22 22:57
 * @version 1.0
 */