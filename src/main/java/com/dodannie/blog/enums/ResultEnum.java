package com.dodannie.blog.enums;

import lombok.Getter;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/27 19:25
 */
@Getter
public enum ResultEnum {
    /**
     * 返回结果枚举
     */
    SUCCESS(20000,"操作成功"),
    ERROR(40000,"操作失败"),
    DATA_NOT_FOUND(40001,"查询失败"),
    PARAMS_BULL(40002,"参数不能为空"),
    PARAMS_ERROR(40005, "参数不合法！"),
    NOT_LOGIN(40003,"当前账号未登录")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
