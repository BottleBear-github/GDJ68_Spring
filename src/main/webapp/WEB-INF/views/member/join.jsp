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
		<h1 class="mb-3">Join Page</h1>
		<form class="col-md-4 ms-auto" method="post" action="./join.do">
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="id" class="col-form-label">ID</label>
			    <input type="text" name="id" id="id" class="form-control" placeholder="ID를 입력하세요">
			  </div>
			</div>
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="pw" class="col-form-label">Password</label>
			    <input type="password" name="pw" id="pw" class="form-control" aria-labelledby="passwordHelpInline" placeholder="PW를 입력하세요">
			    <span id="passwordHelpInline" class="form-text">
			      8자 이상 20자 미만 까지 입력
			    </span>
			  </div>
			</div>
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="name" class="col-form-label">이름</label>
			    <input type="text" name="name" id="name" class="form-control" placeholder="이름을 입력하세요">
			  </div>
			</div>
			
			<div class="row g-3 align-items-center">
				<div class="col-auto">
				  <label for="email" class="form-label">Email</label>
				  <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
				</div>
			</div>
		
			<div class="row g-3 align-items-center">
			  <div class="col-auto">
			    <label for="birth" class="col-form-label">생년월일</label>
			    <input type="date" name="birth" id="birth" class="form-control" >
			  </div>
			</div>
		
			<button type="submit" class="btn btn-success mt-5 me-3">회원가입</button>
			<button type="reset" class="btn btn-success mt-5">다시입력</button>
		</form>
	</section>
</body>
</html>