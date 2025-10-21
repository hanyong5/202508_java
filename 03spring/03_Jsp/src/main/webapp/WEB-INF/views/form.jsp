<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/include_header.jsp" %>



<div class="container">
	<form action="view1" method="get" style="display:flex;flex-direction:column;gap:10px">
		<input type="text" name="name" class="form-control"  placeholder="이름"/>
		<input type="text" name="age"  class="form-control" placeholder="나이"/>
		<input type="text" name="addr"  class="form-control" placeholder="주소"/>
		<button type="submit" class="btn btn-primary">전송</button>
	</form>
</div>

<%@ include file="include/include_footer.jsp" %>