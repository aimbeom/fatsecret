<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap w-100 h-100 d-flex justify-content-center align-items-center">
	<div class="w-25">
		<div class="idBlock m-2">
			<div class="d-flex justify-content-between">
			<span>최근 체중</span>
			${userWeight }kg
			</div>
		</div>
		<div class="pwBlock m-2">
			<div class="d-flex justify-content-between">
				<span style="color:red">새로운 체중</span><input type="text" placeholder="weight" id="weight">
			</div>
		</div>	
		<div class="btnBlock d-flex justify-content-between">
			<button type="button" id="weightUpdateBtn" class="btn btn-success m-2 form-control">수정</button>
			<a class="btn btn-block btn-secondary m-2 form-control" href="/user/my_page_view">돌아가기</a>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		$('#weightUpdateBtn').on('click', function(){
			
			let weight = $('#weight').val();
			alert(weight);
			
			if(weight == ""){
				alert('무게를 입력해주세요');
			}
			
			 $.ajax({
				//request
				url: "/user/weight_update"
				, method: "post"
				, data: {"weight":weight}
			
				//response
				, success: function(data){
					if(data.result == "success"){
						alert('수정 성공');
						location.href = "/user/my_page_view";
					} else {
						alert('수정 실패');
					}
				}
				, error: function(e){
					alert('에러');
				}
			}); 
		});	
	});
</script>