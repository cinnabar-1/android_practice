package com.example.myapplication.entity;

public class ResponseEntity {
    // 搞一个默认值,防止请求不到服务器时，属性为null的情况
    private Integer code = 300;

    private String message = "";

    private Object data = "";

    private String error = "";

    public ResponseEntity() {
    }

    public ResponseEntity(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
