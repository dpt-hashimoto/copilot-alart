package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.selenium.CopilotUsageDto;
import com.example.demo.selenium.WebScrapingService;

import lombok.RequiredArgsConstructor;

/**
 * 実行処理を制御する
 */
@Service
@RequiredArgsConstructor
public class ExecuteService {

    /** WEBスクレイピングサービス */
    private final WebScrapingService scraper;
    /** メール送信サービス */
    private final MailService mailer;

    /**
     * 手動実行する。
     * @param id
     * @return エンティティDTO
     */
    public void manualExecute(Integer id) {
        CopilotUsageDto dto = scraper.execute(id);
        mailer.sendMail(id, dto);
    }
}
