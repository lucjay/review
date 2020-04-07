<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using weather api</title>

</head>
<script>
	function parseWeather(result) {
		var jsonData = JSON.parse(result);
		console.log(jsonData)
		document.getElementById("todaysWeather").innerHTML = jsonData.weather;
	}

	function loadJSON() { //url의 json 데이터 불러오는 함수
		var url = "http://api.openweathermap.org/data/2.5/weather?q=Daegu&appid=4bd4f955a62660c58da76b858fe05efb";
		var request = new XMLHttpRequest();
		request.overrideMimeType("application/json");
		request.open('GET', url, true);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == "200") {
				parseWeather(request.responseText);
			}
		};
		request.send(null);
	}
	window.onload = function() {
		loadJSON();
	}
</script>



<body>
	<span id="todaysWeather"></span>
</body>
</html>
