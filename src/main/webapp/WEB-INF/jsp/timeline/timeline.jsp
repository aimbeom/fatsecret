<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 타임라인 영역 --%>
<div class="wrap d-flex justify-content-center">
	<div class="cardWrap my-2">
		<c:forEach items="${cardList }" var="card">
			<div class="card border rounded mt-3">
				<div class="writer d-flex  justify-content-between m-2">
					<c:choose>
						<c:when test="${card.user.id == userId}">
							<a href="/user/my_page_view"><span class="font-weight-bold" style="color:black">${card.user.nickname }</span></a>
						</c:when>
						<c:otherwise>
							<span class="font-weight-bold" style="color:black">${card.user.nickname }</span>
						</c:otherwise>
					</c:choose>
					<%-- 삭제 모달을 뛰우기 위한 ... 버튼 --%>
					<%-- 로그인 된 사람과 글쓴이 정보가 일치할 때만 삭제 가능 --%>
					<c:if test="${card.user.id == userId}">
						<a href="#" class="more-btn" data-toggle="modal"
							data-target="#moreModal" data-post-id="${card.post.id}"> <img
							src="https://www.iconninja.com/files/860/824/939/more-icon.png"
							width="30">
						</a>
					</c:if>
				</div>
				<%-- 이미지 업로드를 위한 곳 --%>
				<div class="imageSpace bg-primary">
					<img src="${card.post.imagePath }" height="400px" width="500px"
						alt="이미지">
				</div>
				<%-- 좋아요 --%>
				<div class="card-like m-2">
					<div class="card-like m-2 d-flex">
						<a href="#" class="like-btn" data-post-id="${card.post.id }"
							data-user-id="${userId }"> <c:choose>
								<c:when test="${card.filledLike == true}">
									<img
										src="https://www.iconninja.com/files/527/809/128/heart-icon.png"
										width="18px" height="18px" alt="full heart" class="full-heart">
								</c:when>

								<c:otherwise>
									<img
										src="https://www.iconninja.com/files/214/518/441/heart-icon.png"
										width="18px" height="18px" alt="empty heart"
										class="empty-heart">
								</c:otherwise>
							</c:choose>
						</a>
						<div>
							<span class="ml-3">좋아요 ${card.likeCount}개</span>
						</div>
					</div>
					<%-- 글쓴이, 내용 --%>
					<div class="d-flex m-2">
						<span style="font-weight: bold">${card.user.nickname }</span>
						<span class="ml-3">${card.post.content}</span>
					</div>
					<%-- 댓글 목록 --%>
					<c:forEach items="${card.commentCardList}" var="comment">
						<div class="card-comment-desc mt-2 border-bottom d-flex justify-content-between">
							<div class="d-flex">
								<div class="ml-2 mb-1 font-weight-bold">${comment.user.nickname }</div>
								<span class="ml-3">${comment.comment.content}</span>
							</div>
							<div class="mr-3">
								<%-- 댓글 삭제 --%>
								<c:if test="${userId == comment.user.id}">
									<a href="#" class="commentDelBtn"
										data-comment-id="${comment.comment.id }"> <img
										src="https://www.iconninja.com/files/603/22/506/x-icon.png"
										width="10px" height="10px">
									</a>
								</c:if>
							</div>
						</div>
					</c:forEach>
					<%-- 댓글 쓰기 --%>
					<div class="comment-write d-flex border-top">
						<input type="text" class="comment form-control"
							placeholder="댓글 달기">
						<button class="comment-btn btn btn-light"
							data-post-id="${card.post.id }" type="button">게시</button>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="moreModal">
	<div class="modal-dialog modal-sm modal-dialog-centered">
		<div class="modal-content">
			<%-- modal 창 안에 내용 넣기 --%>
			<div class="text-center p-3">
				<%-- d-block: 클릭할 수 있는 영역을 넓히기 위해 --%>
				<a href="#" class="del-post d-block">삭제하기</a>
			</div>
		 	<div class="text-center p-3 border-top">
				<!-- data-dismiss: 모달창 닫힘 -->
				<a href="" class="update-post d-block">수정하기</a>
			</div> 
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="moreModal">
	<div class="modal-dialog modal-sm modal-dialog-centered">
		<div class="modal-content">
			<%-- modal 창 안에 내용 넣기 --%>
			<div class="text-center p-3">
				<%-- d-block: 클릭할 수 있는 영역을 넓히기 위해 --%>
				<a href="#" class="del-post d-block">수정테스트</a>
			</div>
		 	<div class="text-center p-3 border-top">
				<!-- data-dismiss: 모달창 닫힘 -->
				<a href="" class="update-post d-block">수정하기</a>
			</div> 
		</div>
	</div>
</div>

<div class="modal2 fade" id="moreModal2">
	<div class="modal-dialog modal-sm modal-dialog-centered">
		<div class="modal-content">
			<%-- modal 창 안에 내용 넣기 --%>
			<div class="text-center p-3">
				<%-- d-block: 클릭할 수 있는 영역을 넓히기 위해 --%>
				<a href="#" class="del-post d-block">수정테스트</a>
			</div>
		 	<div class="text-center p-3 border-top">
				<!-- data-dismiss: 모달창 닫힘 -->
				<a href="" class="update-post d-block">수정하기</a>
			</div> 
		</div>
	</div>
</div>



<script>
	$(document).ready(function() {
		//댓글 게시
		$('.comment-btn').on('click', function(e) {

			//validation
			//let content = $('.comment').val();
			let content = $(this).siblings("input").val().trim();
			let postId = $(this).data('post-id');
			//userId는 세션에서 꺼내 RestController에서 보낸다

			//alert(content);
			//alert(postId);

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
						alert(data.errorMessage);
					}
				},
				error : function(e) {
					alert('에러');
				}
			});
		});
		//댓글 삭제
		$('.commentDelBtn').on('click', function(e) {
			e.preventDefault();

			//validation
			let commentId = $(this).data('comment-id');
			//alert(commentId);

			$.ajax({
				//request
				type : "delete",
				url : "/comment/delete_comment",
				data : {
					"id" : commentId
				}

				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert("삭제 성공");
						location.reload(true);
					} else {
						alert('삭제 실패');
					}
				},
				error : function(e) {
					alert('오류 발생');
				}
			});
		});

		// 좋아요 / 해제
		$('.like-btn').on('click', function(e) {
			e.preventDefault();

			let userId = $(this).data('user-id');
			if (userId == "") {
				alert('로그인을 해주세요');
			}

			let postId = $(this).data('post-id');
			//alert(postId);

			$.ajax({
				//request
				url : "/like/" + postId,
				data : {
					"postId" : postId
				},
				success : function(data) {
					if (data.result = "success") {
						location.reload(true);
					}
				},
				error : function(e) {
					alert('에러 발생');
				}

			});
		});

		// ... 더보기 버튼 클릭시, 모달에 삭제될 글 번호를 넣어준다.
		$('.more-btn').on('click', function(e) {
			e.preventDefault();

			let postId = $(this).data('post-id'); // get
			//alert(postId);

			// 모달에 삭제될 글 번호를 넣어준다.(모달은 재활용 되기 때문에)
			$('#moreModal').data('post-id', postId); // set	태그: data-post-id="2"
		});

		// 모달창 안에 있는 삭제하기 버튼 클릭했을 때
		$('#moreModal .del-post').on('click', function(e) {
			e.preventDefault(); //a 태그 기본 동작 중단(위로 올라가는 현상 방지)

			let postId = $('#moreModal').data('post-id');
			//alert(postId);

			// ajax
			$.ajax({
				//request
				type : "delete",
				url : "/post/delete",
				data : {
					"postId" : postId
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
		
		// ... 더보기 버튼 클릭시, 모달에 삭제될 글 번호를 넣어준다.
		$('.more-btn').on('click', function(e) {
			e.preventDefault();

			let postId = $(this).data('post-id'); // get
			//alert(postId);

			// 모달에 삭제될 글 번호를 넣어준다.(모달은 재활용 되기 때문에)
			$('#moreModal').data('post-id', postId); // set	태그: data-post-id="2"
		});
		
	 	// 모달창 안에 있는 수정하기 버튼 클릭했을 때
		$('#moreModal .update-post').on('click', function(e) {
			e.preventDefault(); //a 태그 기본 동작 중단(위로 올라가는 현상 방지)

			let postId = $('#moreModal').data('post-id');
			//alert(postId);
			
			location.href = "/post/detail_view?postId="+postId;
		});
	});
</script>

