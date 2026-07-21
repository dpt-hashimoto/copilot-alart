package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.example.demo.entity.UserCopilotSetting;
import com.example.demo.mapper.UserCopilotSettingMapper;

import lombok.RequiredArgsConstructor;

/**
 * メール送信サービス
 */
@Service
@RequiredArgsConstructor
public class MailService {

    /** Mapperインターフェース */
    private final UserCopilotSettingMapper mapper;
    /** SpringMailの送信担当オブジェクト */
    private final JavaMailSender mailSender;
    /** メールフォーマット作成用 */
    private final SpringTemplateEngine templateEngine;

    /**
     * DBからメールアドレスを取得しメールを送信する
     * @param id
     */
    public void sendMail(Integer id) {
        UserCopilotSetting setting = getEntity(id);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(getAddress(setting));
        message.setSubject("テストメール");
        message.setText(makeContent(setting));
        mailSender.send(message);
    }

    /**
     * DBからメールアドレスを取得する
     * @param id
     * @return メールアドレス
     */
    private UserCopilotSetting getEntity(Integer id) {
        UserCopilotSetting ret = mapper.findById(id);
        return ret;
    }

    /**
     * DBからメールアドレスを取得する
     * @param id
     * @return メールアドレス
     */
    private String getAddress(UserCopilotSetting setting) {
        String ret = setting.getMailAddress();
        return ret;
    }

    /**
     * メール本文をテンプレートから可変にする。
     * @return メール本文
     */
    private String makeContent(UserCopilotSetting setting) {
        
        Context context = new Context();
        context.setVariable("userName", setting.getUserName());
        context.setVariable("dateTime", LocalDateTime.now().
            format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
        context.setVariable("inline", "53");
        context.setVariable("credit", "70");

        return templateEngine.process("mail/template.txt", context);
    }
}
