<%--
  Created by IntelliJ IDEA.
  User: rei
  Date: 11/19/26
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác thực OTP</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/verify-otp" method="post">
    <h2>Xác thực mã OTP</h2>

    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>

    <section>
        <input type="text" placeholder="Nhập mã OTP 6 chữ số" name="otp" maxlength="6" required>
    </section>

    <button type="submit">Xác nhận</button>
</form>
</body>
</html>