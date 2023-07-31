<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	
	<section class="container mt-5">
		<h1 class="mb-3 text-center">Detail Page</h1>

		<table class="table table-success table-sm">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">	
			<thead>
				<th>상품번호</th><th>상품명</th><th>상세설명</th><th>이자율</th><th>판매여부</th>
			</thead>
			<tbody>
			
				<h1>${requestScope.dto.bookName}</h1>
			
			<div>
			
				</div>
				
				<h1>${dto.bookName}</h1>
				
				<c:choose>
					<c:when test="${dto.bookSale eq 1}">
						<h1>판매중</h1>
					</c:when>
					<c:otherwise>
						<h1>판매종료</h1>
					</c:otherwise>
				</c:choose>
				
				<c:forEach items="${dto.fileDTOs}" var="f">
					<img alt="" src="../resources/upload/bankbook/${f.fileName}">
				</c:forEach>
				
				<a href="./update?bookNum=${dto.bookNum}">수정</a>
				<a href="./delete?bookNum=${dto.bookNum}">삭제</a>
			</tbody>

</table>
</section>

</body>
</html>