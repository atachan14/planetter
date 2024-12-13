<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="main" method="post">
<input type="hidden" name="formType" value="foot">
	<div
		style="display: flex; justify-content: space-between; align-items: center;">
		<div style="text-align: left; flex: 1">${mainInfo.acName}</div>
		<div style="text-align: center; flex: 2">
			<input type="submit" name="footButton" value="左を向く"> <input
				type="submit" name="footButton" value="前に進む"> <input
				type="submit" name="footButton" value="右を向く">
		</div>
		<div style="text-align: right; flex: 1"><span style="margin-right: 10px;">おなか:${mainInfo.stomach}</span>
			<span style="margin-right: 10px;">星屑:${mainInfo.stardust}</span></div>
	</div>
</form>