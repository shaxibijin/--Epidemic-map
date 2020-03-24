package com.bijin.epidemic.beans;

/**
 * ajax传递的数据
 */
public class AjaxResponseInfo<T> {
    private int code;//应答状态，判断成功失败。-1:参数不足，-2：权限不足，0：正常应答
    private String msg;//应答消息
    private T data;//传递的具体的数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
