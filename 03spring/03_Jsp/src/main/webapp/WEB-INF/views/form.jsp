<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.8/css/bootstrap.min.css" integrity="sha512-2bBQCjcnw658Lho4nlXJcc6WkV/UxpE/sAokbXPxQNGqmNdQrWqtw26Ns9kFF/yG792pKR1Sx8/Y1Lf1XN4GKA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="view1" method="get" style="display:flex;flex-direction:column;gap:10px">
		<input type="text" name="name" class="form-control"  placeholder="이름"/>
		<input type="text" name="age"  class="form-control" placeholder="나이"/>
		<input type="text" name="addr"  class="form-control" placeholder="주소"/>
		<button type="submit" class="btn btn-primary">전송</button>
	</form>
</div>
</body>
</html>