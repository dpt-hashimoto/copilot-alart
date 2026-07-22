package com.example.demo.selenium;

import lombok.Data;

/**
 * GitHub Copilot利用状況の取得結果のDTO
 */
@Data
public class CopilotUsageDto {

    /** Inline suggestions（コード補完機能の使用量） */
    private final String inline;
    /** Included credits（チャットなどの使用量） */
    private final String credit;
}
