package com.qdsg.his.infrastructure.enums;

public enum OrderSourceEnum {

    businessSource("1","业务平台"),

    manageSource("2","管理后台");

    private String code;
    private String message;

    OrderSourceEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
