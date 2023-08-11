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
	    <!-- include summernote css/js-->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container-fluid">
	
		<div class="row justify-content-center my-4">
			<h1 class="col-md-7 text-center">${board} Add Page</h1>
		</div>
		
		<div class="row justify-content-center my-4">
			<form class="col-md-7" id="frm" action="./add" method="post" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${dto.num}">
				<div class="mb-3">
				  <label for="writer" class="form-label">작성자</label>
				  <input type="text" name="name" readonly value="${member.id}" class="form-control" id="writer">
				</div>
				
				<div class="mb-3">
				  <label for="subject" class="form-label">제목</label>
				  <input type="text" name="subject" class="form-control" id="subject" placeholder="제목 입력">
				</div>
		
				<div class="mb-3">
				  <label for="contents" class="form-label">내용</label>
				  <textarea name="contents" class="form-control" id="contents" placeholder="내용 입력" rows="7"></textarea>
				</div>
				
				<div id="fileList" class="my-5">
					<!-- <div class="input-group mb-3">
						<input type="file" class="form-control" id="photos" name="photos">			
					</div> -->
				</div>
				
				<div class="input-group mb-3">
					<button type="button" id="add">File추가</button>
				</div>

				<div class="mb-3" >
					<button class="my btn btn-danger" type="submit" id="btn">글쓰기</button>
				</div>
			
			</form>
		</div>
	</div>

	<script src="../resources/js/file.js"></script>
	<script>
		const btn = document.getElementById("btn");
		const subject = document.getElementById("subject");
		const frm = document.getElementById("frm");
		
		$("#contents").summernote({
			placeholder: '내용 입력',
	        tabsize: 2,
	        height: 100,
	        callbacks: {
	            onImageUpload: function(files) {
	           		alert('이미지 첨부');
	              	//이미지를 server로 전송하고
	              	//응답으로 이미지 경로와 파일명을 받아서
	              	//img 태그를 만들어서 src속성에 이미지경로를 넣는것
					let formData = new FormData(); // <form></form>이 만들어짐
					formData.append("files", files[0]);//<input type="file" name="files">

					$.ajax({
						type:'post',
						url:'setContentsImg',
						data:formData,
						enctype:'mulipart/form-data',
						cache:false,
						contenstType:false,
						processData:false,
						success:function(result){
							$("#contents").summernote('insertNode', result.trim());
						},
						error:function(){
							console.log('error');
						}
					});
	            },
				onMediaDelete:function(files){
					let path = $(files[0]).attr("src");  

					$.ajax({
						type:'post',
						url:'./setContentsImgDelete',
						path:path,
						success:function(result){
							console.log(result);

						},
						error:function(){
							console.log('error');
						}
					})
				}
			}
		})

		btn.addEventListener("click", function(){
			console.log(subject.value=="");
			console.log(subject.value.length == 0);
			if(subject.value==""){
				alert('제목은 필수 입니다.');
				subject.focus();
			}else {
				frm.submit();
			}
		});

	</script>
</body>
</html>