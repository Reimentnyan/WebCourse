<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác thực OTP</title>
</head>
<body>
<div class="row justify-content-center">
    <div class="col-md-5">
        <form action="${pageContext.request.contextPath}/verify-otp" method="post" class="needs-validation card p-4 shadow-sm" novalidate>
            <h2 class="mb-3 text-center">Xác thực mã OTP</h2>

            <c:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>

            <div class="mb-3">
                <label class="form-label">Mã OTP</label>
                <input type="text" placeholder="Nhập mã OTP 6 chữ số" name="otp" class="form-control" pattern="[0-9]{6}" maxlength="6" required>
                <div class="invalid-feedback">Vui lòng nhập đúng 6 chữ số của mã OTP.</div>
            </div>

            <button type="submit" class="btn btn-primary w-100">Xác nhận</button>
        </form>
    </div>
</div>
</body>
</html>