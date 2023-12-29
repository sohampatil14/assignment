package servlet_handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.time.LocalDateTime;

import database_handlers.ConnectionSQLServer;
import database_handlers.Person;
import database_handlers.SelectTable;

@WebServlet("/register")
public class RegistrationHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public RegistrationHandler() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Person person = null;
		Connection connection = ConnectionSQLServer.getServerConnection();
		
		if(SelectTable.checkUsernameExists(connection, request.getParameter("username"))) {
			response.sendRedirect("register.jsp?register=false&username=exists");
			return;
		}
		
		try {
			person = new Person(
					request.getParameter("prefix"), request.getParameter("first_name"), request.getParameter("middle_name"),
					request.getParameter("last_name"), request.getParameter("username"), request.getParameter("email"), 
					request.getParameter("password"), request.getParameter("birthdate"), Byte.parseByte(request.getParameter("age")), 
					request.getParameter("gender")
					);
		} catch (NumberFormatException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		database_handlers.InsertIntoTable.insertIntoPersons(connection, person);
		// database_handlers.SelectTable.selectQuery(connection);
		
		if(request.getParameter("cookies").equals("on")) {
			Cookie username = new Cookie("username", request.getParameter("username"));
			Cookie creation_time = new Cookie("creation_time", LocalDateTime.now().toString());
			response.addCookie(username);
			response.addCookie(creation_time);
		}
		
		response.sendRedirect("login.jsp?register=true");
	}

}
