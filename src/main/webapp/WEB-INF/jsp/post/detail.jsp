<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<div class="d-flex justify-content-center">
	<div class="w-50">
		<h1>글 상세 / 수정</h1>
		<div class="d-flex">
			<%-- 이미지가 있는 경우에만 노출 --%>
			<c:if test="${not empty post.imagePath}">
			<div class="image-area mb-3 mx-3">
				<img src="${post.imagePath }" alt="" width="400">
				<div class="d-flex justify-content-end my-4">
					<input type="file" id="file" accept=".jpg,.png,.gif,.jpeg">
				</div>
			</div>
			</c:if>
			<div>
				<input type="text" id="title" class="form-control" placeholder="제목을 입력하세요" value="${post.title}">
				<textarea id="content" class="form-control" placeholder="내용을 입력하세요" rows="15">${post.content }</textarea>
			
				
				<div class="d-flex my-4">
					<div class="d-flex justify-content-between">
						<a href="/user/my_page_view" id="postListBtn" class="btn btn-secondary">목록</a>
						<button type="button" id="saveBtn" class="btn btn-success" data-post-id="${post.id}">저장</button>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</div>
<script>
$(document).ready(function(){
	//저장 버튼
	$('#saveBtn').on('click', function(e){
		//validation
		let title = $('#title').val().trim();
		if(title == ""){
			alert('제목을 입력하세요');
			return;
		}
		
		let content = $('#content').val().trim();
		if(content == ""){
			alert('내용을 입력하세요');
			return;
		}
		
		// 이미지 확장자 검증 - 파일이 업로드 된 경우
		let file = $('#file').val(); // 파일 경로만 가져온다
		console.log(file);	// C:\fakepath\화면 캡처 2022-06-09 155410.png
		if(file != ""){
			let ext = file.split(".").pop().toLowerCase(); // pop( ) = 배열의 가장 마지막 값을 뽑아주는 메서드 , toLowerCase() = 소문자로 변경
			//alert(ext);
			if($.inArray(ext, ["gif", "jpeg", "jpg", "png"]) == -1){
				alert("gif, jpeg, jpg, png 파일만 업로드 할 수 있습니다");
				$('#file').val(""); //파일을 비운다.
				return;
			}
		}
		
		let postId = $(this).data("post-id");
		//alert(postId);
		
		// form 객체 생성
		// form태그를 자바스크립트에서 만든다	.
		let formData = new FormData();
		formData.append("postId", postId);
		formData.append("title", title);	//<input type ="" name="subject"> 를 만들고 name 값을 보낸다
		formData.append("content", content);
		formData.append("file", $('#file')[0].files[0]);	// String으로 만들어주는 과정 $('#file')[0] : 첫번째 input file 태그, files[0]: 업로드 된 것 중에 첫번째 파일
		
		//ajax form 데이터 전송
		$.ajax({
			
			//request
			type : "PUT"
			, url : "/post/update"
			, data : formData
			, encType : "multipart/form-data"	// 파일 업로드 필수 설정
			, processData : false	//파일 업로드 필수 설정 ({"":""} 형태로 자동 변환 x)
			, contentType : false	//파일 업로드 필수 설정
		
			//response
			, success : function(data){
				if(data.result == "success"){
					alert('수정되었습니다');
					//location.reload(true);
					location.href = "/timeline/timeline_view";
				} else {
					alert(data.errorMessage);
				}
			}
			, error : function(e){
				alert("메모 저장에 실패했습니다");
			}
		});
	});
});
</script>	
	