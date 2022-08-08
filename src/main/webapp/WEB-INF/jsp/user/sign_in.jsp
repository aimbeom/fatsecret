<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrap w-100 h-100 d-flex justify-content-center align-items-center">
	<div class="w-25">
		<div class="idBlock m-2">
			<input type="text" placeholder="ID" id="email" class="form-control mb-4">
		</div>

		<div class="pwBlock m-2">
			<input type="password" placeholder="PW" id="password" class="form-control">
		</div>
		<div class="btnBlock d-flex justify-content-between">
			<button class="btn btn-success m-2 form-control">로그인</button>
			<a class="btn btn-block btn-secondary m-2 form-control" href="/user/sign_up_view">회원가입</a>
		</div>
	</div>
</div>