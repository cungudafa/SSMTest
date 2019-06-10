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
<title>修改个人信息</title>
<script src="${basePath }resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="${basePath }resources/css/bootstrap.min.css">
<script src="${basePath }resources/js/bootstrap.min.js"></script>
<!-- 警告弹窗 -->
<script src="${basePath }resources/js/sweet-alert.min.js"></script>
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
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h3 align="center">老师个人信息修改</h3>

        <form class="form-horizontal" action="${basePath }teacher/doupdate.d" method="post">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" name="teacherName" value="${teacher.teacherName }" class="form-control" id="inputEmail3" value="王老师">
                </div>
            </div>
            <input type="hidden" name="teacherId" value="${teacher.teacherId }">
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">工号</label>
                <div class="col-sm-10">
                    <input type="text" name="teacherNumber" value="${teacher.teacherNumber }" class="form-control" id="inputPassword3" value="100002">
                </div>
            </div>
            <!-- div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">学院编号</label>
                <div class="col-sm-10">
                    <input type="text" name="teacherNumber" value="${teacher.school.schoolId }" class="form-control" id="inputPassword3" value="100002">
                </div>
            </div-->
            <!-- 下拉菜单1 -->
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">学院名</label>
					<div class="col-sm-10">
						<input id="s" name="schoolId" value="${teacher.school.schoolId }" type="hidden"><!-- 获得更新前学院编号，也是与后台接口，隐藏了 -->
						<select id="s1" class="selectpicker form-control" data-style="btn btn-info">
							<!--option value="1">1:信息学院</option>
							<option value="2">2:土木学院</option>
							<option value="3">3:航海学院</option-->
						</select>
					</div>
				</div>
				<script type="text/javascript">
					$(function() {//每次页面刷新时，选择框显示已选择的schoolId
						  $.get("${basePath}teacher/getSchoolsName.d",function(arr) {
								for (var i = 0; i < arr.length; i++) {
									/*创建新的一行*/
									var newRow = "<option value="+arr[i].schoolId+"> "+ arr[i].schoolId +"  "+ arr[i].schoolName+ "</option>";
									/*插入新的一行*/
									$("#s1").append(newRow);
									s = $('#s').val();//获得修改前老师所属学院
									$('.selectpicker').selectpicker('val', s); //下拉框空一行位置显示：修改前老师所属学院
									$('.selectpicker').selectpicker('refresh'); //动态加载一条一条刷新数据
								}
							});
					 });
					$("#s1").change(function(){
				    	s1 = $('#s1 option:selected').val();//获得select：s1选中值的value
				    	$("#s").val(s1)//s1复值给input：s
				    })
				</script>
			<!-- 下拉菜单完 -->
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="closebtn" class="btn btn-success btn-block">保存</button>
                    <script>
	                    $("closebtn").click(function() {
	                    	swal("Good job!", "${teacher.teacherNumber } 修改成功!", "success")
	                    });
                    </script>
                </div>
            </div>
        </form>

    </div>
    <div class="col-md-4"></div>
</div>

</body>
</html>