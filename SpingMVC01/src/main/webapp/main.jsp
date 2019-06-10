<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 下拉菜单 -->
<link rel="stylesheet"
	href="${basePath }resources/bootstrap-select-1.13.9/css/bootstrap-select.min.css">
<script
	src="${basePath }resources/bootstrap-select-1.13.9/js/bootstrap-select.min.js"></script>
<!-- end -->
</head>
<body>
	<form action="${basePath }teacher/index.d" method="post">老师</form>
	<h1>Helloworld</h1>
	<form action="${basePath }dologin.d" method="post">
		<input type="text" name="userName" /><br /> <input type="text"
			name="userPassword" /><br /> <input type="submit" value="添加" />
	</form>
	欢迎您，${user.userName },id=${id }
	<br>
	<a href="${basePath }file/upload.d">文件上传</a>
	<br>
	<a href="${basePath }file/files.d">查看所有文件</a>
	<br>
	<h1>学生登录</h1>
	<form action="${basePath }student/list.d" method="post">
		<input type="text" name="studentName" placeholder="请输入姓名"> <input
			type="text" name="studentNumber" placeholder="请输入学号">
		<button type="submit">查询</button>
	</form>
	<h1>查询</h1>
	     <label for="classify" class="col-sm-2 control-label">填报部门：</label>
		 <div class="col-sm-3">
			 <select class="selectpicker form-control" data-live-search="true" name="addid" id="addid">
			 </select>
	       </div>
	     <script type="text/javascript">
	     /*获取下拉菜单*/
	     function showSel(){
		     $.ajax({  
		             "type" : 'get',  
		             "url": '${basePath }teacher/show.d?teacherId=1',
		             "dataType" : "json",  
		             "success" : function(data) {  
							     var school_list = data;
							     var opts = "";
							     for( var i = 0 ; i < school_list.length; i++ ){
							     	var depart = school_list[i];
							     	opts += "<option value='"+school_list[i].teacherId+"'>"+school_list[i].teacherName+"</option>";
							     }
							     // 查询界面
							     $("#addid").append(opts);  
							     $("#addid").selectpicker("refresh");
					       }  
				     });  
		     }
	     </script>
	 <h1>查询学校</h1>
	 <select id="schoolno" name="schoolno" class="selectpicker" >
	</select>
	<script type="text/javascript">
	function getschoolList() {//获取下拉学校列表
        $.ajax({
            url: "${basePath }teacher/show.d?teacherId=%1%",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
			// 数据发送方式
            type: "get",
			// 接受数据格式
            dataType: "json",
			// 要传递的数据
            data: 'data',
			// 回调函数，接受服务器端返回给客户端的值，即result值
            success: function (data) {
            	console.log(data.teacherName+ ":"+ data.teacherNumber+":"+data.school.schoolId)//网页previous控制台打印查看
                $.each(data.data, function (i) {
                    $('#schoolno.selectpicker').append("<option value=" + data.data[i].teacherId + ">" + data.data[i].teacherName + "</option>");
                });
                $('#schoolno').selectpicker('refresh');
            },
            error: function (data) {
                alert("查询学校失败" + data);
            }
        })
	}
        
	</script>
 
	
	 



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
