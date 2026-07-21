package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * エラーが起きた場合の画面制御
 */
@ControllerAdvice
public class ErrorController {

    /**
     * 無効なURLが指定された場合は設定一覧画面にリダイレクト
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public String handle404() {
        return "redirect:/setting";
    }

}
