<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function getMovieXML()() {
	
}


	function getMovieJSON() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var obj = JSON.parse(this.responseText); //응답결과
				console.log(obj);
				document.getElementById("moviename").innerHTML = obj.movieNm;
			}
		};
		var param = "id=" + document.getElementById("searchDay").value;
		xhttp
				.open(
						"GET",
						"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20200406"
								+ param, true);
		xhttp.send();
	}
</script>
</head>
<body>
	날짜
	<input id="searchDay">
	<h3>xml 영화 순위</h3>
	<button type="button" onclick="getMovieXML()">xml조회</button>
	<table id="movieXml"></table>


	<h3>json 영화 순위</h3>
	<input id="searchDay">
	<button type="button" onclick="getMovieJSON()">json조회</button>
	<div id="moviename"></div>
</body>
</html>
