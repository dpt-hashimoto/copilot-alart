package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.ExecuteService;

import lombok.RequiredArgsConstructor;

/**
 * 実行処理のコントローラクラス
 */
@Controller
@RequiredArgsConstructor
public class ExecuteController {

    private final ExecuteService executer;
    /**
     * 手動実行
     */
    @GetMapping("/execute/{id}")
    public String execute(@PathVariable Integer id) {
        executer.manualExecute(id);
        return "redirect:/setting";
    }

}