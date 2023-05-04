package com.orion.outlook.common.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author WCY
 * @since 2023-05-04
 */
public class ResponseDto<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    private String traceId;

    public ResponseDto() {}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto<?> that = (ResponseDto<?>) o;
        return (
            Objects.equals(code, that.code) &&
            Objects.equals(msg, that.msg) &&
            Objects.equals(data, that.data) &&
            Objects.equals(traceId, that.traceId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data, traceId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseDto.class.getSimpleName() + "[", "]")
            .add("code=" + code)
            .add("msg='" + msg + "'")
            .add("data=" + data)
            .add("traceId='" + traceId + "'")
            .toString();
    }
}
