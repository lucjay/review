<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function addFruit() {
		var c = document.createElement("option");
		c.text = document.getElementById("txtFruit").value;

		var input = document.getElementById("selFruit");
		input.appendChild(c);
	}

	function delFruit() {
		var x = document.getElementById("selFruit");
		x.remove((x.selectedIndex));
	}
</script>
</head>
<body>
	<input name="txtFruit" id="txtFruit">
	<button type="button" onclick="addFruit()">추가</button>
	<br>
	<select name="selFruit" id="selFruit" size="10" style="width: 170px"></select>
	<button type="button" onclick="delFruit()">삭제</button>
</body>
</html>