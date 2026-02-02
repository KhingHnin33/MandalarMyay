<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Email Already Registered</title>
    <link rel="shortcut icon" href="./img/ancient-gate-line.png" type="image/x-icon">
    <!-- Remix Icon -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.8.0/fonts/remixicon.css" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f6f6f6;
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
        }
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
        .main-content {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 24px;
            margin-bottom: 5%;
        }
        .container {
            background: white;
            padding: 40px 32px 20px;
            border-radius: 16px;
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.5);
            text-align: center;
            max-width: 520px;
            width: 90%;
        }
        .graphic-img {
            width: 180px;
            margin-bottom: 24px;
        }
        h2 {
            font-size: 24px;
            font-weight: 700;
            color: #e74c3c;
            margin-bottom: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }
        p {
            font-size: 16px;
            line-height: 1.6;
            color: #606060;
            margin: 8px 0 24px;
        }
        strong {
            color: #121212;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 6px;
            font-weight: 600;
            text-decoration: none;
            margin: 8px 0;
            transition: all 0.2s;
        }
        .btn-primary {
            background: #121212;
            color: white;
        }
        .btn-primary:hover {
            background: #000;
        }
        .btn-secondary {
            background: #f6f6f6;
            color: #121212;
            border: 1px solid #ddd;
        }
        .btn-secondary:hover {
            background: #eee;
        }
        .btn i {
            margin-right: 6px;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <header class="welcome-header">
        <div class="welcome-logo">
            <a href="Home.html" class="nav_logo">
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
            <img src="./img/graphic1.png" alt="Email Exists" class="graphic-img">
            <h2><i class="ri-mail-check-line"></i> Email Already Registered!</h2>
            <p>This email is already associated with an account.</p>
            <p>If this is your email, please <strong>sign in</strong> instead of registering again.</p>
            
            <a href="SignInOut.html" class="btn btn-primary">
                <i class="ri-login-box-line"></i> Go to Sign In
            </a>
            
            <a href="ContactUs.html" class="btn btn-secondary">
                <i class="ri-mail-send-line"></i> Try a different email
            </a>
        </div>
    </div>

</body>
</html>