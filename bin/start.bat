@echo off

REM 製品ディレクトリへ移動
cd /d "%~dp0.."

runtime\bin\java.exe -jar copilot-alart-1.0.0.jar

pause