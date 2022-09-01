<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex title ml-5 justify-content-between">
	<a href="/timeline/timeline_view"><span style="font-size:60px; color:green">FatSecret</span></a>
	<div class="d-flex align-items-center mr-5">
		<c:if test="${not empty userName}">
			<span>
			<a href="/user/my_page"><span style="color:black">${userName}</span>님 안녕하세요</a> | <a href="/post/write_view">게시하기</a> | 나의 체중 ${user.weight}kg | <a href="/user/sign_out">로그아웃</a>
			</span>
		</c:if>
		<c:if test="${userName == null }">
			<span>
				<a href="/user/sign_in_view">로그인</a>
			</span>
		</c:if>	
	</div>
</div>
<hr>