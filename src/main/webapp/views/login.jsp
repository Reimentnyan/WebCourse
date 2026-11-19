<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập</title>
</head>
<body>
<div class="row justify-content-center">
    <div class="col-md-5">
        <form action="${pageContext.request.contextPath}/login" method="post" class="needs-validation card p-4 shadow-sm" novalidate>
            <h2 class="mb-3 text-center">Đăng Nhập Vào Hệ Thống</h2>

            <c:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>

            <div class="mb-3">
                <label class="form-label">Tài khoản</label>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
                <div class="invalid-feedback">Vui lòng nhập tài khoản.</div>
            </div>

            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
                <div class="invalid-feedback">Vui lòng nhập mật khẩu.</div>
            </div>

            <div class="d-flex justify-content-between align-items-center mb-3">
                <div class="form-check">
                    <input type="checkbox" name="remember" class="form-check-input" id="remember">
                    <label class="form-check-label" for="remember">Nhớ tôi</label>
                </div>
                <a href="#">Quên mật khẩu?</a>
            </div>

            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
            <p class="mt-3 text-center mb-0">Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
        </form>
    </div>
</div>
</body>
</html>