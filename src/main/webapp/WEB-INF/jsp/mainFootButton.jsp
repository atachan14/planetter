<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="display: flex; justify-content: space-between; align-items: center;">
	<div style="text-align: left; flex: 1">${mainInfo.acName}(${mainInfo.acKeepDay}, おなか:${mainInfo.stomach})
		<form action="main" method="post">
			<input type="hidden" name="formType" value="left"> 
			<input type="submit" name="button" value="星屑を食べる">
		</form>
	</div>
	<div style="text-align: center; flex: 1">
		<form action="main" method="post">
			<input type="hidden" name="formType" value="center"> 
			<input type="submit" name="footButton" value="左を向く"> 
			<input type="submit" name="footButton" value="${mainInfo.centerButton}"> 
			<input type="submit" name="footButton" value="右を向く">
		</form>
	</div>
	<div style="text-align: right; flex: 1">
		<form action="main" method="post">
			<input type="hidden" name="formType" value="right"> 
<!--			<input type="hidden" name="pageId" value="--"> あとで実装-->
			<input type="text" name="value"  placeholder="${mainCenter.placeholder}"><br> 
			<input type="submit" name="button" value="${mainCenter.sdButton}">(:${mainInfo.stardust})
		</form>

	</div>
</div>
