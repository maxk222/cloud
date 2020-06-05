package com.maxkkk.commons.entity;

import com.maxkkk.commons.enums.ResultCode;

import lombok.Getter;

@Getter
public class CommonResult<T> {

    private int code;
    private String msg;
    private T data;

    public CommonResult(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public CommonResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
