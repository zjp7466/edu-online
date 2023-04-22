package com.dashuju.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dashuju.content.service.CourseAuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 */
@Slf4j
@RestController
@RequestMapping("courseAudit")
public class CourseAuditController {

    @Autowired
    private CourseAuditService  courseAuditService;
}