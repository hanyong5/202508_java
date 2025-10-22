<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div class="container mt-5">

	<div class="d-flex justify-content-between">
		<h3>게시판 리스트</h3>
		<div>게시물갯수 :${count }</div>
	</div>


	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">TITLE</th>
				<th scope="col">WRITER</th>
				<th scope="col">DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${lists }">
				<tr>
					<th scope="row">${item.id }</th>
					<td><a href="view?id=${item.id}" class="nav-link">${item.title }</a></td>
					<td>${item.writer }</td>
					<td><a href="#" class="btn btn-danger btn-sm">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<%@ include file="include/footer.jsp"%>