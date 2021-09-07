package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        String user = (String) request.getSession().getAttribute("username");
        if ((user == null || user.isEmpty()) && !servletPath.contains("login")) {
            response.sendRedirect("login");
        } else if (servletPath.contains("login") && user != null && !user.isEmpty()) {
            response.sendRedirect("home");
        } else {
            chain.doFilter(req, resp);
        }
//        System.out.println("#INFO - ServletPath: " + servletPath + ", URL: " + request.getRequestURL());

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
