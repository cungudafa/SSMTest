<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${basePath }resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="${basePath }resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${basePath }resources/css/bootstrap.css">
<script src="${basePath }resources/js/bootstrap.min.js"></script>
<!-- 警告弹窗 >
<script src="${basePath }resources/js/sweet-alert.min.js"></script-->
<link rel="stylesheet" type="text/css"
	href="${basePath }resources/css/sweet-alert.css">
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
	<h1>书籍分类:</h1>
	<select id="s1">
		<option value="1">教学类</option>
		<option value="2">技术类</option>
	</select>
	<script type="text/javascript">
		window.onload = function() {

			//首先获得下拉框的节点对象；
			var select = document.getElementById("s1");

			//1.如何获得当前选中的值？：
			var value = select.value;

			//2.如何获得该下拉框所有的option的节点对象
			var options = select.options;
			//注意：得到的options是一个对象数组

			//3.如何获得第几个option的value值?比如我要获取第一option的value,可以这样：
			var value1 = options[0].value;
			//4.如何获得第几个option的文本内容?比如我要获取第一option的文本,可以这样：
			var text1 = options[0].text;

			//5.如何获得当前选中的option的索引？
			var index = select.selectedIndex;

			//6.如何获得当前选中的option的文本内容？
			//从第2个问题，我们已经获得所有的option的对象数组options了
			//又从第5个问题，我们获取到了当前选中的option的索引值
			//所以我们只要同options[index]下标的方法得到当前选中的option了
			var selectedText = options[index].text;
		}
	</script>
</body>
</html>