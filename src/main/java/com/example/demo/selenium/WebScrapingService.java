package com.example.demo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * WEBスクレイピングサービス
 */
@Service
@RequiredArgsConstructor
public class WebScrapingService {

    /** GitHubのURL */
    private static String GITHUB_URL = "https://github.com/login";
    /** ログインサービス */
    private final GithubLoginService login;
    /** GitHubCopilotの設定 */
    private final GithubCopilotService copilotPage;

    /**
     * Github Copilotの使用状況を取得する
     * @param id 
     */
    public CopilotUsageDto execute(Integer id) {
       /** Google Chrome用ドライバ */
        WebDriver driver = createDriver();
        try {
            openGitHub(driver);
            login.loginGitHub(driver, id);
            return readUsage(driver);
        } finally {
            driver.quit();
        }
    }

    /**
     * Google Chromeウィンドウを立ち上げる
     * @return WEBドライバ
     */
    private WebDriver createDriver() {
        // 厳密にはブラウザが立ち上がって、そのセッションをこのインスタンスが保持している。
        return new ChromeDriver();
    }

    /**
     * GitHubのURLを開く
     * @param driver GitHubを開いた状態のWEBドライバ
     */
    private void openGitHub(WebDriver driver) {
        driver.get(GITHUB_URL);
    }

    /**
     * 画面からCopilot使用状況を取得しDTOを返す
     * @param driver ログイン済みのWEBドライバ
     * @return 取得結果DTO
     */
    private CopilotUsageDto readUsage(WebDriver driver) {
        copilotPage.moveCopilotSetting(driver);
        return new CopilotUsageDto(
            copilotPage.readInlineSuggestions(driver), // Inline取得
            copilotPage.readIncludedCredits(driver)); // Credit取得
    }
}
