package taxi.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    private static final Set<String> ALLOWED_URLS = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) {
        ALLOWED_URLS.add("/login");
        ALLOWED_URLS.add("/drivers/add");
        ALLOWED_URLS.add("/css/styles.css");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Long driverId = (Long) session.getAttribute("driver_id");
        req.setAttribute("isLoggedIn", driverId != null);
        if (driverId == null && !ALLOWED_URLS.contains(req.getServletPath())) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        if (driverId != null && req.getServletPath().equals(req.getContextPath() + "/login")
                || req.getServletPath().equals(req.getContextPath() + "/")) {
            resp.sendRedirect(req.getContextPath() + "/index");
            return;
        }
        chain.doFilter(req, resp);
    }
}
