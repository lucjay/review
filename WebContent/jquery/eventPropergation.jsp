<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트전파</title>
<style type="text/css">
div {
	border: 1px solid blue;
	padding: 100px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#grand").bind("click", function() {
			alert("grand click");
		});
		$("#parent").bind("click", function() {
			alert("parent click");
		});
		$("#child").bind("click", function(e) {
			alert("child click");
			e.stopPropagation();
		});

	});
</script>
</head>
<body>
	<div id="grand">
		grand
		<div id="parent">
			parent
			<div id="child">child</div>
		</div>
	</div>
</body>
</html>