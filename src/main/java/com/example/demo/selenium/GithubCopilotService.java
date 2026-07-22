package com.example.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

/**
 * GitHubログイン後のページの操作をつかさどる
 */
@Service
public class GithubCopilotService {

    /**
     * Copilot Settingページを開く（画面操作）
     * @param driver
     */
    public void moveCopilotSetting(WebDriver driver) {
        driver.findElement(
            By.cssSelector("img[data-testid='github-avatar']")).click();
        driver.findElement(
            By.cssSelector("a[href='/settings/copilot']")).click();
    }

    /**
     * Copilot SettingページからInlineSuggestionsの値を取得する。（画面操作）
     * @param driver
     * @return コード補完使用率 「xx%」
     */
    public String readInlineSuggestions(WebDriver driver) {
        WebElement li = driver.findElement(
            By.xpath("//li[.//span[text()='Inline suggestions']]")
        );

        String inlineSuggestions = li.findElement(
            By.xpath(".//span[contains(text(),'% used')]")
        ).getText();

        inlineSuggestions = inlineSuggestions.replace(" used", "");

        System.out.println(inlineSuggestions);
        return inlineSuggestions;
    }

    /**
     * Copilot SettingページからInlineSuggestionsの値を取得する。（画面操作）
     * @param driver
     * @return クレジット使用率 「xx%」
     */
    public String readIncludedCredits(WebDriver driver) {
        WebElement li = driver.findElement(
            By.xpath("//li[.//span[text()='Included credits']]")
        );

        String includedCredits = li.findElement(
            By.xpath(".//span[contains(text(),'% used')]")
        ).getText();

        includedCredits = includedCredits.replace(" used", "");

        System.out.println(includedCredits);
        return includedCredits;
    }
}
