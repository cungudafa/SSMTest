<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>查看个人信息</title>
<script src="${basePath }resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="${basePath }resources/css/bootstrap.min.css">
<script src="${basePath }resources/js/bootstrap.min.js"></script>
<!-- 下拉菜单 -->
<link rel="stylesheet"
	href="${basePath }resources/bootstrap-select-1.13.9/css/bootstrap-select.min.css">
<script
	src="${basePath }resources/bootstrap-select-1.13.9/js/bootstrap-select.min.js"></script>
<script
	src="${basePath }resources/bootstrap-select-1.13.9/js/i18n/defaults-*.min.js"></script>
<!-- end -->
</head>
<body>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<h3 align="center">老师个人信息-----没有用到这个页面</h3>

			<form class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" readonly id="inputEmail3"
							value="${teacher.teacherName }">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">工号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" readonly
							id="inputPassword3" value="${teacher.teacherNumber }">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" id="closebtn"
							class="btn btn-default btn-block">关闭</button>
					</div>
					<script>
						$(document).ready(function() {
							$("#closebtn").click(function() {
								window.history.go(-1);
							});
						});
					</script>
				</div>
			</form>

		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>