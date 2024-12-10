<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	アカウント登録/ログイン
	<br>
	<form action="top" method="post">
		UserName：<input type="text" name="name"><br> 
		Password：<input type="text" name="pass"> 
<!--		<c:if test="${error!=null}">パスワードが間違っています。</c:if>-->
		<br> 
		<input type="submit" value="登録/ログイン"><br>
	</form>
</body>
</html>