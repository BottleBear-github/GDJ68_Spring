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
				<h1>Subject : ${requestScope.dto.noticeSubject}</h1>
			<table class="table table-success table-sm">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">	
				<thead>
					<tr>
						<td>번호</td><td>제목</td><td>이름</td><td>날짜</td><td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${requestScope.dto.noticeNo}</td>
						<td>${requestScope.dto.noticeSubject}</td>
						<td>${requestScope.dto.noticeName}</td>
						<td>${requestScope.dto.noticeDate}</td>
						<td>${requestScope.dto.noticeHit}</td>
					</tr>
				</tbody>
			</table>
			<table class="table table-success table-sm">
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td>${requestScope.dto.noticeContents}</td>
				</tr>
			</table>
		</form>
		
		<form>
			<a class="btn btn-outline-primary" for="btn-check-outlined" href="./update?noticeNo=${dto.noticeNo}">수정</a>
			<a class="btn btn-outline-primary" for="btn-check-outlined" href="./delete?noticeNo=${dto.noticeNo}">삭제</a>
		</form>
</section>

</body>
</html>