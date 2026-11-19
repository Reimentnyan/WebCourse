<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
</head>
<body>
<div class="row justify-content-center">
    <div class="col-md-6">
        <form action="${pageContext.request.contextPath}/register" method="post" class="needs-validation card p-4 shadow-sm" novalidate>
            <h2 class="mb-3 text-center">Tạo tài khoản mới</h2>

            <c:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>

            <div class="mb-3">
                <label class="form-label">Họ tên</label>
                <input type="text" placeholder="Họ tên" name="fullname" class="form-control" required>
                <div class="invalid-feedback">Vui lòng nhập họ tên.</div>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" placeholder="Nhập Email" name="email" class="form-control" required>
                <div class="invalid-feedback">Vui lòng nhập địa chỉ email hợp lệ.</div>
            </div>

            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <input type="text" placeholder="Số điện thoại" name="phone" class="form-control" pattern="0[0-9]{9}" required>
                <div class="invalid-feedback">Số điện thoại gồm 10 chữ số, bắt đầu bằng số 0.</div>
            </div>

            <div class="mb-3">
                <label class="form-label">Tài khoản</label>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control" pattern="[A-Za-z0-9_]{4,30}" required>
                <div class="invalid-feedback">Tài khoản gồm 4–30 ký tự (chữ, số hoặc dấu gạch dưới).</div>
            </div>

            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control" minlength="6" required>
                <div class="invalid-feedback">Mật khẩu phải có ít nhất 6 ký tự.</div>
            </div>

            <button type="submit" class="btn btn-primary w-100">Tạo tài khoản</button>
            <p class="mt-3 text-center mb-0">Nếu bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
        </form>
    </div>
</div>
</body>
</html>