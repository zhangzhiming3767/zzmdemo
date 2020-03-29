package com.example.zzmdemo.controller;

import com.example.zzmdemo.entity.response.Response;
import com.example.zzmdemo.entity.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/27 21:51
 */
@RestController
@RequestMapping("/mailTest")
public class MailController {
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送纯文本邮件.
     *
     * @param to      目标email 地址
     * @param subject 邮件主题
     * @param text    纯文本内容
     */
//    @PostMapping(value = {"/sendEmail"})
//    public Response sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        javaMailSender.send(message);
//        return new SuccessResponse();
//    }

    /**
     * @author :zhangzhiming
     * description :发送成功
     * to=2636971612@qq.com&subject=邮件主题&text=这是文本内容
     * @date :Create in  2020/3/29 20:02
     * @param type 邮件类型 1纯文本邮件
     */
    @PostMapping(value = {"/sendEmailV2"})
    public Response sendEmailV2(String mailTo, String mailTitle, String mailText,String photoSrc,Integer type) throws Exception {

        // 返回创建好的邮件对象
        String mailFrom = "694332301@qq.com";
        String passwordMailFrom = "bhjroestjhdpbfjf";
        String mailHost = "smtp.qq.com";
        Properties prop = new Properties();
        prop.setProperty("mail.host", mailHost);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        // 使用JavaMail发送邮件的5个步骤
        // 1、创建session
        Session session = Session.getInstance(prop);
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        // 2、通过session得到transport对象
        Transport ts = session.getTransport();
        // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(mailHost, mailFrom, passwordMailFrom);
        // 4、创建邮件 纯文字
        Message message = null;
        if(type==1){
            message = createSimpleMail(session, mailFrom, mailTo, mailTitle, mailText);
        }else if(type==2) {
            message = createImageMail(session, mailFrom, mailTo, mailTitle, mailText,photoSrc);
        }else {
            message = createAttachMail(session, mailFrom, mailTo, mailTitle, mailText,photoSrc);
        }
        // 5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
        return new SuccessResponse();
    }


    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public MimeMessage createSimpleMail(Session session, String mailfrom, String mailTo, String mailTittle,
                                        String mailText) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress(mailfrom));
        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        // 邮件的标题
        message.setSubject(mailTittle);
        // 邮件的文本内容
        message.setContent(mailText, "text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
    }

    /**
     * @param session
     * @return
     * @throws Exception
     * @Method: createImageMail
     * @Description: 生成一封邮件正文带图片的邮件
     */
    public static MimeMessage createImageMail(Session session, String mailFrom, String mailTo, String mailTittle,
                                              String mailText, String photoSrc) throws Exception {
        // 创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
// 发件人
        message.setFrom(new InternetAddress(mailFrom));
        // 收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        // 邮件标题
        message.setSubject(mailTittle);
        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        // 需要修改
        text.setContent(mailText + "<img src='cid:xxx.jpg'>", "text/html;charset=UTF-8");
        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        // 需要修改
        DataHandler dh = new DataHandler(new FileDataSource(photoSrc));
        image.setDataHandler(dh);
        // 需要修改
        image.setContentID("xxx.jpg");
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");
        message.setContent(mm);
        message.saveChanges();
        // 将创建好的邮件写入到F盘以文件的形式进行保存
//        message.writeTo(new FileOutputStream("F:/Program Files/TestMail/ImageMail.eml"));// 需要修改
        // 返回创建好的邮件
        return message;
    }

    /**
     * @Method: createAttachMail
     * @Description: 创建一封带附件的邮件
     */
    public static MimeMessage createAttachMail(Session session, String mailFrom, String mailTo, String mailTittle,
                                               String mailText,String photoSrc) throws Exception {
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        message.setFrom(new InternetAddress(mailFrom));	// 发件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));// 收件人
        // 邮件标题
        message.setSubject(mailTittle);
        // 创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(mailText, "text/html;charset=UTF-8");
        // 创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(photoSrc));// 需要修改
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());
        // 创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");
        message.setContent(mp);
        message.saveChanges();
        // 将创建的Email写入到F盘存储
//        message.writeTo(new FileOutputStream("F:/Program Files/TestMail/ImageMail.eml"));// 需要修改
        // 返回生成的邮件
        return message;
    }
}
