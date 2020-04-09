<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>datatype.jsp</title>
<script>
	//문자열 자르기
	var url = "http://localhost/js/dom/search.jsp";
	var pageName = url.substring(url.lastIndexOf("/") + 1);
	console.log(pageName);

	var id = "801201-1234567";
	var sex = id.substr(7, 1);
	console.log(sex);
	console.log(sex == '1' ? '남' : '여');

	var month = id.substr(2, 2);
	console.log("출생월:" + month);
</script>


</head>
<body>
	<h3>자바스크립트 데이터 타입 연습</h3>
</body>
</html>