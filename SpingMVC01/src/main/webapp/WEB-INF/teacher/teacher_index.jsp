<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="${basePath }resources/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="${basePath }resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${basePath }resources/css/bootstrap.css">
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
<!-- end -->
<style>
td, th {
	text-align: center;
}
</style>
<title>老师信息列表</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<h3 align="center">老师信息列表</h3>
			<!-- 查询第一行 -->
			<form class="form-inline" action="${basePath }teacher/index.d"
				method="post">
				<div class="form-group">
					<label for="exampleInputName2">姓名</label> <input type="text"
						name="teacherName" value="${teachernamecondition }"
						class="form-control" id="exampleInputName2" placeholder="请输入姓名">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail2">工号</label> <input type="text"
						name="teacherNumber" value="${teachernumbercondition }"
						class="form-control" id="exampleInputEmail2" placeholder="请输入工号">
				</div>
				<!-- 查询老师-学院下拉菜单1 -->
				<div class="form-group">
					<label for="schoolshow">学院名</label>
					<input id="s" name="schoolId" value="${schoolidcondition }" type="hidden"><!-- 输入学院编号查询，也是与后台接口，隐藏了 -->
					<select id="s1" class="selectpicker" data-style="btn-info">
						<!-- option value="1">1:信息学院</option>
						<option value="2">2:土木学院</option>
						<option value="3">3:航海学院</option-->
					</select>
				</div>
				<!-- 获取数据库学院名，并动态注入下拉框 -->
				<script type="text/javascript">
					$(document).ready(function() {
						$(".selectpicker").selectpicker({ //每次页面刷新时，选择框重置
							   noneSelectedText : '请选择'
							  }); //设置初始显示字体
						$.get("${basePath}teacher/getSchoolsName.d",function(arr) {
							for (var i = 0; i < arr.length; i++) {
								/*创建新的一行*/
								var newRow = "<option value="+arr[i].schoolId+"> "+ arr[i].schoolId +"  "+ arr[i].schoolName+ "</option>";
								/*插入新的一行*/
								$("#s1").append(newRow);
								$('.selectpicker').selectpicker('val', '');//空一行位置显示：请选择
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
				<button type="submit" class="btn btn-primary">查询</button>
				<div class="form-group">
					<button data-toggle="modal" data-target="#addteacher" type="button"
						class="btn btn-warning">添加老师</button>
				</div>
			</form>
			<!-- 添加老师弹窗 -->
			<form action="${basePath }teacher/add.d" method="post">
				<div class="modal fade" id="addteacher" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<!-- button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button-->
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">老师个人信息</h4>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
									<div class="col-sm-10">
										<input type="text" name="teacherName" class="form-control"
											id="inputEmail3">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">工号</label>
									<div class="col-sm-10">
										<input type="text" name="teacherNumber" class="form-control"
											id="inputPassword3">
									</div>
								</div>
								<!--div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">学院号</label>
									<div class="col-sm-10">
										<input type="text" name="schoolId" class="form-control"
											id="inputPassword3">
									</div>
								</div-->
								
								<!-- 添加老师-学院下拉菜单2 -->
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">学院名</label>
									<div class="col-sm-10">
										<input id="ss" name="schoolId" type="hidden"><!-- 输入学院编号查询，也是与后台接口，隐藏了 -->
										<select id="ss1" class="selectpicker form-control">
											<!--option value="1">1:信息学院</option>
											<option value="2">2:土木学院</option>
											<option value="3">3:航海学院</option-->
										</select>
									</div>
								</div>							
								<script type="text/javascript"><!-- 添加老师 -->
										$("#ss1").change(function(){
									    	  ss1 = $('#ss1 option:selected').val();//获得select：s1选中值的value
									    	  $("#ss").val(ss1)//s1复值给input：s
									    });
										$("#ss1").selectpicker({noneSelectedText : '请选择'}); 
										$(window).on('load', function() { 
											$.get("${basePath}teacher/getSchoolsName.d",function(arr) {
												for (var i = 0; i < arr.length; i++) {
													/*创建新的一行*/
													var newRow = "<option value="+arr[i].schoolId+"> "+ arr[i].schoolId +"  "+ arr[i].schoolName+ "</option>";
													/*插入新的一行*/
													$("#ss1").append(newRow);
													$('.selectpicker').selectpicker('val', '');//空一行位置显示：请选择
													$('.selectpicker').selectpicker('refresh'); //动态加载一条一条刷新数据
												}
											});
										});
								</script>
							
							<!-- 下拉菜单完 -->
								<div class="form-group">
									<button type="submit" id="closebtn"
										class="btn btn-info btn-block">保存</button>
									<button type="button" class="btn btn-default btn-block"
										data-dismiss="modal">关闭</button>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</form>
			<!-- 分行线 -->
			<hr>
			<!-- 表格区 -->
			<table class="text-center table table-bordered table-hovered">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>工号</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${teachers }" var="t" varStatus="i">
					<tr>
						<td>${t.teacherId }</td>
						<td>${t.teacherName }<span data-toggle="modal"
							data-target="#myModal${i.index }"
							class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</td>
						<td>${t.teacherNumber }</td>						
						<td><a class="btn btn-success"
							href="${basePath }teacher/update.d?teacherId=${t.teacherId }">修改</a>
							<button id="del${i.index }" class="btn btn-danger">删除</button></td>
					</tr>
					<!-- 自定义删除弹窗样式 -->
					<script>
						$("#del${i.index}")
								.click(
										function() {
											swal(
													{
														title : "Are you sure?",
														text : "确认删除 ${t.teacherName }!",
														type : "warning",
														showCancelButton : true,
														confirmButtonColor : "#DD6B55",
														confirmButtonText : "Yes, delete it!",
														cancelButtonText : "No, cancel plx!",
														closeOnConfirm : false,
														closeOnCancel : false
													},
													function(isConfirm) {
														if (isConfirm) {
															swal(
																	"Deleted!",
																	"${t.teacherName } 已删除.",
																	"success");
															window.location.href = "${basePath}teacher/delete.d?teacherId=${t.teacherId}";
														} else {
															swal(
																	"Cancelled",
																	"${t.teacherName } 未删除 :)",
																	"error");
														}
													});
										});
					</script>
					<!-- 点击问号-弹窗效果-显示老师信息 -->
					<!-- Modal-->
					<div class="modal fade" id="myModal${i.index }" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header text-center">
									<h4 class="modal-title" id="myModalLabel">老师个人信息</h4>
									<!-- button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button-->
								</div>
								<div class="modal-body">
									<ul class="list-group">
										<li class="list-group-item"><label>姓名</label>&nbsp;
											<span id="name${i.index }"></span></li>
										<li class="list-group-item"><label>工号</label>&nbsp;
											<span id="number${i.index }"></span></li>																		
										<li class="list-group-item"><label>学院编号</label>&nbsp;
											<span id="sid${i.index }"></span></li>
										<li class="list-group-item"><label>学院名称</label>&nbsp;
											<span id="sname${i.index }"></span>
										</li>										
									</ul>
									<br>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								</div>
							</div>
						</div>
					</div>
					<script>
						$('#myModal${i.index}').on('show.bs.modal',function(e) {
							$.get("${basePath}teacher/show.d?teacherId=${t.teacherId}",function(obj) {
									console.log(obj.teacherName+ ":"+ obj.teacherNumber+":"+obj.school.schoolId+":"+obj.school.schoolName);//网页previous控制台打印查看
									$("#name${i.index}").html(obj.teacherName);
									$("#number${i.index}").html(obj.teacherNumber);
									$("#sid${i.index}").html(obj.school.schoolId);
									$("#sname${i.index}").html(obj.school.schoolName);
								});	
							})
					</script>
					<!-- 显示老师信息完 -->
				</c:forEach>
			</table>
			<!-- 表格完 -->
			<div class="text-center">

				<!-- 分页显示 -->
				<pg:pager items="${count }" url="${basePath }teacher/index.d"
					maxIndexPages="10" maxPageItems="2" scope="request">
					<pg:param name="teacherName" value="${teachernamecondition }" />
					<pg:param name="teacherNumber" value="${teachernumbercondition }" />
					<pg:param name="schoolId" value="${schoolidcondition }" />
					<jsp:include page="../../resources/jsp/pager_tag.jsp"></jsp:include>
				</pg:pager>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>