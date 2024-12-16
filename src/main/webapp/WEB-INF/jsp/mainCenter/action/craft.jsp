<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div style="display: flex; flex-direction: column; height: 400px;">
	<form action="craft" method="post" style="display: flex; flex-direction: column; height: 100%;">
		<!-- ぷらねっとアップグレードリスト～～の部分 -->
		くらふとリスト<br>

		<!-- 上寄せ左寄せでボタンを並べる部分 -->
		<div style="display: flex; flex-wrap: wrap; justify-content: flex-start; align-items: center;">
			<c:forEach var="cr" begin="0" items="${mainCenter.data}">
				<input type="submit" name="button" value="${cr.crName}" class="side-button" style="margin-left: 2%; font-size: 15px;">(${cr.sd})
			</c:forEach>
		</div>

		<!-- 下寄せ真ん中でディスティニードローのボタンを並べる部分 -->
		<div style="display: flex; justify-content: center; margin-top: auto;">
			<input type="submit" name="button" value="ディスティニーフロー" class="side-button" style="font-size: 16px;"> (10000sd) <input type="submit" name="button" value="ハイパーディスティニーフロー" class="side-button" style="font-size: 16px; margin-left: 5%;"> (40000sd)
		</div>
	</form>
</div>
