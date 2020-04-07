<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		//현재문서의 모든 그림의 width100px로 지정
		var imgs = document.images; //이미지객체 배열
		for (i = 0; i < imgs.length; i++) {
			imgs[i].style.width = 100 + "px";
		}

	}
</script>
</head>
<body>
	<img src="../img/beach.jpg">
	<img src="../img/cherry.jpg">
	<img src="../img/wallpaper.jpg">
</body>
</html>