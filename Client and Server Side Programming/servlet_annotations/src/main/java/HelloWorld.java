import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hello",
			initParams = {
					@WebInitParam(name="message", value="Hello World!") 
					}
			)

public class HelloWorld extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
    public HelloWorld() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pWriter = response.getWriter();
		
		pWriter.print("<h1>");
		pWriter.print(getInitParameter("message"));
		pWriter.print("</h1>");
	}

}
