<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.redText {
	color: red;
}

.blueText {
	color: blue;
}
</style>
<script type="text/javascript">
	function loadCD() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var docXML = this.responseXML;
				var list = docXML.getElementsByTagName("CD");
				var str = "";
				var style = "";
				for (i = 0; i < list.length; i++) {
					var title = list[i].getElementsByTagName("TITLE")[0].firstChild.nodeValue;
					var artist = list[i].getElementsByTagName("ARTIST")[0].firstChild.nodeValue;
					var price = list[i].getElementsByTagName("PRICE")[0].firstChild.nodeValue;
					//price가 10보다 크면 출력
					if (style = price > 10 ? "blueText" : "redText") { // or style = price > 10? "blueText" : "redText"
						str += "<tr><td>" + title + "</td><td>" + artist
								+ "</td><td class='"+style+"'>" + price
								+ "</td></tr>";
						result.innerHTML = str;
						console.log(title + ":" + artist);
					}
				}
			}
		};
		xhttp.open("GET", "../server/cd.xml", true);
		xhttp.send();
	}

	//window load event handler
	window.addEventListener("load", function() {
		document.getElementById("btnSearch").addEventListener("click", loadCD);
	});
</script>
</head>
<body>
	<h3>CD LIST</h3>
	<button type="button" id="btnSearch">조회</button>
	<table id="result" border="1">
	</table>
</body>
</html>