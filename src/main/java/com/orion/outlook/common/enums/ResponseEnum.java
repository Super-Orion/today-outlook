package com.orion.outlook.common.enums;

/**
 * @author WCY
 * @since 2023-05-04
 */
public enum ResponseEnum {
    SUCCESS(200, "success"),

    ERROR(400, "请求异常"),

    UNKNOWN_ERROR(500, "系统出现未知异常"),

    BUSINESS_ERROR(2000, "业务异常");

    private final Integer code;

    private final String msg;

    ResponseEnum(Integer code, String msg) {
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
