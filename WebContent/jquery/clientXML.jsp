<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리</title>
<style type="text/css">
.redText {
	color: red;
}

.blueText {
	color: blue;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	//window load event handler
	//$(document).bind("ready",function(){})
	$(function() {
		$("#btnSearch").bind("click", loadCD);
	})

	//cd카타로그 조회
	function loadCD() {
		$
				.get(
						"../server/cd.xml",
						function(datas) {

							var list = datas.getElementsByTagName("CD");
							var str = "";
							var style = "";
							for (i = 0; i < list.length; i++) {
								var title = list[i]
										.getElementsByTagName("TITLE")[0].firstChild.nodeValue;
								var artist = list[i]
										.getElementsByTagName("ARTIST")[0].firstChild.nodeValue;
								var price = list[i]
										.getElementsByTagName("PRICE")[0].firstChild.nodeValue;
								//price가 10보다 크면 출력
								if (style = price > 10 ? "blueText" : "redText") { // or style = price > 10? "blueText" : "redText"
									str += "<tr><td>" + title + "</td><td>"
											+ artist
											+ "</td><td class='"+style+"'>"
											+ price + "</td></tr>";
									$("#result").html(str); // == innerHTML
								}
							}
						}, "xml");
	}
</script>
</head>
<body>
	<h3>CD LIST</h3>
	<button type="button" id="btnSearch">조회</button>
	<table id="result" border="1">
	</table>
</body>
</html>