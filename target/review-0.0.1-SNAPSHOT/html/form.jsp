<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
label {
	display: inline-block;
	width: 100px;
}

body {
	font-size: 10px;
}

input, select, textarea, label {
	font-size: 2em;
}

input:hover {
	background: gold;
}

input[name='pw'] {
	background-color: green;
}
</style>
<script type="text/javascript">
	//스토리지(쿠키와같은 기능)
	localStorage.setItem("lastname", "Smith");

	var x = document.getElementById("demo");
	function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition);
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}

	function showPosition(position) {
		x.innerHTML = "Latitude: " + position.coords.latitude
				+ "<br>Longitude: " + position.coords.longitude;
	}

	function inputCheck() {
		//document.getElementById("id")
		//document.forms["frm"]
		//document.frm.id
		//id pw 필수입력체크
		if (frm.id.value == "") {
			alert("id입력")
			frm.id.focus();
			return;
		}
		if (frm.pw.value == "") {
			alert("pw입력");
			frm.pw.focus();
			return;
		}
		//jobs(select태그)선택되었는지 확인
		if (frm.jobs.selectedIndex > 0) {
			alert("job선택");
			frm.jobs.focus();
			return;
		}

		var hobbyChkLen = document.querySelectorAll("[name='hobby']:checked").length;
		if (hobbyChkLen == 0) {
			alert("적어도 취미하나 선택");
			return false;
		}
	}
</script>
</head>
<body>
	<form method="post" id="frm" name="frm">
		<fieldset>
			<legend>회원가입</legend>
			<div>
				<label for="id">ID </label><input type="text" id="id" name="id"
					placeholder="ID">
			</div>
			<div>
				<label for="pw">PW </label><input type="password" id="pw" name="pw"
					tabindex="1" autofocus="autofocus">
			</div>
			<div>
				<label for="role">ROLE </label><input type="radio" id="admin"
					name="role" value="admin"><label for="admin">Admin</label><input
					type="radio" id="user" name="role" value="user"> <label
					for="user">User</label>
			</div>
			<div>
				<label for="jobs">JOB </label> <select id="jobs" name="jobs">
					<option value="se">개발자</option>
					<option value="ds">디자이너</option>
				</select>
			</div>
			<div>
				<label for="reason">가입동기 </label>
				<textarea name="reason" rows="10" cols="30" readonly="readonly"></textarea>
			</div>
			<div>
				<label for="hobbys">HOBBY </label> <input type="checkbox"
					id="hobby1" name="hobby" value="movie"> <label for="hobby2">영화</label>
				<input type="checkbox" id="hobby2" name="hobby" value="music">
				<label for="hobby2">음악</label><input type="checkbox" id="hobby3"
					name="hobby" value="ex"> <label for="hobby3">운동</label>
			</div>
			<div>
				<label for="addr">ADDRESS </label><input type="text" id="addr"
					name="addr">
				<button type="button">검색</button>
			</div>
			<br>
			<div>
				<button type="reset">초기화</button>
				<button type="button" onclick="inputCheck()">등록</button>
			</div>
		</fieldset>
	</form>
</body>
</html>