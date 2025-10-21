<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="dto" items="${lists }">
<div> ${dto.id } / ${dto.writer } / ${dto.title } / ${dto.content }</div>
</c:forEach>

</body>
</html>