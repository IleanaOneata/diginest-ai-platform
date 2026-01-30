@echo off
REM =============================================================================
REM Development Setup Script for Windows
REM =============================================================================
REM This script helps set up the development environment without admin rights
REM =============================================================================

echo.
echo ============================================
echo  Diginest AI - Development Setup
echo ============================================
echo.

REM Check Node.js
where node >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Node.js not found. Please install Node.js 20+ or use portable version.
    echo.
    echo Download portable Node.js from: https://nodejs.org/en/download/
    echo Extract to a folder and add to PATH in your user environment variables.
    goto :error
) else (
    echo [OK] Node.js found
    node --version
)

REM Check Java
where java >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Java not found. Please install Java 21 or use portable version.
    echo.
    echo Download Eclipse Temurin 21 from: https://adoptium.net/
    echo Choose ZIP archive, extract, and add bin folder to PATH.
    goto :error
) else (
    echo [OK] Java found
    java --version
)

REM Check Git
where git >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Git not found. Please install Git.
    echo.
    echo Download portable Git from: https://git-scm.com/download/win
    goto :error
) else (
    echo [OK] Git found
    git --version
)

echo.
echo ============================================
echo  Setting up Frontend
echo ============================================
echo.

cd frontend
if exist package.json (
    echo Installing frontend dependencies...
    call npm install
    if %ERRORLEVEL% NEQ 0 goto :error
    echo [OK] Frontend dependencies installed
) else (
    echo [ERROR] frontend/package.json not found
    goto :error
)

cd ..

echo.
echo ============================================
echo  Setting up Backend
echo ============================================
echo.

cd backend
if exist pom.xml (
    echo Building backend...
    call mvnw.cmd clean compile -DskipTests
    if %ERRORLEVEL% NEQ 0 (
        echo [WARN] Maven wrapper failed. Trying mvn command...
        call mvn clean compile -DskipTests
    )
    echo [OK] Backend built successfully
) else (
    echo [ERROR] backend/pom.xml not found
    goto :error
)

cd ..

echo.
echo ============================================
echo  Setup Complete!
echo ============================================
echo.
echo To start development:
echo.
echo   Frontend: cd frontend ^&^& npm run dev
echo   Backend:  cd backend ^&^& mvnw spring-boot:run -Dspring-boot.run.profiles=dev
echo.
echo Frontend will be at: http://localhost:4321
echo Backend will be at:  http://localhost:8080
echo.
goto :end

:error
echo.
echo [ERROR] Setup failed. Please fix the issues above and try again.
exit /b 1

:end
echo Setup completed successfully!
exit /b 0
