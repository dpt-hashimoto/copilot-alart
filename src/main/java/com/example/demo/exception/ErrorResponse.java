package com.example.demo.exception;

/**
 * エラーレスポンスDTO
 */
public record ErrorResponse(
    String code,
    String message) {
}
// メモ recordはjava16から追加された構文でlombokの@Dataのような状態
