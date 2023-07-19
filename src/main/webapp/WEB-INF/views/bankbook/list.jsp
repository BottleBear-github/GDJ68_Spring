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
		<h1 class="mb-3 text-center">BankBook List</h1>
		
		<table class="table table-success table-sm">
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
			<thead>
				<th>상품명</th><th>이자율</th>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="d" varStatus="i"> 
				<!-- 스코프명은 생략가능/items의 ArrayList에서 꺼내서 d에 넣어줌 d는 BankBookDTO타입-->
				<!-- ArrayList에는 BankBookDTO타입이 들어있기 때문에 -->
					<tr>
						<td><a href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
						<td>${d.bookRate} ${i.index}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="btn btn-outline-primary" for="btn-check-outlined" href="./add">상품등록</a>
		
		<%-- 
		<c:forEach begin="1" end="10" step="2" var="num">
			<h1>${num}</h1>
		</c:forEach>
		 --%>
	</section>
		
		
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>