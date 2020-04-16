<%@page import="java.util.HashMap"%>
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
<% HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("first_name", "홍길동");
	map.put("empid", "100");
	request.setAttribute("emp", map);
%>

이름 출력 : ${emp.first_name} <br>
<hr>
map 전체 조회 <br>
<c:forEach items="${emp}" var="temp">
	${temp.key} ${temp.value} <br>

</c:forEach>

</body>
</html>