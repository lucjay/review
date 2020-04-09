<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client.jsp</title>
<script>
	function dupCheck() {
		var xhttp = new XMLHttpRequest();
		//1.XHR 객체를 생성함
		//2.콜백함수를 지정해줌. on으로 시작하는 이벤트를 건것. xhttp객체 안에 readystate 속성값이 변경될때 이 함수가 실행된다.
		xhttp.onreadystatechange = function() {
			console.log(this.readyState);
			if (this.readyState == 4) { //요청완료
				if (this.status == 200) { //실행ok
					console.log("ajax요청완료"); //1
					document.getElementById("result").innerHTML = this.responseText;
				} else {
					document.getElementById("result").innerHTML = this.status;
				}
			} else {
				document.getElementById("result").innerHTML = "로딩중";
			}
			//responseText에  서버에서 넘겨주는 텍스트가 담김
		};
		//3.요청준비	
		var param = "id=" + id.value; // document.getElementById("id").value와 같음
		xhttp.open("POST", "../server/idCheck.jsp?");
		//오픈해서 서버쪽에 겟으로 txt를 호출하고  비동기식(트루)
		//4.요청시작
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhttp.send(param); //동기식이면 send함수가 실행완료블록킹
		console.log("ajax요청처리"); //2
	}
</script>
</head>
<body>
	<form>
		ID<input id="id" name="id" onchange="dupCheck()"><span
			id="result"></span><br>PW<input id="pw" name="pw">
	</form>

</body>
</html>