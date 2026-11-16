package vn.iotstar.webcourse.controller.web;

import vn.iotstar.webcourse.util.SecurityUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.webcourse.service.UserService;
import vn.iotstar.webcourse.service.impl.UserServiceImpl;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = SecurityUtil.hashPassword(req.getParameter("password"));
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");
        // OTP
        String otp = String.format("%06d", new java.util.Random().nextInt(999999));


        jakarta.servlet.http.HttpSession session = req.getSession();
        session.setAttribute("pendingUser", user); // The User entity you populated from the form
        session.setAttribute("generatedOtp", otp);

        // email
        boolean emailSent = EmailUtil.sendOtpEmail(user.getEmail(), otp);

        if (emailSent) {
            // Redirect to the OTP verification page
            resp.sendRedirect(req.getContextPath() + "/verify-otp");
        } else {
            req.setAttribute("alert", "Lỗi gửi email. Vui lòng kiểm tra lại cấu hình SMTP.");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }

        UserService service = new UserServiceImpl();

        if (service.checkExistEmail(email)) {
            req.setAttribute("alert", "Email đã tồn tại!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        if (service.checkExistUsername(username)) {
            req.setAttribute("alert", "Tài khoản đã tồn tại!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        boolean isSuccess = service.register(username, password, email, fullname, phone);
        if (isSuccess) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            req.setAttribute("alert", "System error!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}