package com.example.demo.common.domain;

public class Messenger {

    private int code;
    private String message;

    // 기본 생성자
    public Messenger() {
    }

    // 생성자
    public Messenger(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
