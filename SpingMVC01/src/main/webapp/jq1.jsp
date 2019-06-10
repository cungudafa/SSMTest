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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${basePath }resources/js/jquery-3.4.1.min.js"></script>
<script src="${basePath }resources/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${basePath }resources/css/bootstrap.min.css">
</head>
<body>
	<button id="btn">点击</button>
	<p>pppppppppppppppppppp点击我会消失ppppppppppppppppppppppppp</p>
	<h3>方法一</h3>
	<button id="btn1">查看一条文件信息</button>
		<p>文件信息</p>
		<p id="fileInfo">
		<p id="file_id"></p>
		<p id="file_name"></p>
		<p id="file_url"></p>
	<button id="btn2">查看所有文件信息</button>
	<h3>方法二</h3>
	<table align="center" style="width: 720px" id="files"
		class="table table-bordered table-hover">
		<tr>
			<th>编号</th>
			<th>文件名</th>
			<th>文件保存路径</th>
		</tr>
	</table>
	<script type="text/javascript">
		$(document).ready(
						function() {
							$("#btn").click(function() {
								alert('click!');
							});
							$("p").click(function() {
								$(this).slideToggle();
							});
							$("#btn1").click(function(){
								$.get("${basePath}file/json/get.d?fileId=5",function(obj){
									$("#file_id").html(obj.fileId);
									$("#file_name").html(obj.fileName);
									$("#file_url").html(obj.fileUrl);
								})
							});
							$("#btn2").click(function() {
								$.get("${basePath}file/json/getall.d",
								function(arr) {
									for (var i = 0; i < arr.length; i++) {
										/*创建新的一行*/
										var newRow = "<tr><td>"
										+ arr[i].fileId
										+ "</td><td>"
										+ arr[i].fileName
										+ "</td><td>"
										+ arr[i].fileUrl
										+ "</td></tr>";
										/*表格插入新的一行*/
										$("#files tr:last").after(newRow);
										}
							});
					});
		});
	</script>
	<h3>方法三</h3>
	<button id="btn3">查看所有文件信息2</button>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btn3").click(function() {
				$("#files2").load("${basePath}file/json/getall2.d");
			});
		});
	</script>
	<div id="files2"></div>
</body>
</html>