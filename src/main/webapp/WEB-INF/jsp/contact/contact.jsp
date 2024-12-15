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
		<li>歩いた数：${mainCenter.data.walkCount}</li>
		<li>食べた数：${mainCenter.data.eatCount}</li>
		<li>呟いた数：${mainCenter.data.tweetCount}</li>
		<li>広げた数：${mainCenter.data.pageCount}</li>
		<li>分解した数：${mainCenter.data.dsasseCount}</li>
		<li>作成したplanetの数：${mainCenter.data.planetCount}</li>
		<li>殺した数：${mainCenter.data.killCount}</li>
		<br>
		<li>星屑：${mainCenter.data.stardust}</li>
		<li>おなか：${mainCenter.data.stomach}</li> <br>
		
		<form action="contact" method="post">
			<input type="hidden" name="v8acName" value="${mainCenter.data.name}"> 
			<input type="submit" name="kill" value="殺す">
		</form>
	</div>
</body>
</html>