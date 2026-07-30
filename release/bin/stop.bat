@echo off
setlocal EnableDelayedExpansion

cd /d "%~dp0"

REM pid.txtが存在するか確認
if not exist pid.txt (
    echo エラー: pid.txt が見つかりません。
    pause
    exit /b 1
)

REM PIDを読み込む
set /p TARGET_PID=<pid.txt

REM プロセス終了
powershell -NoProfile -Command "Stop-Process -Id %TARGET_PID% -Force -ErrorAction Stop"

if errorlevel 1 (
    echo エラー: PID %TARGET_PID% の終了に失敗しました。
    pause
    exit /b 1
)

REM pid.txt削除
del pid.txt >nul 2>&1

echo 終了処理中...

set COUNT=0
set MAX_WAIT=30

:WAIT
tasklist /FI "PID eq %TARGET_PID%" | find "%TARGET_PID%" >nul

if %ERRORLEVEL%==0 (
    set /a COUNT+=1

    if !COUNT! GEQ !MAX_WAIT! (
        echo.
        echo エラー: プロセス PID=%TARGET_PID% が!MAX_WAIT!秒以内に終了しませんでした。
        pause
        exit /b 1
    )

    timeout /t 1 >nul
    goto WAIT
)

echo アプリケーションを終了しました。
pause
exit /b 0