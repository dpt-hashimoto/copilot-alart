package com.example.demo.entity;

import lombok.Data;

/**
 * user_copilot_settingテーブルのエンティティクラス
 */
@Data
public class UserCopilotSetting {

    /** 連番ID（主キー） */
    private Integer id;
    /** ユーザー名 */
    private String userName;
    /** GitHubログインID（重複不可） */
    private String gitLoginId;
    /** GitHubログインパスワード（暗号化文字を想定） */
    private String gitLoginPassword;
    /** TeamsのワークフローURL */
    private String teamsWorkflowUrl;
    /** 備考 */
    private String remarks;
}
