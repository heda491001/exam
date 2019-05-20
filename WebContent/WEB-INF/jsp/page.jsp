<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ExamReport</title>
<script type="text/javascript">
	function test(args) {
		args = "args=" + args;
		if (args == "args=select") {
			args += "&id=" + document.getElementById("stuID").value
		}
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("table").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("POST", "/exam/ExamReports", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send(args);
	}
</script>
</head>
<body>
	<h1>成績表</h1>
	学籍番号を入力してください
	<input type="text" id="stuID" name="studentID">
	<input type="button" value="学籍番号指定" onclick="test('select')">
	<div id='table'></div>
	<p>----------------------------------</p>
	<input type="button" value="全件表示" onclick="test('selectAll')">
	&nbsp;
	<input type="button" value="英語点順" onclick="test('english')">
	&nbsp;
	<input type="button" value="数学点順" onclick="test('math')">
	&nbsp;
	<input type="button" value="国語点順" onclick="test('japanese')">
	&nbsp;
	<input type="button" value="理科点順" onclick="test('science')">
	&nbsp;
</body>
</html>