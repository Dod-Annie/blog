package com.dodannie.blog.exception;

import com.dodannie.blog.enums.ResultEnum;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 12:29
 */
public class BlogException extends RuntimeException {

    private static final long serialVersionUID = 2450214686001409867L;

    private Integer errorCode = ResultEnum.ERROR.getCode();

    public BlogException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }

    public BlogException(ResultEnum resultEnum, Throwable throwable) {
        super(resultEnum.getMsg(), throwable);
        this.errorCode = resultEnum.getCode();
    }

    public BlogException(Integer errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BlogException(String msg) {
        super(msg);
    }

    public BlogException(Throwable throwable) {
        super(throwable);
    }

    public BlogException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
