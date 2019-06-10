<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
session.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>所有文件</h3>
<table>
	<c:forEach items="${list }" var="f">
		<tr>
			<td>${f.fileId }</td>
			<td>${f.fileName }</td>
			<td><a href="${basePath }file/download.do?fileId=${f.fileId }">下载</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>