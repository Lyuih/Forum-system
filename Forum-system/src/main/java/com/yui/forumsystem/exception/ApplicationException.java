package com.yui.forumsystem.exception;

import com.yui.forumsystem.common.AppResult;


/**
 * 自定义异常类
 * 继承RuntimeException
 */
public class ApplicationException extends RuntimeException {

    //自定义异常
    protected AppResult errResult;

    //自定状态码，异常描述
    public ApplicationException(AppResult errResult) {
        super(errResult.getMessage());
        this.errResult = errResult;
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public AppResult getErrResult() {
        return errResult;
    }
}
