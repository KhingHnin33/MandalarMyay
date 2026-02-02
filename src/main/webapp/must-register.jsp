<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Sign In Required</title>
    <link rel="shortcut icon" href="img/ancient-gate-line.png" type="image/x-icon">
    <!-- Remix Icon -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.8.0/fonts/remixicon.css" rel="stylesheet">
    <style>
        :root {
            --bg: #f6f6f6;
            --card: #fff;
            --text: #000000;
            --text-light: #202020;
            --primary: #121212;
            --primary-hover: #000000;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', system-ui, sans-serif;
            background-color: var(--bg);
            color: var(--text);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            padding: 0;
        }

        .welcome-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 16px 24px;
            z-index: 10;
            margin-top: 2%;
            margin-left: 50px;
            margin-right: 50px;
        }

        .welcome-logo .nav_logo {
            display: flex;
            align-items: center;
            gap: 10px;
            text-decoration: none;
            color: #1a1a1a;
            font-weight: 700;
            font-size: 20px;
        }

        .logo-i {
            color: #161616;
            font-size: 24px;
        }

        .logo-p {
            margin: 0;
            color: #161616;
            font-family: 'Segoe UI', sans-serif;
        }

        /* Skip Button */
        .skip-btn {
            color: #161616;
            text-decoration: none;
            font-weight: 600;
            font-size: 16px;
            display: flex;
            align-items: center;
            gap: 6px;
            padding: 6px 12px;
            border-radius: 6px;
            transition: background 0.2s ease;
        }

        .skip-btn:hover {
            background: rgba(0, 0, 0, 0.05);
        }

        /* Main Content */
        .main-content {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 24px;
            margin-bottom: 5%;
        }

        .container {
            width: 100%;
            max-width: 520px;
            background: var(--card);
            border-radius: 16px;
            padding: 40px 32px 20px 32px;
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.5);
            text-align: center;
            color: var(--text-light);
        }

        .graphic-img {
            width: 180px;
            margin-bottom: 14px;
        }

        h2 {
            font-size: 24px;
            font-weight: 700;
            color: var(--text-light);
        }

        p {
            font-size: 16px;
            line-height: 1.6;
            color: #606060;
            margin-bottom: 32px;
        }

        .btn {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
            width: 100%;
            padding: 12px 0;
            background: var(--primary);
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            margin-bottom: 12px;
            text-decoration: none;
            text-align: center;
        }

        .btn:hover {
            background: var(--primary-hover);
            transform: translateY(-2px);
        }

        .btn i {
            font-size: 20px;
        }

        .padd10 {
            display: block;
            width: 100%;
            padding: 14px;
            color: var(--primary);
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            margin-bottom: 6px;
            text-decoration: none;
            text-align: center;
        }

        .footer-links {
            font-size: 14px;
            color: #aaa;
        }

        .footer-links a {
            color: var(--primary);
            font-weight: 500;
            text-decoration: none;
        }

        .footer-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <header class="welcome-header">
        <div class="welcome-logo">
            <a href="index.html" class="nav_logo">
                <i class="ri-ancient-gate-line logo-i"></i>
                <p class="logo-p">မန္တလာမြေ</p>
            </a>
        </div>
        <a href="Home.html" class="skip-btn">
            Skip <i class="ri-arrow-right-s-line"></i>
        </a>
    </header>

    <!-- Main Content -->
    <div class="main-content">
        <div class="container">
            <img src="./img/graphic3.png" alt="Illustration" class="graphic-img">

            <h2>You Must Be Signed In ꫂ᭪݁</h2>
            <p>To send a message or access member features, please sign in to your account.</p>

            <a href="SignInOut.html" class="btn">
                <i class="ri-login-box-line"></i>
                Sign In to Your Account
            </a>

            <a href="SignInOut.html?form=register" class="padd10">
                Don’t have an account? <u>Create One</u>
            </a>

            <div class="footer-links">
                <p>Or go back to <a href="ContactUs.html">Contact Form</a></p>
            </div>
        </div>
    </div>

</body>
</html>