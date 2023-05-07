package com.dashuju.ucenter.service;

import com.dashuju.ucenter.model.po.XcUser;

public interface WxAuthService {

    XcUser wxAuth(String code);

}

/**
 * @description 微信认证接口
 * @author 74667
 * @date 2023/5/3 22:28
 * @version 1.0
 */