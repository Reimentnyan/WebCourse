package vn.iotstar.webcourse.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.webcourse.model.User;
import vn.iotstar.webcourse.service.UserService;
import vn.iotstar.webcourse.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/verify-otp")
public class VerifyOtpController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("pendingUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/register");
            return;
        }
        req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/register");
            return;
        }

        String inputOtp = req.getParameter("otp");
        String generatedOtp = (String) session.getAttribute("generatedOtp");
        User pendingUser = (User) session.getAttribute("pendingUser");

        if (generatedOtp != null && pendingUser != null && generatedOtp.equals(inputOtp)) {
            userService.register(pendingUser.getUserName(),
            pendingUser.getPassWord(), pendingUser.getEmail(),
            pendingUser.getFullName(), pendingUser.getPhone());

            session.removeAttribute("generatedOtp");
            session.removeAttribute("pendingUser");
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            req.setAttribute("alert", "Mã OTP không chính xác!");
            req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);
        }
    }
}