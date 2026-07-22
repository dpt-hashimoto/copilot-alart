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
import com.example.demo.selenium.CopilotUsageDto;

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
    public void sendMail(Integer id, CopilotUsageDto dto) {
        UserCopilotSetting setting = getEntity(id);
        SimpleMailMessage message = makeMessage(setting, dto);
        mailSender.send(message);
    }

    /**
     * 設定のエンティティを取得
     * @param id
     * @return メールアドレス
     */
    private UserCopilotSetting getEntity(Integer id) {
        return mapper.findById(id);
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
     * メール本体を作る
     * @param setting 設定エンティティ
     * @return メール
     */
    private SimpleMailMessage makeMessage(UserCopilotSetting setting, CopilotUsageDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(getAddress(setting));
        message.setSubject("GitHub Copilot 利用状況");
        message.setText(makeContent(setting, dto));
        return message;
    }

    /**
     * メール本文をテンプレートから可変にする。
     * @return メール本文
     */
    private String makeContent(UserCopilotSetting setting, CopilotUsageDto dto) {
        
        Context context = new Context();
        context.setVariable("userName", setting.getUserName());
        context.setVariable("dateTime", LocalDateTime.now().
            format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
        context.setVariable("inline", dto.getInline());
        context.setVariable("credit", dto.getCredit());

        return templateEngine.process("mail/template.txt", context);
    }
}
