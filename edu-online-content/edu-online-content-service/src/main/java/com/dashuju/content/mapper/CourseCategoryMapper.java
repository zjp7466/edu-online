package com.dashuju.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dashuju.content.model.dto.CourseCategoryTreeDto;
import com.dashuju.content.model.po.CourseCategory;

import java.util.List;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author zjp
 */
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {
    public List<CourseCategoryTreeDto> selectTreeNodes(String id);
}
