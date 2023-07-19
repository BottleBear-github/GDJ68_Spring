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
		<h1 class="mb-3">Login Page</h1>
		<form class="col-md-4 ms-auto" method="post" action="./login.do">
		
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
			  </div>
			</div>
		
		
			<button type="submit" class="btn btn-success mt-5 me-3">로그인</button>
			<button type="button" class="btn btn-success mt-5">회원가입</button>
		</form>
	</section>
	
</body>
</html>