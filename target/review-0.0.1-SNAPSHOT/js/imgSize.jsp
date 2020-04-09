<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#goodImg {
	width: 200px;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		goodImg.style.width = "100px";
	}
	function imgSize() {
		//이미지 크기를 400px 변경
		document.getElementById("goodImg").style.width = "500px";
	}

	function imgChange() {
		goodImg.src = "../img/logo.gif";

	}

	function imgSizeUp() {
		var w = goodImg.style.width;
		goodImg.style.width = (parseInt(w) + 100) + "px";

		console.log(w);

	}

	window.setInterval(imgSizeUp, 1000);
</script>
</head>
<body>
	<button onclick="imgSizeUp()">점점크게</button>
	<button onclick="imgChange()">그림변경</button>
	<button onclick="imgSize()">크기변경</button>
	<img src="../img/wallpaper.jpg" id="goodImg">
	<img src="">
	<img src="">
</body>
</html>