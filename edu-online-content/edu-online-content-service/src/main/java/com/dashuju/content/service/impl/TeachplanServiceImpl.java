package com.dashuju.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dashuju.base.execption.EduOnlineException;
import com.dashuju.content.mapper.TeachplanMapper;
import com.dashuju.content.mapper.TeachplanMediaMapper;
import com.dashuju.content.model.dto.BindTeachplanMediaDto;
import com.dashuju.content.model.dto.SaveTeachplanDto;
import com.dashuju.content.model.dto.TeachplanDto;
import com.dashuju.content.model.po.Teachplan;
import com.dashuju.content.model.po.TeachplanMedia;
import com.dashuju.content.service.TeachplanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeachplanServiceImpl implements TeachplanService {

    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    TeachplanMediaMapper teachplanMediaMapper;
    @Override
    public List<TeachplanDto> findTeachplanTree(long courseId) {
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(courseId);
        return teachplanDtos;
    }

    @Transactional
    @Override
    public void saveTeachplan(SaveTeachplanDto teachplanDto) {
        //课程计划id
        Long id = teachplanDto.getId();
        //修改课程计划
        if(id!=null){
        Teachplan teachplan = teachplanMapper.selectById(id);
        BeanUtils.copyProperties(teachplanDto,teachplan);
        teachplanMapper.updateById(teachplan);
        }else{
        //取出同父同级别的课程计划数量
        int count = getTeachplanCount(teachplanDto.getCourseId(), teachplanDto.getParentid());
        Teachplan teachplanNew = new Teachplan();
        //设置排序号
        teachplanNew.setOrderby(count+1);
        BeanUtils.copyProperties(teachplanDto,teachplanNew);
        teachplanMapper.insert(teachplanNew);
        }
    }

    @Override
    public void deleteTeachplan(Long id) {
        Teachplan teachplan = teachplanMapper.selectById(id);
        if (teachplan.getParentid() == 0){
            LambdaQueryWrapper<Teachplan> lqw = new LambdaQueryWrapper<>();
            lqw.eq(Teachplan::getParentid,id);
            List<Teachplan> teachplans = teachplanMapper.selectList(lqw);
            for (Teachplan teachplan1 : teachplans) {
                Long id1 = teachplan1.getId();
                teachplanMapper.deleteById(id1);
            }
        }
        teachplanMapper.deleteById(id);
    }

    /**
     * @description 获取最新的排序号
     * @param courseId  课程id
     * @param parentId  父课程计划id
     * @return int 最新排序号
     */
    private int getTeachplanCount(long courseId,long parentId){
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getCourseId,courseId);
        queryWrapper.eq(Teachplan::getParentid,parentId);
        Integer count = teachplanMapper.selectCount(queryWrapper);
        return count;
    }

    @Transactional
    @Override
    public TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto) {
        //教学计划id
        Long teachplanId = bindTeachplanMediaDto.getTeachplanId();
        Teachplan teachplan = teachplanMapper.selectById(teachplanId);
        if(teachplan==null){
            EduOnlineException.cast("教学计划不存在");
        }
        Integer grade = teachplan.getGrade();
        if(grade!=2){
            EduOnlineException.cast("只允许第二级教学计划绑定媒资文件");
        }
        //课程id
        Long courseId = teachplan.getCourseId();
        //先删除原来该教学计划绑定的媒资
        teachplanMediaMapper.delete(new LambdaQueryWrapper<TeachplanMedia>().eq(TeachplanMedia::getTeachplanId,teachplanId));
        //再添加教学计划与媒资的绑定关系
        TeachplanMedia teachplanMedia = new TeachplanMedia();
        teachplanMedia.setCourseId(courseId);
        teachplanMedia.setTeachplanId(teachplanId);
        teachplanMedia.setMediaFilename(bindTeachplanMediaDto.getFileName());
        teachplanMedia.setMediaId(bindTeachplanMediaDto.getMediaId());
        teachplanMedia.setCreateDate(LocalDateTime.now());
        teachplanMedia.setChangePeople("zjp");
        teachplanMedia.setCreatePeople("zjp");
        teachplanMediaMapper.insert(teachplanMedia);
        return teachplanMedia;
    }

}
/**
 * @description TODO
 * @author 74667
 * @date 2023/4/23 13:53
 * @version 1.0
 */