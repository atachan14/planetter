<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planetter</title>
<style>
.cell-button {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	cursor: pointer;
	box-sizing: border-box;
	border: 1px solid #ccc;
}

.cell-button:hover {
	filter: brightness(0.8);
}

form {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

div {
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>
</head>
<body>
	${aroundPlanets[5][5].name}
	<br>
	<div style="display: flex; flex-wrap: wrap; width: 660px; align-items: center;">
		<c:forEach var="i" begin="0" end="10">
			<c:forEach var="j" begin="0" end="10">
				<div style="width: 60px; height: 60px; display: flex; align-items: center; justify-content: center;">
					<c:choose>
						<c:when test="${i==5&&j==5}">
							<form action="main" method="get">
								<button type="submit" name="cellValue" value="return" style="background-color: red" class="cell-button"></button>
							</form>
						</c:when>
						<c:when test="${aroundPlanets[i][j].name==\"no planet\"}">
							<form action="fromGalaxy" method="post">
								<input type="hidden" name="cellType" value="criate">
								<button type="submit" name="cellValue" value="no" style="background-color: white" class="cell-button"></button>
							</form>
						</c:when>
						<c:when test="${aroundPlanets[i][j].name!=\"no planet\"}">
							<form action="fromGalaxy" method="post">
								<input type="hidden" name="cellType" value="landing">
								<button type="submit" name="cellValue" value="${aroundPlanets[i][j].name}" style="background-color: blue" class="cell-button"></button>
							</form>
						</c:when>
					</c:choose>
				</div>
			</c:forEach>
		</c:forEach>
	</div>
</body>
</html>