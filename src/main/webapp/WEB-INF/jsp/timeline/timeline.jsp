<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 타임라인 영역 --%>
<div class="wrap d-flex justify-content-center">
	<c:forEach items="${cardList }" var="card">
		<div class="cardWrap w-50 mt-5">
			<div class="writer d-flex justify-content-between m-2">
				<span>${card.user.nickname }</span>

				<%-- 삭제 모달을 뛰우기 위한 ... 버튼 --%>
				<img src="https://www.iconninja.com/files/860/824/939/more-icon.png"
					width="30">
			</div>
			<%-- 이미지 업로드를 위한 곳 --%>
			<div class="imageSpace bg-primary">
				<img src="${card.post.imagePath }" height="400px" class="w-100"
					alt="이미지">
			</div>
			<%-- 좋아요 --%>
			<div class="card-like m-2">
				<div class="card-like m-2 d-flex justify-content-between">
					<a href="#" class="like-btn"> <img
						src="https://www.iconninja.com/files/527/809/128/heart-icon.png"
						width="35px" height="35px" alt="full heart" class="full-heart">
					</a> <span style="color: gray">9명이 응원합니다</span> <a>9개의 댓글</a>
				</div>
				<div>
					<span>좋아요 1,730개</span>
				</div>
			</div>
			<%-- 글쓴이, 내용 --%>
			<div class="d-flex m-2">
				<span style="font-weight: bold">${card.user.nickname }</span> <span
					class="ml-3">${card.post.content}</span>
			</div>
			<%-- 댓글 --%>
			<c:forEach items="${card.commentCardList}" var="comment">
				<div
					class="card-comment-desc mt-2 border-bottom d-flex justify-content-between">
					<div class="d-flex">
						<div class="ml-2 mb-1 font-weight-bold">${comment.user.nickname }</div>
						<span class="ml-3">${comment.comment.content}</span>
					</div>
					<div class="mr-3">
						<c:if test="${userId == comment.user.id}">
						<a href="#" class="commentDelBtn" data-comment-id="${comment.comment.id }"> <img
							src="https://www.iconninja.com/files/603/22/506/x-icon.png"
							width="10px" height="10px">
						</a>
						</c:if>
					</div>
				</div>
			</c:forEach>
			<%-- 댓글 쓰기 --%>
			<div class="comment-write d-flex border-top">
				<input type="text" id="comment" class="form-control"
					placeholder="댓글 달기">
				<button class="comment-btn btn btn-light"
					data-post-id="${card.post.id }" type="button">게시</button>
			</div>
		</div>
	</c:forEach>
</div>

<script>
	$(document).ready(function() {
		//댓글 게시
		$('.comment-btn').on('click', function(e) {

			//validation
			let content = $('#comment').val();
			let postId = $(this).data('post-id');
			//userId는 세션에서 꺼내 RestController에서 보낸다

			$.ajax({

				//request
				type : "post",
				url : "/comment/add_comment",
				data : {
					"content" : content,
					"postId" : postId
				}

				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert('댓글 입력 성공');
						location.reload(true);
					} else {
						alert('입력 실패');
					}
				},
				error : function(e) {
					alert('에러');
				}
			});
		});
		//댓글 삭제
		$('.commentDelBtn').on('click', function(e){
			e.preventDefault();
			
			//validation
			let commentId = $(this).data('comment-id');
			//alert(commentId);
			
			$.ajax({
				//request
				type: "delete"
				, url: "/comment/delete_comment"
				, data: {"id":commentId}
			
				//response
				, success: function(data){
					if(data.result == "success"){
						alert("삭제 성공");
						location.reload(true);
					} else {
						alert('삭제 실패');
					}
				}
				, error: function(e){
					alert('오류 발생');
				}
			});
		});
	});
</script>

