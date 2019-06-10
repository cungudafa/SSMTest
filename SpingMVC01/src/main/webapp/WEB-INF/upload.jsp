<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Test</title>
</head>
<body>
	<h1>文件上传</h1>
	<form action="${basePath }file/doUpload.d" enctype="multipart/form-data" method="post">
		<input type="file" name="uploadFile">
		<button type="submit">上传</button>
	</form>
</body>
</html>