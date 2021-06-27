package com.poverty.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Properties;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/26 23:25
 */
@Component
@ConfigurationProperties(prefix="email")
@Data
public class MailUtil {
    /**
     * 传输协议
     */
    private String transportProtocol;
    /**
     * 传输协议服务器地址
     */
    private String smtpHost;
    /**
     * 是否请求认证
     */
    private String smtpAuth;
    /**
     * 传输协议使用端口号
     */
    private String smtpPort;
    /**
     * java ssl连接类
     */
    private String smtpSocketFactoryClass;
    private String smtpSocketFactoryFallback;
    /**
     * ssl连接端口
     */
    private String smtpSocketFactoryPort;
    /**
     * 发件邮箱地址
     */
    private String fromAddress;
    /**
     * 发件邮箱密码
     */
    private String password;
    /**
     * 发件邮箱昵称
     */
    private String username;

    public Properties properties() {
        Properties properties = new Properties();
        // 设置传输协议
        properties.setProperty("mail.transport.protocol", transportProtocol);
        // 设置传输协议使用的服务器地址
        properties.setProperty("mail.smtp.host", smtpHost);
        // 是否请求认证
        properties.setProperty("mail.smtp.auth", smtpAuth);
        // 协议使用端口号
        properties.setProperty("mail.smtp.port", smtpPort);
        // 开启ssl连接
        properties.setProperty("mail.smtp.socketFactory.class", smtpSocketFactoryClass);
        properties.setProperty("mail.smtp.socketFactory.fallback", smtpSocketFactoryFallback);
        properties.setProperty("mail.smtp.socketFactory.port", smtpSocketFactoryPort);
        return properties;
    }

    public void sendMail(String message, String toAddress) throws MessagingException, UnsupportedEncodingException {
        // 获取连接对象
        Session session = Session.getDefaultInstance(properties());
        // 控制台输出
        session.setDebug(true);

        // 创建消息对象
        MimeMessage mimeMessage = new MimeMessage(session);
        // 设置邮件发送者
        mimeMessage.setFrom(new InternetAddress(fromAddress, username, "UTF-8"));
        // 设置邮件主题
        mimeMessage.setSubject("扶贫注册验证码", "UTF-8");
        // 设置发件时间
        mimeMessage.setSentDate(new Date());
        // 设置邮件接收者
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO,
                new InternetAddress(toAddress, toAddress, "UTF-8"));

        // 封装正文，message可以用html语句
        mimeMessage.setContent(message, "text/html;charset=UTF-8");
        // 保存设置
        mimeMessage.saveChanges();

        // 获取传输对象
        Transport transport = session.getTransport();
        // 获取连接
        transport.connect(fromAddress, password);
        // 发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        // 关闭连接
        transport.close();
    }

    public String readerHtml(String path) throws IOException {
        InputStream in = new FileInputStream(path);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len;
        byte[] bytes = new byte[1024 * 1024];
        while ((len = in.read(bytes)) > 0) {
            out.write(bytes, 0, len);
        }
        out.flush();
        String s = out.toString(StandardCharsets.UTF_8);

        in.close();
        out.close();
        return s;
    }
}
