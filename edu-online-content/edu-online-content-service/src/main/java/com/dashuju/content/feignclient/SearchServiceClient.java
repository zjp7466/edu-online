package com.dashuju.content.feignclient;

import com.dashuju.content.model.dto.CourseIndex;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "search",fallbackFactory = SearchServiceClientFallbackFactory.class)
public interface SearchServiceClient {

    @PostMapping("/search/index/course")
    public Boolean add(@RequestBody CourseIndex courseIndex);
}

/**
 * @description 搜索服务远程接口
 * @author 74667
 * @date 2023/4/28 13:40
 * @version 1.0
 */