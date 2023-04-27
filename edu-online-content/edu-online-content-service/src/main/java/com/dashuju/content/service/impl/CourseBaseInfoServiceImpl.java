package com.dashuju.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashuju.base.execption.EduOnlineException;
import com.dashuju.base.model.PageParams;
import com.dashuju.base.model.PageResult;
import com.dashuju.content.mapper.CourseBaseMapper;
import com.dashuju.content.mapper.CourseCategoryMapper;
import com.dashuju.content.mapper.CourseMarketMapper;
import com.dashuju.content.model.dto.AddCourseDto;
import com.dashuju.content.model.dto.CourseBaseInfoDto;
import com.dashuju.content.model.dto.EditCourseDto;
import com.dashuju.content.model.dto.QueryCourseParamsDto;
import com.dashuju.content.model.po.CourseBase;
import com.dashuju.content.model.po.CourseCategory;
import com.dashuju.content.model.po.CourseMarket;
import com.dashuju.content.service.CourseBaseInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    @Autowired
    CourseBaseMapper courseBaseMapper;
    @Autowired
    CourseMarketMapper courseMarketMapper;
    @Autowired
    CourseCategoryMapper courseCategoryMapper;
    @Override
    public PageResult<CourseBase> courseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {
        LambdaQueryWrapper<CourseBase> lqw = new LambdaQueryWrapper<>();
        //课程名称查询
        String courseName = queryCourseParamsDto.getCourseName();
        lqw.like(StringUtils.isNotEmpty(courseName),CourseBase::getName,courseName);
        //课程审核状态
        String auditStatus = queryCourseParamsDto.getAuditStatus();
        lqw.eq(StringUtils.isNotEmpty(auditStatus),CourseBase::getAuditStatus,auditStatus);
        //课程发布状态
        String publishStatus = queryCourseParamsDto.getPublishStatus();
        lqw.eq(StringUtils.isNotEmpty(publishStatus),CourseBase::getStatus,publishStatus);
        //分页
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page,lqw);
        List<CourseBase> list = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageResult<CourseBase> courseBasePageResult = new PageResult<>(list,total,pageParams.getPageNo(),pageParams.getPageSize());
        return courseBasePageResult;
    }

    @Transactional
    @Override
    public CourseBaseInfoDto createCourseBase(Long companyId,AddCourseDto dto) {
        //合法性校验
        if (StringUtils.isBlank(dto.getName())) {
            EduOnlineException.cast("课程名称为空");
        }
        if (StringUtils.isBlank(dto.getMt())) {
            throw new EduOnlineException("课程分类为空");
        }
        if (StringUtils.isBlank(dto.getSt())) {
            throw new EduOnlineException("课程分类为空");
        }
        if (StringUtils.isBlank(dto.getGrade())) {
            throw new EduOnlineException("课程等级为空");
        }
        if (StringUtils.isBlank(dto.getTeachmode())) {
            throw new EduOnlineException("教育模式为空");
        }
        if (StringUtils.isBlank(dto.getUsers())) {
            throw new EduOnlineException("适应人群为空");
        }
        if (StringUtils.isBlank(dto.getCharge())) {
            throw new EduOnlineException("收费规则为空");
        }
        //新增对象
        CourseBase courseBaseNew = new CourseBase();
        //将填写的课程信息赋值给新增对象
        BeanUtils.copyProperties(dto,courseBaseNew);
        //设置审核状态
        courseBaseNew.setAuditStatus("202002");
        //设置发布状态
        courseBaseNew.setStatus("203001");
        //机构id
        courseBaseNew.setCompanyId(companyId);
        //添加时间
        courseBaseNew.setCreateDate(LocalDateTime.now());
        //插入课程基本信息表
        int insert = courseBaseMapper.insert(courseBaseNew);
        if(insert<=0){
            throw new EduOnlineException("新增课程基本信息失败");
        }
        //向课程营销表保存课程营销信息
        //课程营销信息
        CourseMarket courseMarketNew = new CourseMarket();
        Long courseId = courseBaseNew.getId();
        BeanUtils.copyProperties(dto,courseMarketNew);
        courseMarketNew.setId(courseId);
        int i = saveCourseMarket(courseMarketNew);
        if(i<=0){
            throw new EduOnlineException("保存课程营销信息失败");
        }
        //查询课程基本信息及营销信息并返回
        return getCourseBaseInfo(courseId);
    }
    //保存课程营销信息
    private int saveCourseMarket(CourseMarket courseMarketNew){
        //收费规则
        String charge = courseMarketNew.getCharge();
        if(StringUtils.isBlank(charge)){
            throw new EduOnlineException("收费规则没有选择");
        }
        //收费规则为收费
        if(charge.equals("201001")){
            if(courseMarketNew.getPrice() == null || courseMarketNew.getPrice().floatValue()<=0){
                throw new EduOnlineException("课程为收费价格不能为空且必须大于0");
            }
        }
        //根据id从课程营销表查询
        CourseMarket courseMarketObj = courseMarketMapper.selectById(courseMarketNew.getId());
        if(courseMarketObj == null){
            return courseMarketMapper.insert(courseMarketNew);
        }else{
            BeanUtils.copyProperties(courseMarketNew,courseMarketObj);
            courseMarketObj.setId(courseMarketNew.getId());
            return courseMarketMapper.updateById(courseMarketObj);
        }
    }
    //根据课程id查询课程基本信息，包括基本信息和营销信息
    public CourseBaseInfoDto getCourseBaseInfo(long courseId){

        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if(courseBase == null){
            return null;
        }
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();
        BeanUtils.copyProperties(courseBase,courseBaseInfoDto);
        if(courseMarket != null){
            BeanUtils.copyProperties(courseMarket,courseBaseInfoDto);
        }
        //查询分类名称
        CourseCategory courseCategoryBySt = courseCategoryMapper.selectById(courseBase.getSt());
        courseBaseInfoDto.setStName(courseCategoryBySt.getName());
        CourseCategory courseCategoryByMt = courseCategoryMapper.selectById(courseBase.getMt());
        courseBaseInfoDto.setMtName(courseCategoryByMt.getName());
        return courseBaseInfoDto;

    }

    @Transactional
    @Override
    public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto dto) {
        Long id = dto.getId();
        CourseBase courseBase = courseBaseMapper.selectById(id);
        if (courseBase == null){
            EduOnlineException.cast("不存在此课程");
        }
        if (!courseBase.getCompanyId().equals(companyId)) EduOnlineException.cast("此课程不属于你机构");
        BeanUtils.copyProperties(dto,courseBase);
        courseBase.setChangeDate(LocalDateTime.now());
        courseBase.setChangePeople("zjp");
        courseBaseMapper.updateById(courseBase);
        CourseMarket courseMarket = new CourseMarket();
        BeanUtils.copyProperties(dto,courseMarket);
        saveCourseMarket(courseMarket);
        CourseBaseInfoDto courseBaseInfo = this.getCourseBaseInfo(id);
        return courseBaseInfo;
    }

}
/**
 * @description TODO
 * @author 74667
 * @date 2023/4/22 21:10
 * @version 1.0
 */