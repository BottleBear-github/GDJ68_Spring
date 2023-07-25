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
		<h1 class="mb-3">Add Page</h1>
		
		<form class="col-md-4 ms-auto" action="./add" method="post">
			<div class="row g-3 align-items-center">
				<label for="bookName" class="col-form-label">상품명</label>
				<input type="text" class="form-control" id="bookName"  name="bookName" placeholder="상품명을 입력하세요"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
			</div>
			
			<div class="row g-3 align-items-center">
				<label for="bookContents" class="col-form-label">상세설명</label>
				<input type="text" class="form-control" id="bookContents"  name="bookContents" placeholder="상세설명을 입력하세요"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
			</div>
			
			<div class="row g-3 align-items-center">
				<label for="bookRate" class="col-form-label">이자율</label>
				<input type="text" class="form-control" id="bookRate"  name="bookRate" placeholder="이자율을 입력하세요"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
			</div>
		
			
			<p>
				판매가능<input type="radio" value="1" checked name ="bookSale"><br>
				판매중지<input type="radio" value="0" name ="bookSale"><br>
			</p>
			
			<p>
	<!-- 		
				<select>
					<option value="1">판매가능</option>
					<option value="0">판매중지</option>
				</select>
	-->
			</p>
			
			<button type="submit" class="btn btn-success mt-5 me-3">상품등록</button>
			<button type="reset" class="btn btn-success mt-5">다시입력</button>
			
			
		</form>
	</section>
</body>
</html>