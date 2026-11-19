<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tải Lên Video</title>
</head>
<body>
<div class="row justify-content-center">
    <div class="col-md-6">
        <form method="post" action="${pageContext.request.contextPath}/upload-video" enctype="multipart/form-data" class="needs-validation card p-4 shadow-sm" novalidate>
            <h2 class="mb-3 text-center">Tải Lên Video</h2>

            <c:if test="${message != null}">
                <div class="alert alert-info">${message}</div>
            </c:if>

            <div class="mb-3">
                <label class="form-label">Tiêu đề</label>
                <input type="text" name="title" class="form-control" maxlength="255" required>
                <div class="invalid-feedback">Vui lòng nhập tiêu đề video (tối đa 255 ký tự).</div>
            </div>

            <div class="mb-3">
                <label class="form-label">Mô tả</label>
                <textarea name="description" class="form-control" rows="3"></textarea>
            </div>

            <div class="mb-3">
                <label class="form-label">Chọn tệp video</label>
                <input type="file" name="videoFile" class="form-control" accept="video/*" required>
                <div class="invalid-feedback">Vui lòng chọn một tệp video hợp lệ.</div>
            </div>

            <button type="submit" class="btn btn-primary w-100">Tải lên</button>
        </form>
    </div>
</div>
</body>
</html>