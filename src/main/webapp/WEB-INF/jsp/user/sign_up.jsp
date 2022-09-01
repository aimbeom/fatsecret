<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrap w-50 container">
	<div class="detail-information form-group m-4 w-75">
		<h1 style=color:#4aa8d8>내 세부정보</h1>
		<div class="genderBlock d-flex form-group justify-content-between">
			성별 :
			<div>
				<select id="gender" class="form-control">
					<option>남자</option>
					<option>여자</option>
				</select>
			</div>
		</div>
		<div class="nameBlock form-group d-flex justify-content-between">
			이름 :
			<div>
				<input type="text" id="name" class="form-control">
			</div>
		</div>
		<div class="currentWeightBlock form-group d-flex justify-content-between">
			현재 체중:
			<div>
				<input type="text" placeholder="kg" id="weight" class="form-control">
			</div>
		</div>
		<div class="currentHeightBlock form-group d-flex justify-content-between">
			현재 신장:
			<div>
				<input type="text" placeholder="cm" id="height" class="form-control">
			</div>
		</div>
		<div class="birthBlock form-group d-flex justify-content-between">
			생년월일:
			<div>
				<input type="text" class="datepicker form-control" id="birth">
			</div>
		</div>
		<div class="amountOfActivity form-group d-flex justify-content-between">
			활동량 :
			<div>
				<select class="form-control" id="amountOfActivity">
					<option>정주</option>
					<option>낮음</option>
					<option>활동적</option>
					<option>매우 활동적</option>
				</select>
			</div>
		</div>
		<br><br>
		<h1 style=color:#4aa8d8>내 목표</h1>
		<div class="dietPurposeBlock form-group d-flex justify-content-between">
			다이어트 목표:
			<div>
				<select class="form-control" id="purpose">
					<option>체중 증가</option>
					<option>느린 체중 증가</option>
					<option>현재 체중 유지하기</option>
					<option>느린 체중 감소</option>
					<option>체중 감소</option>
				</select>
			</div>
		</div>
		<div class="purposeWeightBlock form-group d-flex justify-content-between">
			목표 체중
			<div>
				<input type="text" id="targetWeight" class="form-control" placeholder="kg">
			</div>
		</div>
		<br><br>
		<h1 style=color:#4aa8d8>FatSecret 계정</h1>
		<div class="nickNameBlock form-group d-flex justify-content-between">
			닉네임 :
			<div class="d-flex">
				<input type="text" id="nickname" class="form-control mr-2">
				<button type="submit" class="btn btn-primary" id="nickNameCheckBtn">중복확인</button>
			</div>
		</div>
		<div id="nickNameInfo" class="small text-secondary">회원이름은 공개되므로 모든 사람들이 함께 보기 쉬운 이름을 선택하세요
			나머지 제공된 정보들은 비공개입니다.</div>
			<%-- 아이디 체크 결과 --%> <%-- d-none 클래스: display none (보이지 않게) --%>
		<div id="nickNameLength" class="small text-danger d-none">닉네임을 2자 이상 입력해주세요.</div>
		<div id="nickNameCheckkDuplicated" class="small text-danger d-none">이미 사용중인 닉네임 입니다.</div>
		<div id="nickNameCheckOk" class="small text-success d-none">사용 가능한 닉네임 입니다.</div>
		
		<div class="passwordBlock form-group d-flex justify-content-between">
			비밀번호 :
			<div class="d-flex">
				<input type="password" id="password" class="form-control">
			</div>
		</div>
		<div class="passwordConfrimBlock form-group d-flex justify-content-between">
			비밀번호 확인 :
			<div class="d-flex">
				<input type="password" id="passwordConfirm" class="form-control">
			</div>
		</div>
		<div id="pwCheckFalse" class="small text-danger d-none">비밀번호가 일치하지 않습니다</div>
		<div id="pwCheckCollect" class="small text-success d-none">사용 가능한 비밀번호 입니다</div>
		<div class="emailBlock form-group d-flex justify-content-between">
			이메일 :
			<div class="d-flex">
				<input type="email" id="email" class="form-control">
			</div>
		</div>
		<br><br>
		<h1 style=color:#4aa8d8>자기소개</h1>
		<textarea class="w-100 border" rows="5" id="content" placeholder="내용을 입력해주세요"></textarea>
		<br><br>
		<h1 style=color:#4aa8d8>내 이미지</h1>
		<%-- 이미지 업로드를 위한 곳 --%>
		<div class="d-flex">
			<input type="file" id="file" class="d-none" accept=".gif,.jpg,.png,.jpeg">
				<a href="#" id="fileUpLoadBtn">
				<img src="https://as2.ftcdn.net/v2/jpg/02/51/00/15/1000_F_251001540_P8oe2YQ5v5dhZnrN5SFwXgLS0NMZXyNn.jpg"
					alt="파일선택" width="35px">
				</a>
				<span>이미지 첨부하기</span>
		<%-- 업로드 된 임시 파일명 보이는 곳 --%>
			<div id="fileName" class="ml-2"></div>
		</div>
		<div class="d-flex w-100 justify-content-between mt-5">
		<a href="#" class="btn btn-secondary form-control mr-4">취소</a>
		<button type="button" id="signUpBtn" class="btn btn-success form-control">회원가입</button>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	//파일업로드 이미지 클릭 -> input type ="file" 숨어있던 창이 열림
	$('#fileUpLoadBtn').on('click', function(e) {
		e.preventDefault(); //a태그가 위로 올라가는 현상을 방지

		$('#file').click(); // input file을 클릭한 것과 같은 효과

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

		//임시파일 명 노출
		$('#fileName').text(fileName);
	});
	
	// 아이디 중복확인 버튼
	// ajax-1 방식으로 처리
	$('#nickNameCheckBtn').on('click', function(){
		//경고 문구 안보이게 초기화
		$('#nickNameLength').addClass('d-none');
		$('#nickNameCheckkDuplicated').addClass('d-none');
		$('#nickNameCheckOk').addClass('d-none');
		
		let nickname = $('#nickname').val().trim();
		//alert(nickname);
		
		//validation
		if(nickname.length < 2){
			$('#nickNameLength').removeClass('d-none');
			return; //함수를 빠져나가는 의미 아래 코드 실행 x
		}
		
		// ajax - 중복확인
		$.ajax({
			
			//request
			url:"/user/is_duplicated_nickName"
			,method: "post"
			,data: {"nickname":nickname}	
			
			//response
			,success: function(data){
				if(data.result){
					//중복입니다
					$('#nickNameCheckkDuplicated').removeClass('d-none');
				} else if(data.result == false){
					//중복이 아닌 경우 -> 사용 가능한 아이디
					$('#nickNameCheckOk').removeClass('d-none');
				} else{
					//에러
					alert("중복 체크에 실패했습니다.");
				}
			}
			,error: function(e){
				alert('아이디 중복 체크에 실패했습니다');
			}
		});
	});
	
	//회원가입 버튼 클릭
	$('#signUpBtn').on('click', function(e){
		//alert('test');
		$('#pwCheckFalse').addClass('d-none');
		$('#pwCheckCollect').addClass('d-none');
		
		//validation
		//내 세부정보
		let gender = $('#gender').val();
		let name = $('#name').val().trim();
		if(name == ""){
			alert('이름을 입력해주세요');
			return;
		}
		let weight = $('#weight').val().trim();
		if(weight == ""){
			alert('몸무게를 입력해주세요');
			return;
		}
		let height = $('#height').val().trim();
		if(height == ""){
			alert('키를 입력해주세요');
			return;
		}
		let birth = $('#birth').val().trim();
		if(birth == ""){
			alert('생일을 입력해주세요');
			return;
		}
		let amountOfActivity = $('#amountOfActivity').val().trim();
		
		//내 목표
		let purpose = $('#purpose').val().trim();
		let targetWeight = $('#targetWeight').val().trim();
		if(targetWeight == ""){
			alert('목표 체중을 입력해주세요');
			return;
		}
		let nickname = $('#nickname').val().trim();
		if(nickname == ""){
			alert('닉네임을 입력해주세요');
			return;
		}
		let email = $('#email').val().trim();
		if(email == ""){
			alert('이메일을 입력해주세요');
			return;
		}
		let password = $('#password').val().trim();
		if(password == ""){
			alert('비밀번호를 입력해주세요');
			return;
		}
		let passwordConfirm = $('#passwordConfirm').val().trim();
		if(passwordConfirm == ""){
			alert('비밀번호를 확인해주세요');
			return;
		}
		if(password != passwordConfirm){
			$('#pwCheckFalse').removeClass('d-none');
			alert('비밀번호가 일치하지 않습니다');
		}			
		
		
		//자기소개
		let content = $('#content').val();
		
		//이미지 파일 전송을 위해 내부에 form태그를 생성한다
		let formData = new FormData();
		formData.append("gender", gender);
		formData.append("name", name);
		formData.append("weight", weight);
		formData.append("height", height);
		formData.append("birth", birth);
		formData.append("amountOfActivity", amountOfActivity);
		formData.append("purpose", purpose);
		formData.append("targetWeight", targetWeight);
		formData.append("nickname", nickname);
		formData.append("password", password);
		formData.append("email", email);
		formData.append("content", content);
		formData.append("file", $('#file')[0].files[0]);
		
		//ajax form 데이터 전송
		$.ajax({

			//request
			type : "post",
			url : "/user/sign_up",
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
					alert('회원가입 성공');
					location.href = "/user/kcal_informed_view";
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
});
</script>