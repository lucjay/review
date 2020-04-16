<%@page import="common.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.pagination ul {
	list-style: none;
	float: left;
	display: inline;
}

.pagination ul li {
	float: left;
}

.pagination ul li a {
	float: left;
	padding: 4px;
	margin-right: 3px;
	width: 15px;
	color: #000;
	font: bold 12px tahoma;
	border: 1px solid #eee;
	text-align: center;
	text-decoration: none;
}

.pagination ul li.active {
	float: left;
	padding: 4px;
	margin-right: 3px;
	width: 15px;
	color: #000;
	font: bold 12px tahoma;
	border: 1px solid #eee;
	text-align: center;
	text-decoration: none;
}

.pagination ul li a:hover, .pagination ul li a:focus {
	color: #fff;
	border: 1px solid #f40;
	background-color: #f40;
}
</style>
</head>
<body>
	<h3>게시글 목록</h3>
	<div>
		<my:boardCate selname="boardCate"></my:boardCate>
		<button>검색</button>
	</div>
	<%
		Paging paging = new Paging();
		paging.setPage(7);
		paging.setPageUnit(3);
		paging.setPageSize(5);
		paging.setTotalRecord(100);
	%>
	<my:paging paging="<%=paging%>" jsfunc="goPage"></my:paging>
</body>
</html>