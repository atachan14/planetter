<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<div style="display: flex; flex-direction: column; height: 500px;">
	<div style="flex: 5; overflow: auto; display: flex; flex-direction: column; justify-content: center;">
		<c:forEach var="tweet" items="${mainCenter.data.tweetList}">
			<div style="font-size: 18px;">${tweet.value}</div>
			<div style="text-align: right; font-size: 14px; color: gray;">${tweet.criater}${tweet.date}</div>
		</c:forEach>
	</div>
	<div style="flex: 1; text-align: right; font-size: 16px; color: red; align-items: flex-end;">
		<span style="color: orange; margin-right: 50px;">${mainCenter.data.name}</span>${mainCenter.data.criater}${mainCenter.data.date}</div>
</div>