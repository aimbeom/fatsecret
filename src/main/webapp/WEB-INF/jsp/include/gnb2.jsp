<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="wrap bg-success">
	<div class="d-flex align-items-center mr-5 justify-content-end">
		<c:if test="${not empty userName}">
			<span> <a href="/user/my_page"><span style="color: white">${userNickname}님
						안녕하세요</span></a> <span style="color: white">| </span> <a
				href="/post/write_view"><span style="color: white">게시하기</span></a> <span
				style="color: white">| </span> <span style="color: white">나의
					체중 ${userWeight}kg</span> <span style="color: white">|</span> <a
				href="/user/sign_out"><span style="color: white">로그아웃</span></a>
			</span>
		</c:if>
		<c:if test="${userName == null }">
			<a href="/user/sign_in_view"><span style="color: white"> 로그인</span></a>
		</c:if>
	</div>

</div>
<div class= "logoWrap">
	<div class="logo ml-5 mt-3">
		<a href="/timeline/timeline_view"> <span
			style="font-size: 60px; color: green">FatSecret</span>
		</a>
	</div>
	<hr>
	<nav id="topMenu" class="d-flex justify-content-center my-2">
		<ul>
			<li><a class="menuLink" href="/diary/diet_view">다이어트 캘린더</a></li>
			<li><a class="menuLink" href="#">음식 다이어리</a></li>
			<li><a class="menuLink" href="#">운동 다이어리</a></li>
			<li><a class="menuLink" href="/timeline/timeline_view">커뮤니티</a></li>
			<li><a class="menuLink" href="/user/my_page">마이페이지</a></li>
		</ul>
	</nav>
</div>
<style>
.logoWrap {
	background-color: #d7f0bd;
	height: "200px"
}

ul {
	list-style-type: none;
	/* 좌측 여백 없애기 */
	padding-left: 0px;
	/* 우측 정렬 하기 */
	float: right;
}

ul li {
	display: inline;
	/* li요소의 좌측 1px의 테두리 만들기 */
	border-left: 1px solid #c0c0c0;
	/* 테두리와 메뉴 간격 벌리기, padding: 위 오른쪽 아래 왼쪽; */
	padding: 0px 20px 0px 20px;
	/* 메뉴와 테두리 사이 간격 벌리기, margin: 위 오른쪽 아래 왼쪽; */
	margin: 20px;
	
	text-color:white;
}

ul li:first-child {
	/* li의 첫번째 요소 좌측에는 테두리 없애기 */
	border-left: none;
}
</style>