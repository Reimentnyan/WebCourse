<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <h2>Tạo tài khoản mới</h2>

        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <input type="text" placeholder="Họ tên" name="fullname" class="form-control" required>
                </div>
            </label>
        </section>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <input type="email" placeholder="Nhập Email" name="email" class="form-control" required>
                </div>
            </label>
        </section>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <input type="text" placeholder="Số điện thoại" name="phone" class="form-control" required>
                </div>
            </label>
        </section>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
                </div>
            </label>
        </section>

        <section>
            <label class="input login-input">
                <div class="input-group">
                    <input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
                </div>
            </label>
        </section>

        <button type="submit" class="btn btn-primary">Tạo tài khoản</button>
        <p>Nếu bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
    </form>
</body>
</html>