import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/*" })
public class Logging extends HttpFilter implements Filter {

	private static final long serialVersionUID = 299266054057222193L;

	public Logging() {
        super();
    }

	public void destroy() {
		System.out.println("[DESTROY] Logged at : " + new java.sql.Timestamp(System.currentTimeMillis()));
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, Filter chain) throws IOException, ServletException {

		System.out.println("[FILTER] Logged at : " + System.currentTimeMillis());
		// pass the request along the filter chain
		chain.doFilter(request, response, null);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("[INIT] Logged at : " + System.currentTimeMillis());
	}
}
