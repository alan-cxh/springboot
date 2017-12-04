package com.example.demo.enums;

/**
 * Created by Alan on 2017/12/1.
 */
public enum  MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text");
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
