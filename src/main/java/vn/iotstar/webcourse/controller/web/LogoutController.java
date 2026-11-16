package vn.iotstar.webcourse.controller.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Invalidate the active session
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Destroy the "Remember Me" cookie by setting its age to 0
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        // Redirect back to the login page
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}