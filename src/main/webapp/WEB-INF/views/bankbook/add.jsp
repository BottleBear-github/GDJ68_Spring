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

	<section>
		<h1>Add Page</h1>
		
		<form action="./add" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">상품명</label>
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="bookName"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
				상세설명<textarea rows="" cols="" name="bookContents"></textarea>
				이자율<input type="text" name="bookRate"><br>
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
			
			<button type="submit" class="btn btn-primary">등록</button>
			<input type="submit" value="ADD">
			<input type="reset" value="RESRT">
			<input type="button" value="BUTTON">
			
			
		</form>
	</section>
</body>
</html>