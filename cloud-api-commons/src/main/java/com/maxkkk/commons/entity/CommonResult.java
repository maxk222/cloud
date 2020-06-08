package com.maxkkk.commons.entity;

import com.maxkkk.commons.enums.ResultCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.omg.PortableServer.ServantActivator;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable{

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

    public CommonResult(ResultCode resultCode, String msg, T data) {
        this.code = resultCode.getCode();
        this.msg = msg;
        this.data = data;
    }
}
