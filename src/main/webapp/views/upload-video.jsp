<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Video</title>
</head>
<body>
<h2>Upload Video</h2>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/upload-video" enctype="multipart/form-data">
    Title: <br />
    <input type="text" name="title" size="100" required /> <br /><br />
    Description: <br />
    <input type="text" name="description" size="100" /> <br /><br />
    Select video to upload: <br />
    <input type="file" name="videoFile" accept="video/*" required /> <br /><br />
    <input type="submit" value="Upload" />
</form>
</body>
</html>