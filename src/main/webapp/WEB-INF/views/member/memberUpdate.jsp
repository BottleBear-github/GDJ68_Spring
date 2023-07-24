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
		<h1 class="mb-3">Update Page</h1>
		<form class="col-md-4 ms-auto" method="post" action="./memberUpdate">
		
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="pw" class="col-form-label">Password</label>
			    <input type="password" name="pw" id="pw" value="${member.pw}" class="form-control" aria-labelledby="passwordHelpInline">
			    <span id="passwordHelpInline" class="form-text">
			      8자 이상 20자 미만 까지 입력
			    </span>
			  </div>
			</div>
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="name" class="col-form-label">이름</label>
			    <input type="text" name="name" id="name" value="${member.name}" class="form-control">
			  </div>
			</div>
			
			<div class="row g-3 align-items-center">
				<div class="col-auto">
				  <label for="email" class="form-label">Email</label>
				  <input type="email" name="email" value="${member.email}" class="form-control" id="email">
				</div>
			</div>
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="birth" class="col-form-label">생년월일</label>
			    <input type="date" name="birth" id="birth" value="${member.birth}" class="form-control" >
			  </div>
			</div>
		
			<button type="submit" class="btn btn-success mt-5 me-3">수정</button>
			<button type="reset" class="btn btn-success mt-5">다시입력</button>
		</form>
	</section>
</body>
</html>