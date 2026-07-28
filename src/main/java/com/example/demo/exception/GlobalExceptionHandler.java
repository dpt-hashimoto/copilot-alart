package com.example.demo.exception;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * エラーハンドリングのロジッククラス
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * システムエラーハンドリング
     * @param ex
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public String handle(SystemException ex, Model model) {

        model.addAttribute("message", ex.getErrorCode().getMessage());

        return "error";
    }

    /**
     * DBエラーハンドリング
     * @param ex
     * @return
     */
    @ExceptionHandler(MyBatisSystemException.class)
    public String handle(MyBatisSystemException ex, Model model) {

        model.addAttribute("message", ErrorCode.SE001.getMessage());

        return "error";
    }

    /**
     * DBエラーハンドリング
     * @param ex
     * @return
     */
    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public String handle(CannotGetJdbcConnectionException ex, Model model) {

        model.addAttribute("message", ErrorCode.SE001.getMessage());

        return "error";
    }
}
