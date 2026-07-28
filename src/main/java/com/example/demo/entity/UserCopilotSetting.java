package com.example.demo.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * user_copilot_settingテーブルのエンティティクラス
 */
@Data
public class UserCopilotSetting {

    /** 連番ID（主キー） */
    private Integer id;
    /** ユーザー名 */
    @NotBlank(message = "ユーザ名を入力してください")
    private String userName;
    /** GitHubログインID（重複不可） */
    @NotBlank(message = "GitHubログインIDを入力してください")
    private String gitLoginId;
    /** GitHubログインパスワード（暗号化文字を想定） */
    @NotBlank(message = "GitHubログインパスワードを入力してください")
    private String gitLoginPassword;
    /** メールアドレス */
    @Email(message = "メールアドレスの形式が正しくありません。")
    @NotBlank(message = "メールアドレスを入力してください")
    private String mailAddress;
    /** 備考 */
    @Size(max=200)
    private String remarks;
}
