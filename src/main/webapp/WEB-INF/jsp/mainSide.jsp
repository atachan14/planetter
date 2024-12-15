<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 100%; position: relative;">
	<div style="margin-top: 30%; text-align: center;">
		<form action="galaxy" method="post">
			<input type="hidden" name="plName" value="${mainInfo.plName}">
			<input type="submit" name="button" value="小型ロケット" class="side-button"><br>
			<input type="submit" name="button" value="アップグレード" class="side-button" style="margin-top: 10%"><br>
		</form>
		<form action="mainSide" method="post">
			<input type="submit" name="button" value="分解する" class="side-button" style="margin-top: 40%"><br> 
			<input type="submit" name="button" value="クラフト" class="side-button" style="margin-top: 10%"><br>
		</form>
	</div>
	<div style="position: absolute; bottom: 10%; width: 100%; text-align: center;">
		<form action="mainSide" method="post">
			<input type="submit" name="button" value="星屑を重ねる" class="side-button" style="margin-top: 20%"><br> 
			<input type="submit" name="button" value="表紙を付ける" class="side-button" style="margin-top: 10%"><br>
		</form>
	</div>
</div>