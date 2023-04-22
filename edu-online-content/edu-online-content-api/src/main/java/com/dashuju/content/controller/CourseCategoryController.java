package com.dashuju.content.controller;

import com.dashuju.content.model.dto.CourseCategoryTreeDto;
import com.dashuju.content.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseCategoryController {

    @Autowired
    CourseCategoryService categoryService;

    @GetMapping("/course-category/tree-nodes")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        return categoryService.queryTreeNodes("1");
    }

}
/**
 * @description 有关课程分类
 * @author 74667
 * @date 2023/4/22 22:52
 * @version 1.0
 */