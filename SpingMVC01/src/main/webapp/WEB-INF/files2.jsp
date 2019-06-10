<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
session.setAttribute("basePath", basePath);
%>


<table align="center" style="width: 720px" id="files" class="table table-bordered table-hover">
	<tr>
		<th>编号</th>
		<th>文件名</th>
		<th>文件保存路径</th>
	</tr>
	<c:forEach items="${files }" var="f">
		<tr>
			<td>${f.fileId }</td>
			<td>${f.fileName }</td>
			<td>${f.fileUrl }</td>
		</tr>
	</c:forEach>
</table>