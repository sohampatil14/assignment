

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			response.setContentType("text/html");
			PrintWriter pWriter = response.getWriter();
			
			String userName = request.getParameter("userName");
			String password = request.getParameter("userPassword");
			
			pWriter.print("<br/>Hello: <strong>" + userName + "</strong>");
			pWriter.print("<br/>Your Password is: <strong>" + password + "</strong>");
			pWriter.println();
			
			//Creating two cookies
			Cookie cookie1 = new Cookie("userName", userName);
			Cookie cookie2 = new Cookie("userPassword", password);
			
			//Adding the cookies to response header
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			pWriter.println("<br/> <br/> <a href='welcome'>View Cookies</a>");
			pWriter.close();
		}
		
		catch(Exception exp) {
			System.out.println(exp);
		}
	}
}
