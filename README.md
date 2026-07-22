# 注意
* 本ツールはGitHubのWEBサイトからWEBスクレイピングを用いて情報を取得しています。
* 2026年07月22日現在のGitHubの規約では明確に禁止されているような記載がなかったため、学習用として作成しました。
* 使用する際にはGitHubの規約を確認してから使用してください。
* また、GitHubサーバに過度に負荷がかかるような使用は控えてください。

# GitHub Copilot使用量のアラートツール

<details>
<summary>開発のきっかけ</summary>

### 目的
  * 自社の研修の一環
  * SpringBootでの開発経験を積む
  * 使用したことのないライブラリで経験を積む

→次回の派遣就業の際のポートフォリオにするため

### 経緯
  * あったら嬉しい機能
  * 生成AIに関する機能
  * 外部サイトやツールと連携させたい
</details>
---

## 概要

GitHub Copilotの使用量を取得し、メール通知を行うツールです。

Spring Bootで作成しており、

- Web画面からの実行
- コマンドラインからの実行

の両方に対応しています。

---

## 制約
* GitHubで2FA認証を設定している場合は対応しておりません。
* GitHubの画面に変更があった場合に動作しなくなる可能性があります。

## 主な機能

- GitHub Copilot APIから使用量取得
- 使用率の表示
- HTMLメール送信
- コマンドライン実行
- Web画面からの実行

---

## 使用技術

- Java 17
- Spring Boot
- Maven
- Thymeleaf
- JavaMail
- Docker
- MailHog

---

## 動作環境

- JDK 21

---

## 使い方

### Web版

```
http://localhost:8080
```

### CLI版
WIP

## ディレクトリ構成

```
src
 ├─controller
 ├─service
 ├─repository
 ├─config
 ├─mail
 └─templates
```

---

## 今後追加予定

- グラフ表示

---

## ライセンス

MIT License
