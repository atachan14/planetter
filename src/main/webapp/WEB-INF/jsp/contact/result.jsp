<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planetter</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>■■■■</h1>
		<li>生存日数：■■■■</li>
		<li>歩いた数：■■■■</li>
		<li>食べた数：■■■■</li>
		<li>呟いた数：■■■■</li>
		<li>広げた数：■■■■</li>
		<li>分解した数：■■■■</li>
		<li>作成したplanetの数：■■■■</li>
		<li>殺した数：■■■■</li>
		<br>
		<li>星屑：■■■■</li>
		<li>おなか：■■■■</li> <br>
		<p>星屑が${mainCenter.data.stardust}増えた。</p>
		<p>おなかが${mainCenter.data.stomach}回復した。</p>
		<br>
		<form action="main" method="get">
			 <input type="submit" value="next">
		</form>
	</div>
</body>
</html>