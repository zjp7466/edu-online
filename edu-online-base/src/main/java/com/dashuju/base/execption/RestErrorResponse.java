package com.dashuju.base.execption;

import java.io.Serializable;

public class RestErrorResponse implements Serializable {
    private String errMessage;

    public RestErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

}
/**
 * @description 错误响应参数包装
 * @author 74667
 * @date 2023/4/23 0:03
 * @version 1.0
 */