@echo off

REM 製品ディレクトリへ移動
cd /d "%~dp0.."

powershell -NoProfile -Command ^
"$p = Start-Process 'runtime\bin\javaw.exe' -ArgumentList '-jar copilot-alart-1.0.0.jar' -PassThru; $p.Id > 'bin\pid.txt'"


pause