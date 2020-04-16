<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id="num1" size="5">+
	<input id="num2" size="5">=
	<input id="sum" size="7">
	<button id="btnConfirm">정답확인</button>
	<div id="divResult">결과 출력</div>
	<script type="text/javascript">
		num1.value = Math.floor(Math.random() * 10);
		num2.value = Math.floor(Math.ramdom() * 10);

		btnConfirm.onclick = function() {
			var num1 = document.getElementById("num1");
			var num2 = document.getElementById("num2");
			

		}

		sum.onfoucus = function() {
			divResult.innerHTML = "";
		}
	</script>
</body>
</html>