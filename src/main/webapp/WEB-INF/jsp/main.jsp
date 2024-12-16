<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planetter</title>
<style>
/* ページ全体の背景色とフォント色 */
body {
	background-color: ${mainInfo.backGroundColor}; /* 背景色 */
	color: white; /* フォント色 */
}

.side-button {
	height: 50px;
	font-size: 14px;
	background-color: #f0f0f0;
	border-radius: 8px;
}
</style>
</head>
<body>
	<div style="display: flex;">
		<div style="width: 90%">${mainInfo.plName}</div>
		<div style="width: 10%;">
			<a href="logout">ログアウト</a>
		</div>
	</div>
	<div style="display: flex; align-items: center;">
		<div style="width: 85%; height: 600px;">
			<table style="font-size: 12px; width: 100%; height: 100%;">
				<tr style="height: 5%">
					<td style="text-align: center; width: 10%; color:${mainInfo.v7InfoColor}">[${mainInfo.v7Info}]</td>
					<td style="text-align: center; width: 80%; color:${mainInfo.v8InfoColor}">【${mainInfo.v8Info}】</td>
					<td style="text-align: center; width: 10%; color:${mainInfo.v9InfoColor}">[${mainInfo.v9Info}]</td>
				</tr>
				<tr style="height: 85%">
					<td style="text-align: center; color:${mainInfo.v4InfoColor}">[${mainInfo.v4Info}]</td>
					<td style="text-align: center;"><jsp:include page="${mainCenter.jsp}" /></td>
					<td style="text-align: center; color:${mainInfo.v6InfoColor}">[${mainInfo.v6Info}]</td>
				</tr>
				<tr style="height: 10%">
					<td colspan="3"><jsp:include page="mainFootButton.jsp" /></td>
				</tr>
			</table>
		</div>
		<div style="width: 15%; height: 600px;"><jsp:include page="mainSide.jsp" /></div>
	</div>




</body>
</html>