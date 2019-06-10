<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>success!</title>
  </head>
  <body>
    <div class="alert alert-success" role="alert">success</div>
    	欢迎您，${user.userName }<br>
    <h3>请选择你的操作：</h3>
	<a href="${basePath }file/upload.do">文件上传</a><br>
	<a href="${basePath }file/files.do">查看所有文件</a><br>

 </body>
</html>
