@echo off

powershell -NoProfile -Command ^
"$targetPid = Get-Content 'pid.txt'; Stop-Process -Id $targetPid -Force; Remove-Item 'pid.txt'"

pause