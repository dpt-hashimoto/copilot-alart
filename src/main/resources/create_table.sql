-- テーブルが既に存在する場合は削除（初期化用）
DROP TABLE IF EXISTS user_copilot_setting;

-- GitHubとTeamsの連携設定を管理するテーブル
CREATE TABLE user_copilot_setting (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_name TEXT NOT NULL,
    git_login_id TEXT NOT NULL UNIQUE,
    git_login_password TEXT NOT NULL,
    mail_address TEXT NOT NULL,
    remarks TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 初期ダミーデータの挿入
INSERT INTO user_copilot_setting (
    user_name,
    git_login_id,
    git_login_password,
    mail_address,
    remarks
) VALUES
(
    '橋本 可成',
    'dpt-hashimoto',
    'e02022e02022',
    'hashitmo@test.com',
    '橋本個人アカウント GitHub疎通確認済み'
),
(
    '山田 太郎',
    'yamada-github-dev',
    '$2a$10$vXfR7O8kH...dummyencryptedpassword1...',
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
    NULL
);