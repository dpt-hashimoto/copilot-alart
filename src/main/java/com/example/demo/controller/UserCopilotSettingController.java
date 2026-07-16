package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserCopilotSetting;
import com.example.demo.service.UserCopilotSettingService;

import lombok.RequiredArgsConstructor;

/**
 * UserCopilotSettingのコントローラクラス
 */
@Controller
@RequiredArgsConstructor
public class UserCopilotSettingController {

    private final UserCopilotSettingService service;

    /**
     * 設定一覧表示
     */
    @GetMapping("/setting")
    public String showSettings(Model model) {
        List<UserCopilotSetting> settings = service.findAll();
        
        // "setting" という名前でHTMLにデータを渡す
        model.addAttribute("settings", settings);
        return "setting";
    }

    /**
     * 詳細画面表示
     */
    @GetMapping("/setting/{id}")
    public String showConfirm(@PathVariable Integer id, Model model) {
        UserCopilotSetting setting = service.getSettingById(id);
        
        // "setting" という名前でHTMLにデータを渡す
        model.addAttribute("setting", setting);
        return "confirm";
    }

    /**
     * 新規追加画面表示
     */
    @GetMapping("/regist")
    public String showRegist(Model model) {
        // 新規追加の場合は空のエンティティデータをHTMLに渡す
        UserCopilotSetting setting = new UserCopilotSetting();
        model.addAttribute("setting", setting);
        return "form";
    }

    /**
     * 編集画面表示
     */
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        UserCopilotSetting setting = service.getSettingById(id);
        model.addAttribute("setting", setting);
        return "form";
    }

    /**
     * 入力内容保存
     */
    @PostMapping("/save")
    public String save(@ModelAttribute UserCopilotSetting setting) {
        // IDがなければ新規、IDがあれば更新
        if (null == setting.getId()) {
            service.regist(setting);
        } else {
            service.update(setting);
        }
        return "redirect:setting";
    }

    /**
     * 削除
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/setting";
    }
}