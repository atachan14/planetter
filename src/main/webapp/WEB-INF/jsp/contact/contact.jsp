<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンタクト(${mainCenter.data.name})</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>${mainCenter.data.name}</h1>
		<li>生存日数：${mainCenter.data.keepDays}</li>
		<li>星屑：${mainCenter.data.stardust}</li>
		<li>おなか：${mainCenter.data.stomach}</li> <br>
		<form action="contact" method="post">
			<input type="hidden" name="v8acName" value="${mainCenter.data.name}"> 
			<input type="submit" name="kill" value="殺す">
		</form>
	</div>
</body>
</html>