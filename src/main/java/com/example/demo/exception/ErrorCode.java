package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * エラーコード
 */
public enum ErrorCode {

    // =========================
    // システムエラー
    // =========================
    SE001("SE001", "データベースへの接続に失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE002("SE002", "SQLの実行中にエラーが発生しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE003("SE003", "Tomcatの起動に失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE004("SE004", "システムエラーが発生しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE005("SE005", "WEBスクレイピング中のエラー", HttpStatus.INTERNAL_SERVER_ERROR),
    SE006("SE006", "メールサーバーとの通信に失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),

    // =========================
    // 業務エラー
    // =========================
    BE001("BE001", "対象データが存在しません。", HttpStatus.NOT_FOUND),
    BE002("BE002", "GitHubIDは既に登録されています。", HttpStatus.CONFLICT),
    BE003("BE003", "GitHubへのログインに失敗しました。", HttpStatus.UNAUTHORIZED),

    // =========================
    // 入力エラー
    // =========================
    IE001("IE001", "指定されたURLは存在しません。", HttpStatus.NOT_FOUND),
    IE002("IE002", "入力内容に誤りがあります。", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
