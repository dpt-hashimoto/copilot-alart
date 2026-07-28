package com.example.demo.exception;

/**
 * 内部のエラー
 */
public class SystemException extends RuntimeException {
    /** エラーコード */
    private final ErrorCode errorCode;

    /**
     * コンストラクタ
     * とりあえず元のエラーも入れておく
     * @param errorCode
     * @param e
     */
    public SystemException(ErrorCode errorCode, Throwable e) {
        super(errorCode.getMessage(), e);
        this.errorCode = errorCode;
    }

    public SystemException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    /**
     * エラーコードを取得する
     * @return エラーコード
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
