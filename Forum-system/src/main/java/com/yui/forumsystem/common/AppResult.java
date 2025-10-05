package com.yui.forumsystem.common;

public class AppResult<T>{

    //状态码
    private long code;

    //描述信息
    private String message;

    //具体的数据
    private T data;

    public AppResult() {}

    public AppResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public AppResult(long code,String message,T data) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    //封装常用方法

    //成功
    public static AppResult success(){
        return new AppResult(ResultCode.SUCCESS.getCode(),  ResultCode.SUCCESS.getMessage());
    }

    /**
     * 成功
     * @param message 自定义信息
     * @return
     */
    public static AppResult success(String message){
        return new AppResult(ResultCode.SUCCESS.getCode(),  message);
    }

    /**
     * 成功
     * @param data 返回的结果
     * @return
     * @param <T>
     */

    public static <T> AppResult<T> success(T data){
        return new AppResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功
     * @param message 自定义信息
     * @param data 返回的结果
     * @return
     * @param <T>
     */
    public static <T> AppResult<T> success(String message,T data){
        return new AppResult(ResultCode.SUCCESS.getCode(), message,data);
    }

    /**
     * 失败
     * @return
     */
    public static AppResult failed(){
        return new AppResult(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }

    /**
     * 失败
     * @param message 自定义信息
     * @return
     */
    public static AppResult failed(String message){
        return new AppResult(ResultCode.FAILED.getCode(), message);
    }

    /**
     * 失败
     * @param data 异常结果
     * @return
     * @param <T>
     */
    public static <T> AppResult<T> failed(T data){
        return new AppResult(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(),data);
    }

    /**
     * 失败
     * @param resultCode 传入枚举类型
     * @return
     */

    public static AppResult failed(ResultCode resultCode){
        return new AppResult(resultCode.getCode(), resultCode.getMessage());
    }

    // setter and getter

    public void setCode(long code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public long getCode() {
        return code;
    }
}
