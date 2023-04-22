package com.dashuju.content.service.impl;

import com.dashuju.content.model.po.CourseAudit;
import com.dashuju.content.mapper.CourseAuditMapper;
import com.dashuju.content.service.CourseAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 */
@Slf4j
@Service
public class CourseAuditServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditService {

}
