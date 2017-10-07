call runcrud.bat
if "%ERRORLEVEL%" == "0" goto showtasks
echo RUNCRUD.BAT has errors - breaking work
goto fail

:showtasks
start chrome.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open browser
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.