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
	<form action="./update" method="post">
		번호<input type="text" readonly="readonly" name="noticeNo" value="${dto.noticeNo}">
		제목<input type="text" name="noticeSubject" value="${dto.noticeSubject}"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
		내용<textarea rows="" cols="" name="noticeContents">${dto.noticeContents}</textarea>
		
		
		<button type="submit">수정</button>
		<button type="reset">다시입력</button>
		
		
		
	</form>
</body>
</html>