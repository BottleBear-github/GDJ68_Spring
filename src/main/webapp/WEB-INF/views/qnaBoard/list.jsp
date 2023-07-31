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
		<h1 class="mb-3 text-center">QNA List</h1>
		
		<table class="table table-success table-sm">
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
			<thead>
				<th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="d" varStatus="i"> 
					<tr>
						<td>${d.qnaNum}</td>
						<td>${d.qnaSubject}</td>
						<td>${d.qnaName}</td>
						<td>${d.qnaDate}</td>
						<td>${d.qnaHit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			  <c:if test="${pager.pre}">
				    <li class="page-item">
				      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    	<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			    </c:forEach>
			    <c:if test="${pager.next}">
				    <li class="page-item">
				      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				</c:if>
			  </ul>
			</nav>
			
			<div class="input-group mb-3">
			 <form action="./list" method="get">
				  <select name="kind" class="form-select" aria-label="Default select example">
					  <option value="name">Name</option>
					  <option value="contents">Contents</option>
				  </select>
				  <input type="text" name="search" class="form-control" aria-label="Amount (to the nearest dollar)">
				   <div class="col-auto">
				    <button type="submit" class="btn btn-primary">검색</button>
				  </div>
			  </form>
			</div>
		
		
		<a class="btn btn-outline-primary" for="btn-check-outlined" href="./add">글쓰기</a>
		
	
	</section>
		
		
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>