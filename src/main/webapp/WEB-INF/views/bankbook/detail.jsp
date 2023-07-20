<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>

		<!-- 표현식 -->
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫 번째 글자를 소문자로 바꾼 것 -->
	<!-- Setter 이름 : 메서드에서 set을 제외하고 첫 번째 글자를 소문자로 바꾼 것 -->
	<!-- requestScope 자동형변환(생략가능).dto.여기 들어가는 bookName는 원래 getBookName 이지만 위에로 인해  -->
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
	
	<a href="./update?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete?bookNum=${dto.bookNum}">삭제</a>
<%-- 
	<c:if test="${dto.bookSale eq 1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0}">
		<h1>판매종료</h1>
	</c:if>
--%>
</body>
</html>