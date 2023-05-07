package com.dashuju.ucenter.service;

import com.dashuju.ucenter.model.dto.AuthParamsDto;
import com.dashuju.ucenter.model.dto.XcUserExt;

public interface AuthService {
    /**
     * @description 认证方法
     * @param authParamsDto 认证参数
     * @return com.dashuju.ucenter.model.po.XcUser 用户信息
     */
    XcUserExt execute(AuthParamsDto authParamsDto);

}
/**
 * @description 认证service
 * @author 74667
 * @date 2023/5/3 14:19
 * @version 1.0
 */