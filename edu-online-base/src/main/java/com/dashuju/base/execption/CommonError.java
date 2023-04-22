package com.dashuju.base.execption;

public enum CommonError {
    UNKOWN_ERROR("执行过程异常，请重试。"),
    PARAMS_ERROR("非法参数"),
    OBJECT_NULL("对象为空"),
    QUERY_NULL("查询结果为空"),
    REQUEST_NULL("请求参数为空");
    private String errMessage;

    public String getErrMessage() {
        return errMessage;
    }
    private CommonError(String errMessage) {
        this.errMessage = errMessage;
    }

}
/**
 * @description 异常枚举
 * @author 74667
 * @date 2023/4/22 23:58
 * @version 1.0
 */