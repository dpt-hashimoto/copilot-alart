package com.example.demo.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * 実行処理を制御する
 */
@Service
@RequiredArgsConstructor
public class ExecuteService {

    /** メール送信サービス */
    private final MailService mailer;

    /**
     * 手動実行する。
     * @param id
     * @return エンティティDTO
     */
    public void manualExecute(Integer id) {
        mailer.sendMail(id);
    }
}
