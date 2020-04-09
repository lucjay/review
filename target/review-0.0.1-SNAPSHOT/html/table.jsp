<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table.jsp</title>
<style type="text/css">
.memberlist tr:hover {
	background-color: gold;
}

.memberlist tr:nth-child(odd) {
	background-color: skyblue;
}

.memberlist {
	display: inline-block;
}

table, tr, td {
	border: 1px dotted gray;
}

td {
	padding: 10px;
}

table {
	margin: 0px 50px;
	10
	px;
	0
	px;;
}

.memberlist td:first-child {
	background-color: pink;
}

.memberlist:nth-child(1) {
	display: none;
}
</style>
</head>
<body>
	<table class="memberlist">
		<tr>
			<td>a</td>
			<td>b</td>
			<td>c</td>
		</tr>
		<tr>
			<td>d</td>
			<td>e</td>
			<td>f</td>
		</tr>
		<tr>
			<td>g</td>
			<td>h</td>
			<td>i</td>
		</tr>
		<tr>
			<td>j</td>
			<td>k</td>
			<td>l</td>
		</tr>
	</table>
	<table class="memberlist">
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>
		<tr>
			<td>4</td>
			<td>5</td>
			<td>6</td>
		</tr>
		<tr>
			<td>7</td>
			<td>8</td>
			<td>9</td>
		</tr>
		<tr>
			<td>10</td>
			<td>11</td>
			<td>12</td>
		</tr>
	</table>

</body>
</html>