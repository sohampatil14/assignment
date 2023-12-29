package servlet_handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.time.LocalDateTime;

import database_handlers.ConnectionSQLServer;
import database_handlers.Person;

@WebServlet("/login")
public class LoginHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public LoginHandler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			password = Person.hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		Connection connection = ConnectionSQLServer.getServerConnection();
		int check = database_handlers.LoginRecordCheck.checkRecords(connection, username, password);
		
		if(check == 0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
            session.setAttribute("creation_time", LocalDateTime.now());
            session.setAttribute("visit_count", 0);
            session.setAttribute("is_loggedin", true);
            response.sendRedirect("index.jsp?login=true");
		}
		else if (check == -1) {
			response.sendRedirect("login.jsp?record=false");
		}
		else {
			response.sendRedirect("index.jsp?sqlexception=true");
		}
		
	}
}
