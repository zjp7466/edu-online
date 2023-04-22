package com.dashuju.base.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PageParams implements Serializable {

    //当前页码
    private Long pageNo = 1L;

    //每一页的数据量（条数）
    private Long pageSize = 10L;

    public PageParams(){}

    public PageParams(long pageNo, long pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

}
/**
 * @description 分页查询
 * @author 74667
 * @date 2023/4/22 18:33
 * @version 1.0
 */