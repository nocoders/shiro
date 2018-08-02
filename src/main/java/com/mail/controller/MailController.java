package com.mail.controller;

import com.mail.util.MailManager;
import com.mail.service.MailService;
import com.mail.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;

/**
 * Created by linmeng.
 **/
@RestController
public class MailController {

    @Autowired
    private MailManager mailManager;

    @Autowired
    private MailService mailService;

    @Autowired
    private MailUtil mailUtil;

    /**
     * 发送邮件
     */
    @RequestMapping("/email")
    public void sendMail(){
        String emailMsg = "测试发送邮件";
        try{
            mailManager.sendMail("1812323571@qq.com", emailMsg);
            mailService.sendHtmlMail("1812323571@qq.com","邮件发送测试","<a href='www.baidu.com' >百度一下</a>");
            //mailUtil.sendMail("2890657914@qq.com","邮件发送测试","<a href='www.baidu.com' >百度一下</a>");
        } catch(AddressException e) {
            e.printStackTrace();
        } catch(MessagingException e) {
            e.printStackTrace();
        } catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
