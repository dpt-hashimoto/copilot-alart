@echo off
setlocal EnableDelayedExpansion

REM 製品ディレクトリに移動
cd /d "%~dp0.."

REM Javaを起動してPIDを取得
for /f %%i in ('
powershell -NoProfile -Command "$p = Start-Process 'runtime\bin\javaw.exe' -ArgumentList '-jar','copilot-alart-1.0.0.jar' -PassThru; $p.Id"') do (
    set TARGET_PID=%%i
)

REM PID取得確認
if not defined TARGET_PID (
    echo エラー: Javaプロセスを起動できませんでした。
    pause
    exit /b 1
)

echo %TARGET_PID%>bin\pid.txt

echo 起動中... (PID=%TARGET_PID%)

set COUNT=0
set MAX_WAIT=30

:LOOP

REM プロセスが存在するか確認
tasklist /FI "PID eq %TARGET_PID%" | findstr /C:"%TARGET_PID%" >nul
if errorlevel 1 (
    echo.
    echo エラー: アプリケーションが起動途中で終了しました。
    del pid.txt >nul 2>&1
    pause
    exit /b 1
)

REM HTTP応答確認
powershell -NoProfile -Command ^
"try { Invoke-WebRequest 'http://localhost:28080' -UseBasicParsing > $null; exit 0 } catch { exit 1 }"

if not errorlevel 1 (
    echo.
    echo アプリケーションが正常に起動しました。
    pause
    exit /b 0
)

set /a COUNT+=1

if !COUNT! GEQ !MAX_WAIT! (
    echo.
    echo エラー: !MAX_WAIT!秒以内に起動しませんでした。
    echo プロセス^(PID=%TARGET_PID%^)は実行中ですが、HTTP応答がありません。
    pause
    exit /b 1
)

timeout /t 1 >nul
goto LOOP