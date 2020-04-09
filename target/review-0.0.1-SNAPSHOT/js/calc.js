function calc() {
	// 입력값
	// var n1 = document.getElementById("num1").value;
	var n1 = document.getElementsByName("num1")[0].value;
	var n2 = document.getElementById("num2").value;

	// 계산
	var result = sum(n1, n2);
	// 결과출력
	// document.getElementById("result").innerHTML = result;
	// document.getElementsTagName("div")[0].innerHTML = result;
	// document.getElementsByClassName("result")[0].innerHTML = result;
	document.querySelectorAll(".result")[0].innerHTML = result;

}

function sum(n1, n2) {
	var r = parseInt(n1) + parseInt(n2);
	return r;
}