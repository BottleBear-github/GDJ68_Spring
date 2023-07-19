<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	<form action="./update.do" method="post">
		<input type="text" readonly="readonly" name="bookNum" value="${dto.bookNum}">
		상품명<input type="text" name="bookName" value="${dto.bookName}"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
		상세설명<textarea rows="" cols="" name="bookContents">${dto.bookContents}</textarea>
		이자율<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		
		
		<p>
			판매가능<input type="radio" value="1" checked name ="bookSale"><br>
			판매중지<input type="radio" value="0" name ="bookSale"><br>
		</p>

		
		<button type="submit">수정</button>
		<input type="submit" value="수정">
		<input type="reset" value="수정">
		<input type="button" value="수정">
		
		
	</form>
</body>
</html>