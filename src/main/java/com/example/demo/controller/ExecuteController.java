package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.exception.BusinessException;
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
    public String execute(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try { executer.manualExecute(id);
            return "redirect:/setting";
        } catch (BusinessException e) {
            redirectAttributes.addFlashAttribute(
                "error",
                e.getErrorCode().getMessage());
            return "redirect:/setting/" + id;
        }
    }

}