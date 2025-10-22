<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div class="container bg-info">
	안녕하세요
	<ul>
		<c:forEach var="item" items="${lists }">
			<li>${item.id }/${item.title } /${item.writer } / ${item.content }</li>
		</c:forEach>
	</ul>
</div>

<%@ include file="include/footer.jsp"%>