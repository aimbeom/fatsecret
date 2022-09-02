<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="wrap w-50 container" style="border: 3px solid">
	<div class="box1 w-100">
		<div class="d-flex justify-content-between">
			<div class="d-flex">
				<div class="imgInfo m-3">
					<c:choose>
						<c:when test="${user.imagePath != null }">
							<input type="file" id="file" class="d-none" accept=".gif,.jpg,.png,.jpeg">
							<a href="#" class="more-btn" data-toggle="modal" data-target="#moreModal" data-image-path="${user.imagePath }" data-user-id="${user.id}"> 
								<img src="${user.imagePath }" width="250px" height="250px">
							</a>
						</c:when>
						<c:otherwise>
							<input type="file" id="file" class="d-none" accept=".gif,.jpg,.png,.jpeg">
							<a href="#" class="more-btn" data-toggle="modal" data-target="#moreModal" data-user-id="${user.id}"> 
								<img src="https://cnucc.jbnu.ac.kr/korean/system/concert/image/noimage02.gif" width="250px" height="250px">
							</a>
						</c:otherwise>
					</c:choose>
					<div>
						<div class="d-flex justify-content-center">
							<span style="color: black">${user.nickname}</span>

						</div>
						<div class="d-flex justify-content-center">
							<span style="color: black">${user.email}</span>
						</div>
						<div>
							<a class="btn btn-success form-control"
									href="/user/my_weight_update_view">바이오 업데이트 </a>
							<a class="btn btn-success mt-2 form-control d-none"
							 id="myImageUpdateBtn" data-user-id="${userId }" href="#">이미지 변경하기 </a>
						</div>
					</div>
				</div>
			</div>
			<div class="info m-4 w-100">
				<div class="d-flex justify-content-between mx-5">
					<span style="font-size: 20px">이름 :</span> <span
						style="font-size: 20px">${user.name }</span>
				</div>
				<div class="d-flex justify-content-between m-5">
					<span style="font-size: 20px">신장 :</span> <span
						style="font-size: 20px">${user.height }cm</span>
				</div>
				<div class="d-flex justify-content-between m-5">
					<span style="font-size: 20px">생년월일 :</span> <span
						style="font-size: 20px">${user.birth }</span>
				</div>
				<div class="d-flex justify-content-between m-5">
					<span style="font-size: 20px">목표 :</span> <span
						style="font-size: 20px">${user.purpose }</span>
				</div>
				<div class="d-flex justify-content-center m-5">
					<span style="font-size: 15px">${user.content }</span>
				</div>
			</div>
		</div>
		<div class="box-2 w-100 mr-3 bg-success">
			<div class="d-flex justify-content-between m-3">
				<span style="font-size: 30px">시작 체중</span> <span
					style="font-size: 30px">현재 체중</span> <span style="font-size: 30px">목표
					체중</span>
			</div>
			<div class="d-flex justify-content-between mx-5">
				<span style="font-size: 30px">${user.startWeight}kg</span> <span
					style="font-size: 30px">${user.weight}kg</span> <span
					style="font-size: 30px">${userTargetWeight}kg</span>
			</div>
			<div class="d-flex justify-content-between m-3">
				<span style="font-size: 30px">감소한 양</span> <span
					style="font-size: 30px">남은 양</span>
			</div>
			<div class="d-flex justify-content-between mx-5">
			<c:choose>	
				<c:when test="${(user.weight) - user.startWeight > 0}">
					<span style="font-size: 30px">+${(user.weight) - user.startWeight}kg</span>
				</c:when>
				<c:otherwise>
					<span style="font-size: 30px">${(user.weight) - user.startWeight}kg</span>
				</c:otherwise>
			</c:choose>	
				<span style="font-size: 30px">${userTargetWeight - (user.weight)}kg</span>
			</div>
		</div>
		<div class="d-flex justify-content-center m-3">
			<div class="w-100">
				<h1>글 목록</h1>
				<table class="table hover">
					<thead>
						<tr>
							<th>No.</th>
							<th>제목</th>
							<th>작성날짜</th>
							<th>수정날짜</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${postList}" var="post">
							<tr>
								<td>${post.id}</td>
								<td>${post.title}</a></td>
								<td><fmt:formatDate value="${post.createdAt}"
										pattern="yyyy년 MM월 dd일" /></td>
								<td><fmt:formatDate value="${post.updatedAt}"
										pattern="yyyy년 MM월 dd일" /></td>
								<td><a class="btn btn-success"
									href="/post/detail_view?postId=${post.id}">수정</a></td>
								<td><button class="btn btn-danger delBtn"
										data-post-id="${post.id }">삭제</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 이미지 삭제/수정 Modal -->
<div class="modal fade" data-backdrop="static" id="moreModal">
	<div class="modal-dialog modal-sm modal-dialog-centered">
		<div class="modal-content">
			<%-- modal 창 안에 내용 넣기 --%>
			<c:if test="${user.imagePath != null }">
			<div class="text-center p-3">
				<%-- d-block: 클릭할 수 있는 영역을 넓히기 위해 --%>
				<a href="#" class="del-image d-block">삭제하기</a>
			</div>
			</c:if>
		 	<div class="text-center p-3 border-top">
				<!-- data-dismiss: 모달창 닫힘 -->
				<a href="" class="update-image d-block">수정하기</a>
			</div> 
			<div class="text-center p-3 border-top">
				<!-- data-dismiss: 모달창 닫힘 -->
				<a href="" class="update-cancel d-block" data-dimiss="modal">취소하기</a>
			</div> 
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('.delBtn').on('click', function() {

			let postId = $(this).data('post-id');
			alert(postId);

			$.ajax({
				//request
				type : "delete",
				url : "/post/delete",
				data : {
					"postId" : postId
				}

				//response
				,
				success : function(e) {
					if (data.result == "success") {
						alert('삭제 성공');
						location.reload(true);
					} else {
						alert(data.errorMessage);
					}
				},
				error : function(e) {
					alert('에러');
				}
			});
		});
		
		// ... 더보기 버튼 클릭시, 모달에 삭제될 글 번호를 넣어준다.
		$('.more-btn').on('click', function(e) {
			e.preventDefault();

			let id = $(this).data('user-id'); // get
			
			//alert(postId);

			// 모달에 삭제될 글 번호를 넣어준다.(모달은 재활용 되기 때문에)
			$('#moreModal').data('user-id', id); // set	태그: data-post-id="2"
		});

		// 모달창 안에 있는 삭제하기 버튼 클릭했을 때
		$('#moreModal .del-image').on('click', function(e) {
			e.preventDefault(); //a 태그 기본 동작 중단(위로 올라가는 현상 방지)

			let id = $('#moreModal').data('user-id');
			
			//alert(postId);

			// ajax
			$.ajax({
				//request
				type : "post",
				url : "/user/delete_my_image",
				data : {
					"id" : id
				}
				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert("성공");
						location.reload(true);
					} else {
						alert(data.errorMessage);
					}
				},
				error : function(e) {
					alert('삭제하는데 실패했습니다');
				}
			});

		});
		
		// 사진 클릭시, 모달에 수정할 유저의 번호를 넣어준다.
		$('.more-btn').on('click', function(e) {
			e.preventDefault();

			let id = $(this).data('user-id'); // get
			//alert(id);

			// 모달에 유저의 번호를 넣어준다.(모달은 재활용 되기 때문에)
			$('#moreModal').data('user-id', id); // set	태그: data-post-id="2"
		});
		
	 	// 모달창 안에 있는 수정하기 버튼 클릭했을 때
		$('#moreModal .update-image').on('click', function(e) {
			e.preventDefault(); //a 태그 기본 동작 중단(위로 올라가는 현상 방지)
			
			
			$('#file').click();
			$('#myImageUpdateBtn').removeClass('d-none');
		}); 
	 	
		// 파일 업로드를 했을 때, 확장자 이름 노출, 파일 확장자 검증
		$('#file').on('change', function(e) {
			let fileName = e.target.files[0].name;

			let arr = fileName.split(".");

			//확장자 검증
			if (arr.length < 2 || arr[arr.length - 1] != 'gif'
				&& arr[arr.length - 1] != 'jpeg'
				&& arr[arr.length - 1] != 'jpg'
				&& arr[arr.length - 1] != 'png') {
				alert('이미지 파일만 업로드 할 수 있습니다');
				$(this).val(""); //파일을 비운다
				$('#fileName').text(""); //파일 이름도 비워줌.
					return;
				}
			
			$('.modal').modal('hide');	
			//임시파일 명 노출
			$('#fileName').text(fileName);
			
			
			
		});
		
		//사진 수정하기
		$('#myImageUpdateBtn').on('click', function(e) {
			let id = $('#moreModal').data('user-id');
			
			let formData = new FormData();
			formData.append("id", id);
			formData.append("file", $('#file')[0].files[0]);
			
			//ajax form 데이터 전송
			$.ajax({

				//request
				type : "post",
				url : "/user/my_image_update",
				data : formData,
				encType : "multipart/form-data" // 파일 업로드 필수 설정
				,
				processData : false //파일 업로드 필수 설정 ({"":""} 형태로 자동 변환 x)
				,
				contentType : false //파일 업로드 필수 설정

				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert('사진이 변경되었습니다');
						$('#myImageUpdateBtn').addClass('d-none');
						location.reload(true);
					} else {
						alert(data.errorMessage);
					}
				}
				,
				error : function(e) {
					alert("에러 발생");
				}
			});
		});
		
	 	// 모달창 안에 있는 취소하기 버튼 클릭했을 때
		$('#moreModal .update-cancel').on('click', function(e) {
			e.preventDefault(); //a 태그 기본 동작 중단(위로 올라가는 현상 방지)
			
			$('#myImageUpdateBtn').addClass('d-none');
			$('.modal').modal('hide');
		}); 
	});
</script>