package vn.iotstar.webcourse.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.webcourse.model.User;
import vn.iotstar.webcourse.service.UserService;
import vn.iotstar.webcourse.service.impl.UserServiceImpl;
import vn.iotstar.webcourse.util.EmailUtil;
import vn.iotstar.webcourse.util.SecurityUtil;
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

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFullname(fullname);
        user.setPhone(phone);

        String otp = EmailUtil.generateOTP();
        HttpSession session = req.getSession();
        session.setAttribute("pendingUser", user);
        session.setAttribute("generatedOtp", otp);

        if (EmailUtil.sendOTP(email, otp)) {
            resp.sendRedirect(req.getContextPath() + "/verify-otp");
        } else {
            req.setAttribute("alert", "Lỗi gửi email!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}