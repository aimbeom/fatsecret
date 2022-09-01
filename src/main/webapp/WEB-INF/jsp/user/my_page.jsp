<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="wrap w-50 container" style="border: 3px solid">
	<div class="box1 w-100">
		<div class="d-flex justify-content-between">
			<div class="d-flex">
				<div class="imgInfo m-3">
					<img src="${userImage }" width="250px" height="250px">
					<div>
						<div class="d-flex justify-content-center">
							<span style="color: black">${userNickname}</span>

						</div>
						<div class="d-flex justify-content-center">
							<span style="color: black">${userEmail}</span>
						</div>
						<div>
							<a class="btn btn-success form-control"
								href="/user/my_weight_update_view">바이오 업데이트 </a>
						</div>
					</div>
				</div>
			</div>
			<div class="info m-4 w-100">
				<div class="d-flex justify-content-between mx-5">
					<span style="font-size: 20px">이름 :</span> <span
						style="font-size: 20px">${userName }</span>
				</div>
				<div class="d-flex justify-content-between m-5">
					<span style="font-size: 20px">신장 :</span> <span
						style="font-size: 20px">${userHeight }cm</span>
				</div>
				<div class="d-flex justify-content-between m-5">
					<span style="font-size: 20px">생년월일 :</span> <span
						style="font-size: 20px">${userBirth }</span>
				</div>
				<div class="d-flex justify-content-between m-5">
					<span style="font-size: 20px">목표 :</span> <span
						style="font-size: 20px">${userPurpose }</span>
				</div>
				<div class="d-flex justify-content-center m-5">
					<span style="font-size: 15px">${userContent }</span>
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
	});
</script>