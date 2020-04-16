<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", "홍길동");
		map.put("empid", "100");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("first_name", "김기자");
		map.put("empid", "200");
		list.add(map);

		request.setAttribute("list", list);
	%>


	<c:forEach items="${list}" var="emp">
	${emp.first_name}	<br>
	</c:forEach>
</body>
</html>