<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.pages {
	list-style: none;
	padding: 0 12px; margin: 0;
	background: #5c8a97;
	margin: 10px;
	display: inline-block;
	height: 50px;
	overflow: hidden;
	border-radius: 5px;
	
	/* 3d effect using box-shadows */
	box-shadow: 0px 4px #3b636e, 0px 4px 6px rgba(0, 0, 0, 0.3);
}
.group {
	margin-left: 10px;
	display: inline-block;
	position: relative;
	bottom: -11px;
}
.item{
	background: #a1d0dd;
	display: block;
	border-radius: 3px;
	padding: 0 12px;
	color: white;
	position: relative;
	text-decoration: none;
	height: 27px;
	font: 12px / 27px "PT Sans", Arial, sans-serif;
	/* Now the 3d effect */
	box-shadow: 0px 3px #7fafbc, 0px 4px 5px rgba(0, 0, 0, 0.3);
	transition: all 0.3s ease;
}
.item:hover {background: #bae0ea}
.item:active {
	background: #bae0ea;
	/* Now, let's make it look like its pressed down when clicked */
	bottom: -3px;
	box-shadow: 0px 0px #7fafbc, 0px 1px 3px rgba(0, 0, 0, 0.3);
}
.active_page{
    background: #bae0ea;
	/* Now, let's make it look like its pressed down when clicked */
	bottom: -3px;
	box-shadow: 0px 0px #7fafbc, 0px 1px 3px rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<div class="pages">	
	  	<div class="group">
		<pg:first export="pageUrl" unless="current">
			<c:if test="${pageUrl!=null}">
				<a href="${pageUrl}" class="item">首页</a>
			</c:if>
		</pg:first>
		</div>
		<div class="group">
		<pg:prev export="pageUrl" ifnull="${true}">
			<c:if test="${pageUrl != null}">
				<a href="${pageUrl}" class="item" title="上一页">上一页</a>
			</c:if>
		</pg:prev>
		</div>
		
		<pg:pages>
			<c:choose>
				<c:when test="${currentPageNumber eq pageNumber}">
					<span>${pageNumber }</span>
				</c:when>
				<c:otherwise>
					<div class="group"><a href="${pageUrl}" class="item active_page">${pageNumber }</a></div>
				</c:otherwise>
			</c:choose>
		</pg:pages>
		
		<div class="group">
		<pg:next export="pageUrl" ifnull="${true}">
			<c:if test="${pageUrl!=null}">
				<a href="${pageUrl}" class="item" title="下一页">下一页</a>
			</c:if>
		</pg:next>
		</div>
		<div class="group">
		<pg:last export="pageUrl" unless="current">
			<c:if test="${pageUrl!=null}">
				<a href="${pageUrl}" class="item">尾页</a>
			</c:if>
		</pg:last>
		</div>
	</div>
	<div class="count">
		<pg:page export="first,last">
	  	当前<label>${first }-${last }</label>共<label>${count }</label>条记录
	  	</pg:page>
	 </div> 
</body>
</html>