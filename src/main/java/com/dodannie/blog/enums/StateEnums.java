package com.dodannie.blog.enums;

import lombok.Getter;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 10:22
 */
@Getter
public enum StateEnums {
    /**
     * 逻辑删除状态
     */
    DELETED(1, "已删除"),
    NOT_DELETED(0, "未删除"),

    /**
     * 启用状态
     */
    ENABLED(1, "启用"),
    NOT_ENABLE(0, "未启用"),

    /**
     * 性别状态
     */
    SEX_MAN(1, "男"),
    SEX_WOMAN(2, "女"),

    /**
     * 请求访问状态枚举
     */
    REQUEST_SUCCESS(1, "请求正常"),
    REQUEST_ERROR(0, "请求异常"),

    /**
     * 用户标识。
     * 0表示管理员，1表示普通用户
     */
    ADMIN(0, "管理员"),
    USER(1, "普通用户");

    private Integer code;
    private String msg;

    StateEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
