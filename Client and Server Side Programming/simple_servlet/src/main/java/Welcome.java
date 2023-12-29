import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Welcome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			response.setContentType("text/html");
			PrintWriter pWriter = response.getWriter();
			
			//Reading cookies
			Cookie[] cookies = request.getCookies();
			
			//Displaying User name value from cookie
			pWriter.println("<br/>User Name: <strong>" + cookies[0].getValue() + "</strong>");
			pWriter.println("<br/>Password: <strong>" + cookies[1].getValue() + "</strong>");
			pWriter.close();
		}
		catch(Exception exp) {
			System.out.println(exp);
		}
	}
}
