package MandalarMyayServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect("must-register.jsp");
                return;
            }

            String sessionName = (String) session.getAttribute("name");
            String sessionEmail = (String) session.getAttribute("email");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String ph = request.getParameter("ph");
            String mess = request.getParameter("message");

            // Validate inputs
            if (name == null || name.trim().isEmpty() || 
                email == null || email.trim().isEmpty()) {
                response.sendRedirect("ContactUs.html?error=Missing+fields");
                return;
            }

            // Validate session match
            if (sessionEmail == null || !sessionEmail.equals(email)) {
                if (isEmailRegistered(email)) {
                    response.sendRedirect("email-exists.jsp");
                } else {
                    response.sendRedirect("must-signin.jsp");
                }
                return;
            }

            if (!sessionName.equalsIgnoreCase(name)) {
                response.sendRedirect("must-register.jsp");
                return;
            }

            // Insert into DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mandalarmyay", "root", "cefma21.K")) {

                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO contact_message (name, email, ph, message) VALUES (?, ?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, ph);
                ps.setString(4, mess);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("    <title>Message Sent</title>");
	            out.println("    <link rel='shortcut icon' href='./img/ancient-gate-line.png' type='image/x-icon'>");
	            out.println("    <link href='https://cdn.jsdelivr.net/npm/remixicon@4.8.0/fonts/remixicon.css' rel='stylesheet'>");
	            out.println("    <style>");
	            out.println("        * { margin: 0; padding: 0; box-sizing: border-box; }");
	            out.println("        body { font-family: 'Segoe UI', Arial, sans-serif; background: #f6f6f6; min-height: 100vh; display: flex; flex-direction: column; padding: 0; }");
	            out.println("        .welcome-header { display: flex; justify-content: space-between; align-items: center; padding: 16px 24px; margin-top: 2%; margin-left: 50px; margin-right: 50px; }");
	            out.println("        .welcome-logo .nav_logo { display: flex; align-items: center; gap: 10px; text-decoration: none; color: #1a1a1a; font-weight: 700; font-size: 20px; }");
	            out.println("        .logo-i { color: #161616; font-size: 24px; }");
	            out.println("        .logo-p { margin: 0; color: #161616; }");
	            out.println("        .skip-btn { color: #161616; text-decoration: none; font-weight: 600; font-size: 16px; display: flex; align-items: center; gap: 6px; padding: 6px 12px; border-radius: 6px; transition: background 0.2s ease; }");
	            out.println("        .skip-btn:hover { background: rgba(0, 0, 0, 0.05); }");
	            out.println("        .main-content { flex: 1; display: flex; justify-content: center; align-items: center; padding: 24px; margin-bottom: 5%; }");
	            out.println("        .container { background: white; padding: 40px 32px 20px; border-radius: 16px; box-shadow: 0 0 30px rgba(0, 0, 0, 0.5); text-align: center; max-width: 520px; width: 90%; }");
	            out.println("        .graphic-img { width: 180px; margin-bottom: 24px; }");
	            out.println("        h2 { font-size: 24px; font-weight: 700; color: #202020; margin-bottom: 16px; }");
	            out.println("        p { font-size: 16px; line-height: 1.6; color: #606060; margin: 8px 0; }");
	            out.println("        strong { color: #121212; }");
	            out.println("        .btn { display: inline-block; padding: 10px 20px; border-radius: 6px; font-weight: 600; text-decoration: none; margin-top: 10px; }");
	            out.println("        .btn-primary { background: #0b0b0b; color: white; }");
	            out.println("        .btn-secondary { background: #f6f6f6; color: #121212; border: 1px solid #ddd; }");
	            out.println("        .logo1 i { font-size: 20px; }");
	            out.println("        .gap10 { gap: 5px; display: flex; align-items: center; justify-content: space-evenly; }");
	            out.println("    </style>");
	            out.println("</head>");
	            out.println("<body>");

	            out.println("    <header class='welcome-header'>");
	            out.println("        <div class='welcome-logo'>");
	            out.println("            <a href='Home.html' class='nav_logo'>");
	            out.println("                <i class='ri-ancient-gate-line logo-i'></i>");
	            out.println("                <p class='logo-p'>မန္တလာမြေ</p>");
	            out.println("            </a>");
	            out.println("        </div>");
	            out.println("        <a href='Home.html' class='skip-btn'>");
	            out.println("            Skip <i class='ri-arrow-right-s-line'></i>");
	            out.println("        </a>");
	            out.println("    </header>");

	            out.println("    <div class='main-content'>");
	            out.println("        <div class='container'>");
	            out.println("            <img src='./img/graphic1.png' alt='Success' class='graphic-img'>");
	            out.println("            <h2 style='color: #4b9ffe;'>Thank you for getting in touch!</h2>");
	            out.println("            <p>Hi<strong style='color: #4b9ffe;'> " + name + ",</strong> Our team will be in touch with you shortly.</p>");
	            out.println("            <p>In the meantime, feel free to explore our ");
	            out.println("                <a href='Home.html' style='font-weight: bold; color: #121212; text-decoration: none;'>Home page</a>");
	            out.println("                 or learn more about our services on the ");
	            out.println("                <a href='About.html' style='color: #121212; text-decoration: none; font-weight: bold;'>About</a> page.");
	            out.println("            </p>");
	            out.println("            <div style='margin: 20px 0;' class='logo1 gap10'>");
	            out.println("                <a href='Home.html' class='btn btn-primary'><i class='ri-arrow-right-circle-line'></i> Visit Home Page</a>");
	            out.println("                <a href='ContactUs.html' class='btn btn-secondary'><i class='ri-reset-left-line'></i> Fill Again</a>");
	            out.println("            </div>");
	            out.println("        </div>");
	            out.println("    </div>");

	            out.println("</body>");
	            out.println("</html>");
	        } else {
                out.println("<p style='color:red;text-align:center;'>Failed to send message. <a href='ContactUs.html'>Try again</a></p>");
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
        out.println("<p style='color:red;text-align:center;'>Error: " + e.getMessage() + " <a href='ContactUs.html'>Go back</a></p>");
    } finally {
        out.close();
    }
}


private boolean isEmailRegistered(String email) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mandalarmyay", "root", "cefma21.K");
             PreparedStatement ps = con.prepareStatement("SELECT 1 FROM registeruser WHERE email = ?")) {
            
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}