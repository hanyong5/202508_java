<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div class="container mt-5">

	<div class="d-flex justify-content-between">
		<!-- <h3>내용보기</h3> -->
	</div>

	<div class="my-3">
		<h3 class="mb-3">${dataView.title}</h3>
		<h4 class="text-secondary">${dataView.writer}</h4>
		<hr />
		<p class="my-5">${dataView.content}</p>

		<div class="d-flex justify-content-end">
			<a href="./list" class="btn btn-primary btn-sm">글목록</a>
		</div>
	</div>


</div>

<%@ include file="include/footer.jsp"%>