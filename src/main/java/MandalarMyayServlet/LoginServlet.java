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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        if (email == null || email.trim().isEmpty() ||
	            password == null || password.trim().isEmpty()) {
	            response.sendRedirect("SignInOut.html?error=Email and password required!");
	            return;
	        }

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/mandalarmyay", "root", "cefma21.K");

	            // Fetch both username AND password_hash
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT username, password_hash FROM registeruser WHERE email = ?");
	            stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                String storedUsername = rs.getString("username"); // Get username from DB
	                String storedHash = rs.getString("password_hash");
	                
	                // Verify password with BCrypt
	                boolean isValid = BCrypt.verifyer().verify(password.toCharArray(), storedHash).verified;
	                
	                if (isValid) {
	                    con.close();
	                    
	                    // Create session and set attributes
	                    HttpSession session = request.getSession(); // ← FIXED: create session
	                    session.setAttribute("user", "loggedIn");      // or use storedUsername
	                    session.setAttribute("name", storedUsername);  // ← Use actual username from DB
	                    session.setAttribute("email", email);
	                    
	                    response.sendRedirect("Home.html");
	                } else {
	                    con.close();
	                    response.sendRedirect("SignInOut.html?error=Incorrect password!");
	                }
	            } else {
	                con.close();
	                response.sendRedirect("mustregister.jsp"); // ← Better than must-signin.jsp
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("SignInOut.html?error=Login error!");
	        }
	    }
	}