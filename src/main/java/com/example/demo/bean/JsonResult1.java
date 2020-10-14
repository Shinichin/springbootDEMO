package com.example.demo.bean;

public class JsonResult1 {
    /**
     * 异常码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String msg;

    public JsonResult1() {
        this.code = "200";
        this.msg = "操作成功";
    }

    public JsonResult1(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

