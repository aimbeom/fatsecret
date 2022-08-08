<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrap w-100 h-100 d-flex justify-content-center align-items-center">
	<div class="w-25">
		<div class="idBlock m-2">
			<input type="text" placeholder="Email" id="email" class="form-control mb-4">
		</div>

		<div class="pwBlock m-2">
			<input type="password" placeholder="Password" id="password" class="form-control">
		</div>
		<div class="btnBlock d-flex justify-content-between">
			<button type="button" id="loginBtn" class="btn btn-success m-2 form-control">로그인</button>
			<a class="btn btn-block btn-secondary m-2 form-control" href="/user/sign_up_view">회원가입</a>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		$('#loginBtn').on('click', function(){
			//alert('test');
			//validation
			let email = $('#email').val().trim();
			let password = $('#password').val().trim();
			
			if(email == ""){
				alert('email을 입력해주세요');
			}
			if(password == ""){
				alert('password을 입력해주세요');
			}
			
			$.ajax({
				//request
				url: "/user/sign_in"
				, method: "post"
				, data: {"email":email, "password":password}
			
				//response
				, success: function(data){
					if(data.result == "success"){
						alert('로그인 성공');
						location.href = "/timeline/timeline_view"
					} else {
						alert('로그인 실패');
					}
				}
				, error: function(e){
					alert('로그인 에러');
				}
			});
		});
	});
</script>