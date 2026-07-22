package com.example.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserCopilotSetting;
import com.example.demo.mapper.UserCopilotSettingMapper;

import lombok.RequiredArgsConstructor;

/**
 * GitHubのログイン処理を行うサービス
 */
@Service
@RequiredArgsConstructor
public class GithubLoginService {

    /** Mapperインターフェース */
    private final UserCopilotSettingMapper mapper;

    /**
     * 設定されたログインIDとパスワードでGitHubにログインする（画面操作）
     * @param driver GitHubサイトのセッション
     * @param id UserCopilotSettingテーブルのID
     */
    public void loginGitHub(WebDriver driver, Integer id) {
        UserCopilotSetting setting = mapper.findById(id);
        // ID・パスワードの要素取得
        driver.findElement(By.id("login_field")).sendKeys(setting.getGitLoginId());;
        driver.findElement(By.id("password")).sendKeys(setting.getGitLoginPassword());
        driver.findElement(By.name("commit")).click();;
    }
}
