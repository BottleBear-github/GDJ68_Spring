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
			
			<thead>
				<th>상품명</th><th>이자율</th>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="d" varStatus="i"> 
				<!-- 스코프명은 생략가능/items의 ArrayList에서 꺼내서 d에 넣어줌 d는 BankBookDTO타입-->
				<!-- ArrayList에는 BankBookDTO타입이 들어있기 때문에 -->
					<tr>
						<td><a href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
						<td>${d.bookRate}</td>
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
			
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			  
				    <li class="page-item ${pager.pre?'':'disabled'}">
				      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
			    </c:forEach>
			  
				    <li class="page-item ${pager.next?'':'disabled'}">
				      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				
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
		
		<a class="btn btn-outline-primary" for="btn-check-outlined" href="./add">상품등록</a>
		
		<%-- 
		<c:forEach begin="1" end="10" step="2" var="num">
			<h1>${num}</h1>
		</c:forEach>
		 --%>
	</section>
		

</body>
</html>