<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	//버튼이벤트
	$(function() {
		$('#btnSearch').bind("click", searchEmp);
	});

	function searchEmp() {
		//사번을 넘겨서 사번으로 사원정보를 검색
		$.ajax({
			url : "../server/findName.jsp",
			data : {
				id : $("#empNo").val()
			},
			dataType : "json",
			method : get
		//,async : false 동기식
		}).done(function(datas) {
			$("#result").html(datas.first_name + " " + datas.last_name);
		}).fail(function(xhr, status) {
			$("#result").html(status);
			console.dir(xhr);
		}).always(function() {

			alert("success");

			console.dir("처리완료");
		});
	}
</script>
</head>

<body>
	<input id="empNo">
	<button type="button" id="btnSearch" onclick="">검색</button>
	<div id="result"></div>
</body>
</html>