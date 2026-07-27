package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * エラーコード
 */
public enum ErrorCode {

    // =========================
    // システムエラー
    // =========================
    SE001("SE001", "設定ファイルが存在しません。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE002("SE002", "設定ファイルの読み込みに失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE003("SE003", "データベースへの接続に失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE004("SE004", "SQLの実行中にエラーが発生しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE005("SE005", "Tomcatの起動に失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE006("SE006", "システムエラーが発生しました。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE007("SE007", "GitHubへ接続できませんでした。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE008("SE008", "GitHubの画面構成が変更された可能性があります。", HttpStatus.INTERNAL_SERVER_ERROR),
    SE009("SE009", "メールサーバーとの通信に失敗しました。", HttpStatus.INTERNAL_SERVER_ERROR),

    // =========================
    // 業務エラー
    // =========================
    BE001("BE001", "対象データが存在しません。", HttpStatus.NOT_FOUND),
    BE002("BE002", "GitHubユーザ名は既に登録されています。", HttpStatus.CONFLICT),
    BE003("BE003", "GitHubへのログインに失敗しました。", HttpStatus.UNAUTHORIZED),
    BE004("BE004", "メールサーバーの認証に失敗しました。", HttpStatus.UNAUTHORIZED),

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
