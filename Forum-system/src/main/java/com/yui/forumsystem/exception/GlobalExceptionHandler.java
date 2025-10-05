package com.yui.forumsystem.exception;


import com.yui.forumsystem.common.AppResult;
import com.yui.forumsystem.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * 使用@ControllerAdvice注解标记为全局异常处理类
 * 可以定义多个@ExceptionHandler方法来处理不同类型的异常
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public AppResult applicationException(ApplicationException e) {
        //打印异常信息
        e.printStackTrace();//后续生成删除

        log.error(e.getMessage());
        if(e.getErrResult() != null) {
            return e.getErrResult();
        }

        if(e.getMessage() == null|| e.getMessage().isEmpty()) {
            return AppResult.failed(ResultCode.ERROR_SERVICES);
        }

        //返回异常信息
        return AppResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public AppResult exceptionHandler(Exception e) {
        //打印异常信息
        e.printStackTrace();//后续生成删除

        log.error(e.getMessage());

        if(e.getMessage() == null|| e.getMessage().isEmpty()) {
            return AppResult.failed(ResultCode.ERROR_SERVICES);
        }

        //返回异常信息
        return AppResult.failed(e.getMessage());
    }

}
