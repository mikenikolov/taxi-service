package taxi.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxi.exception.RegistrationException;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.RegistrationService;

@WebServlet(urlPatterns = "/drivers/register")
public class RegisterDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final RegistrationService registrationService = (RegistrationService) injector
            .getInstance(RegistrationService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/register.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String licenseNumber = req.getParameter("license_number");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Driver driver = new Driver(name, licenseNumber, login, password);
            registrationService.register(driver);
            resp.sendRedirect(req.getContextPath() + "/drivers");
        } catch (RegistrationException e) {
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/drivers/register.jsp").forward(req, resp);
        }
    }
}
