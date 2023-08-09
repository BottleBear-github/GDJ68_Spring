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
		<h1 class="mb-3">상품가입 Page</h1>
		<form class="col-md-4 ms-auto" method="post" action="./add" id="frm">
			<input type="hidden" name="bookNum" value="${dto.bookNum}">
		
			<div class="row g-3 align-items-center col-auto">
			    <label for="pw" class="col-form-label">Password</label>
			    <input type="password" name="accountPassword" id="pw" class="form-control" aria-labelledby="passwordHelpInline" placeholder="PW를 입력하세요">
			</div>
		
		
			<button type="submit" it="btn" class="btn btn-success mt-5 me-3">가입</button>
		</form>
	</section>
	<script type="text/javascript">
		const btn = document.getElementById("btn");
		const pw = document.getElementById("pw");
		const frm = document.getElementById("frm");
		
		btn.addEventListener("click", funtion(){
			if(pw.value.length==4 && Number.isInteger(pw.value*1)){
				frm.submit();
			}else {
				alert("비번 4글자로 작성 또는 숫자로만 작성")
			}
		})
	</script>
</body>
</html>