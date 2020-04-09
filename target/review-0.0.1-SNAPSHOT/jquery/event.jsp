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
	//페이지 로드 이벤트
	$(function() {
		//li mouseover 이벤트
		$("ul").on("mouseover", "li", function() {
			$(this).css("backgroundColor", "pink");

		});

		//버튼 클릭 이벤트
		$("button").bind("click", function() {
			$("ul").append($("<li>").html("spring")); // "<li>spring</li>"

		});

	});
</script>
</head>
<body>
	<button type="button">추가</button>
	<ul>
		<li>자바
		<li>jsp
	</ul>
</body>
</html>