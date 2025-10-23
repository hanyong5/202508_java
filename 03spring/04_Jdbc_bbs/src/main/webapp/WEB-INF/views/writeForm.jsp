<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div class="container mt-5">

	<div class="d-flex justify-content-between">
		<h3>글작성하기</h3>
	</div>

	<div class="my-3">
		<form action="write" method="get" onsubmit="return validForm()">
			<div class="mb-3">
				<label for="name" class="form-label">작성자</label>
				<input type="text" name="writer" id="name" class="form-control" required />
			</div>
			<div class="mb-3">
				<label for="title" class="form-label">제목</label>
				<input type="text" name="title" id="title" class="form-control" required />
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">글내용</label>
				<textarea rows="10" class="form-control" name="content" required></textarea>
				
				
			</div>
			<div class="text-end">
				<button type="submit" class="btn btn-primary">글작성완료</button>
			</div>

		</form>
	</div>
	


</div>

<script>
function validForm(){
	
	
	return true;
}


</script>



<%@ include file="include/footer.jsp"%>