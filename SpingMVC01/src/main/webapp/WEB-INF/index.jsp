<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎您，${user.userName },id=${id }
	<br>
	<a href="${basePath }file/upload.do">文件上传</a>
	<br>
	<a href="${basePath }file/files.do">查看所有文件</a>
	<br>
	<h3>学生信息</h3>
	<table>
		<tr>
			<th>学号</th>
			<th>姓名</th>
		</tr>
		<c:forEach items="${students }" var="s">
			<tr>
				<td>${s.studentNumber }</td>
				<td>${s.studentName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>