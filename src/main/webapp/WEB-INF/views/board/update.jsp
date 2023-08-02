<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>

	<c:import url="../temp/bootStrap.jsp"></c:import>


</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container-fluid">
	
		<div class="row justify-content-center my-4">
			<h1 class="col-md-7 text-center">${board} Update Page</h1>
		</div>
		
		<div class="row justify-content-center my-4">
			<form class="col-md-7" action="./update" method="post" enctype="multipart/form-data">
				<div class="mb-3">
				  <label for="name" class="form-label">작성자</label>
				  <input type="text" name="name" readonly="readonly" value="${dto.name}" class="form-control" id="name">
				</div> 
				<input type="hidden" name="num" value="${dto.num}">
				
				<div class="mb-3">
				  <label for="subject" class="form-label">제목</label>
				  <input type="text" name="subject" class="form-control" id="subject" value="${dto.subject}" >
				</div>
		
				<div class="mb-3"> 
				  <label for="contents" class="form-label">내용</label>
				  <textarea name="contents" class="form-control" id="contents" <%-- value="${dto.contents}" --%> rows="7"></textarea>
				</div>
				
				<c:forEach items="${dto.fileDTOs}" var="f">
					<div id="fileList" class="my-5 input-group mb-3">
						
						<input type="file" class="form-control" id="photos" name="photos">

					</div>
				</c:forEach>
							
				<div class="mb-3">
					<button class="my btn btn-danger" type="submit">수정</button>
				</div>
			
			</form>
		</div>
	</div>
</body>
</html>