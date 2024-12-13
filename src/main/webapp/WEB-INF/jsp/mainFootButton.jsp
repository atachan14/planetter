<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="display: flex; justify-content: space-between; align-items: center;">
	<div style="text-align: left; flex: 1">${mainInfo.acName}(${mainInfo.acKeepDay})</div>
	<div style="text-align: center; flex: 2">
		<form action="main" method="post">
			<input type="hidden" name="formType" value="foot">
			<input type="submit" name="footButton" value="左を向く"> 
			<input type="submit" name="footButton" value="前に進む"> 
			<input type="submit" name="footButton" value="右を向く">
		</form>
	</div>
	<div style="text-align: right; flex: 1">
		<form action="main" method="post">
			<input type="hidden" name="formType" value="sdButton">
			<input type="submit" name="button" value="星屑を食べる">(${mainInfo.stomach})<br>
			<input type="submit" name="button" value="${mainCenter.sdButton}">(${mainInfo.stardust})
		</form>

	</div>
</div>
