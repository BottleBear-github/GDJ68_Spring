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
		<form>
				<h1>Subject : ${requestScope.dto.subject}</h1>
			<table class="table table-success table-sm">
				<thead>
					<tr>
						<td>번호</td><td>제목</td><td>이름</td><td>날짜</td><td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${requestScope.dto.num}</td>
						<td>${requestScope.dto.subject}</td>
						<td>${requestScope.dto.name}</td>
						<td>${requestScope.dto.createDate}</td>
						<td>${requestScope.dto.hit}</td>
					</tr>
				</tbody>
			</table>
			<table class="table table-success table-sm">
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td>${requestScope.dto.contents}</td>
				</tr>
			</table>
		</form>
		
		<c:forEach items="${dto.fileDTOs}" var="f">
					<img alt="" src="../resources/upload/${board}/${f.fileName}">
		</c:forEach>
		
		<form>
			<c:if test="${board ne 'notice'}">
			<a class="btn btn-outline-primary" for="btn-check-outlined" href="./reply?num=${dto.num}">답글</a>
			</c:if>
			
			<a class="btn btn-outline-primary" for="btn-check-outlined" href="./update?num=${dto.num}">수정</a>
			<a class="btn btn-outline-primary" for="btn-check-outlined" href="./delete?num=${dto.num}">삭제</a>
		</form>
</section>

</body>
</html>