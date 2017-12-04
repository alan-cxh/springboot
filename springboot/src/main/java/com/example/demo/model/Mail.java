package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 发送邮件所需配置的字段
 * Created by Alan on 2017/12/1.
 */
public class Mail implements Serializable {
//    SMTP服务器
    private String smtpService;
//    端口号
    private String port;
//    设置发送邮箱
    private String fromMailAddress;
//    口令，既密码
    private String fromMailSmptPwd;
//    标题
    private String title;
    private String content;
//    内容格式（默认采用html）
    private String contentType;
//    接受邮件地址集合
    private List<String> list = new ArrayList<>();


    public String getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getFromMailAddress() {
        return fromMailAddress;
    }

    public void setFromMailAddress(String fromMailAddress) {
        this.fromMailAddress = fromMailAddress;
    }

    public String getFromMailSmptPwd() {
        return fromMailSmptPwd;
    }

    public void setFromMailSmptPwd(String fromMailSmptPwd) {
        this.fromMailSmptPwd = fromMailSmptPwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
