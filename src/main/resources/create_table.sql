-- テーブルが既に存在する場合は削除（初期化用）
DROP TABLE IF EXISTS user_copilot_setting;

-- GitHubとTeamsの連携設定を管理するテーブルの作成
CREATE TABLE user_copilot_setting (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '連番ID（主キー）',
    user_name VARCHAR(100) NOT NULL COMMENT 'ユーザー名',
    git_login_id VARCHAR(150) NOT NULL UNIQUE COMMENT 'GitHubログインID（重複不可）',
    git_login_password VARCHAR(512) NOT NULL COMMENT 'GitHubログインパスワード（暗号化文字を想定）',
    mail_address TEXT NOT NULL COMMENT 'メールアドレス',
    remarks TEXT COMMENT '備考',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'データ作成日時',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'データ更新日時'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Copilot通知アプリ用設定テーブル';

-- 初期ダミーデータの挿入（3件）
INSERT INTO user_copilot_setting (
    user_name, 
    git_login_id, 
    git_login_password, 
    mail_address, 
    remarks
) VALUES 
(
    '橋本 可成 ', 
    'dpt-hashimoto', 
    'e02022e02022', 
    'hashitmo@test.com', 
    '橋本個人アカウント GitHub疎通確認済み'
),
(
    '山田 太郎', 
    'yamada-github-dev', 
    '$2a$10$vXfR7O8kH...dummyencryptedpassword1...', -- 暗号化文字列を想定したダミー
    'yamada@tarou.com', 
    '開発環境用のテストアカウントです。週次で通知を受け取ります。'
),
(
    '佐藤 美咲', 
    'sato-git-ops', 
    '$2a$10$9zPqK2lM...dummyencryptedpassword2...', 
    'satou@misaki.com', 
    '本番環境のリリース監視用連携設定。'
),
(
    '鈴木 健二', 
    'suzuki-github-admin', 
    '$2a$10$AbCdEf12...dummyencryptedpassword3...', 
    'suzuki@kenji.com', 
    NULL -- 備考が空（NULL）パターンのテスト用
);