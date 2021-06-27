package com.poverty.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/26 23:25
 */
@Component
@Data
public class MailUtil {
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail(String subject,String[] to
            ,String[] cc,String[] bcc,Date date,String text) {
        // 获取信息封装对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件主题
        message.setSubject(subject);
        // 邮件发送者
        message.setFrom(from);
        // 邮件接收者
        message.setTo(to);
        // 邮件抄送者
        message.setCc(cc);
        // 邮件隐秘抄送者
        message.setBcc(bcc);
        // 邮件发送日期
        message.setSentDate(date);
        // 邮件正文
        message.setText(text);
        // 发送邮件
        javaMailSender.send(message);
    }

    public void sendFileAndImgMail(String subject, String[] to, String[] cc,
                                   String[] bcc, Date date, String text,
                                   String fileName, File file)
            throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        // true 表示构建一个可以带附件的的邮件对象
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        // 邮件主题
        helper.setSubject(subject);
        // 邮件发送者
        helper.setFrom(from);
        // 邮件接收者
        helper.setTo(to);
        if (cc != null) {
            // 邮件抄送者
            helper.setCc(cc);
        }
        if (bcc != null) {
            // 邮件隐秘抄送者
            helper.setBcc(bcc);
        }
        // 邮件发送时间
        helper.setSentDate(date);
        // 邮件正文
        helper.setText(text, true);
        if (file != null) {
            // 邮件附件
            helper.addAttachment(fileName, file);
        }
        javaMailSender.send(message);
    }

    public String readerHtml(String path) {
        try (
                InputStream in = new FileInputStream(path);
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            int len;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.flush();
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
