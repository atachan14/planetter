<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planetter</title>
</head>
<body>
	<form action="criatePlanet" method="post">
		<input type="hidden" name="type" value="check"> PlanetName:<input type="text" name="plName">
		<c:if test="${error!=null}">パスワードが間違っています。</c:if>
		<br> xSize:<input type="number" name="xSize" value="3" min="1" max="${acd.stardust/2000 }" step="1">
		<br> ySize:<input type="number" name="ySize" value="3" min="1" max="${acd.stardust/2000 }" step="1">
		<br> <input type="hidden" name="x" value="${x}"> 
		<input	type="hidden" name="y" value="${y}">
		<input type="submit" value="criate">
		</form>
		${error}
</body>
</html>