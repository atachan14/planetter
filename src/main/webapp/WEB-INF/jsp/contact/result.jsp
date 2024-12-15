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
		<li>星屑：■■■■</li>
		<li>おなか：■■■■</li> <br>
		<p>星屑が${mainCenter.data.stardust}増えた。</p>
		<p>おなかが${mainCenter.data.stomach}回復した。</p>
		<form action="main" method="get">
			 <input type="submit" value="黙祷おわり！">
		</form>
	</div>
</body>
</html>