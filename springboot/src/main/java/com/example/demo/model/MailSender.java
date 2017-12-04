package com.example.demo.model;

import java.util.List;

/**
 * Created by Alan on 2017/12/1.
 */
public class MailSender {
    // 邮件实体
    private static Mail mail = new Mail();
    public MailSender title(String title){
        mail.setTitle(title);
        return this;
    }

    public MailSender content(String content){
        mail.setContent(content);
        return this;
    }

    public MailSender contentType(MailContentTypeEnum typeEnum) {
        mail.setContent(typeEnum.getValue());
        return this;
    }

    public MailSender targets(List<String> targets) {
        mail.setList(targets);
        return this;
    }

    public void send() throws Exception {
        if (mail.getContentType() == null) {
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }

    }

}
