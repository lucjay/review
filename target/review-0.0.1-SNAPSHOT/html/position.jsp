<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>position</title>
<style type="text/css">
div {
	/*display: inline-block;*/
	width: 200px;
	height: 200px;
	margin-right: 20px;
	/*border: 0px solid skyblue;*/
	text-align: center;
	height: 200px;
	margin-right: 20px;
	background-color: pink;
}

#divb {
	background-color: gold;
	position: fixed;
	bottom: 0px;
	right: 0px;
}

#divc {
	position: absolute;
	top: 100px;
	left: 100px;
	background-color: lightgray;
}
</style>
</head>
<body>
	<div>a</div>
	<div id="divb">b</div>
	<div id="divc">c</div>
	<div>d</div>
</body>
</html>