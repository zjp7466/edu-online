package com.dashuju.base.execption;

public class EduOnlineException extends RuntimeException{
    private String errMessage;

    public EduOnlineException() {
    }

    public EduOnlineException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public static void cast(CommonError commonError){
        throw new EduOnlineException(commonError.getErrMessage());
    }
    public static void cast(String errMessage){
        throw new EduOnlineException(errMessage);
    }

}
/**
 * @description 项目异常类
 * @author 74667
 * @date 2023/4/23 0:00
 * @version 1.0
 */