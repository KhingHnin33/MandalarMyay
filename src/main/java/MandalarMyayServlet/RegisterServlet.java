package MandalarMyayServlet;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username == null || username.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            response.sendRedirect("SignInOut.html?error=All fields are required!");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mandalarmyay", "root", "cefma21.K");

            // Check for existing user
            PreparedStatement checkStmt = con.prepareStatement(
                "SELECT email FROM registeruser WHERE email = ? OR username = ?");
            checkStmt.setString(1, email);
            checkStmt.setString(2, username);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next()) {
                con.close();
                response.sendRedirect("emailexists.jsp"); // Use consistent name
                return;
            }

            String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

            PreparedStatement insertStmt = con.prepareStatement(
                "INSERT INTO registeruser (username, email, password_hash) VALUES (?, ?, ?)");
            insertStmt.setString(1, username);
            insertStmt.setString(2, email);
            insertStmt.setString(3, hashedPassword);
            
            int rows = insertStmt.executeUpdate();
            con.close();

            if (rows > 0) {
                // SET ALL REQUIRED SESSION ATTRIBUTES
                HttpSession session = request.getSession();
                session.setAttribute("user", "loggedIn");
                session.setAttribute("name", username);
                session.setAttribute("email", email);
                
                response.sendRedirect("Home.html");
            } else {
                response.sendRedirect("SignInOut.html?error=Registration failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("SignInOut.html?error=Database error!");
        }
    }
}