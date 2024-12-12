<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Planetter</title>
</head>
<body>
	${mainInfo.plName}
	<div style="display: flex; align-items: center;">
		<div style="background: lightblue; width: 85%; height: 600px;">
			<table style="width: 100%; height: 100%;">
				<tr style="height: 5%">
					<td style="text-align: center; width: 10%;">${mainInfo.v7Info}</td>
					<td style="text-align: center; width: 80%;">${mainInfo.v8Info}</td>
					<td style="text-align: center; width: 10%;">${mainInfo.v9Info}</td>
				</tr>
				<tr style="height: 85%">
					<td style="text-align: center;">${mainInfo.v4Info}</td>
					<td style="overflow: auto; text-align: center;"><jsp:include page="mainNowInfo.jsp" /></td>
					<td style="text-align: center;">${mainInfo.v6Info}</td>
				</tr>
				<tr style="height: 10%">
					<td colspan="3"><jsp:include page="mainFootButton.jsp" /></td>
				</tr>
			</table>
		</div>
		<div style="background: lightcoral; width: 15%; height: 600px;"><jsp:include page="mainSide.jsp" /></div>
	</div>


</body>
</html>