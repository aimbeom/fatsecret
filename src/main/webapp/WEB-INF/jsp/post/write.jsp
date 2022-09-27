<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrap d-flex justify-content-center">
	<div class="title w-50">
		<input type="text" id="title" placeholder="제목을 입력해주세요"
			class="form-control">
		<textarea class="w-100 border" rows="10" id="content"
			placeholder="  내용을 입력해주세요"></textarea>
		<div class="d-flex justify-content-between">
			<%-- 이미지 업로드를 위한 곳 --%>
			<div class="d-flex">
				<input type="file" id="file" class="d-none"
					accept=".gif,.jpg,.png,.jpeg"> <a href="#"
					id="fileUpLoadBtn"> <img
					src="https://as2.ftcdn.net/v2/jpg/02/51/00/15/1000_F_251001540_P8oe2YQ5v5dhZnrN5SFwXgLS0NMZXyNn.jpg"
					alt="파일선택" width="35px">
				</a>
				<%-- 업로드 된 임시 파일명 보이는 곳 --%>
				<div id="fileName" class="ml-2"></div>
			</div>
			<button type="button" id="saveBtn" class="btn btn-info">게시</button>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
				//파일업로드 이미지 클릭 -> input type ="file" 숨어있던 창이 열림
				$('#fileUpLoadBtn').on('click', function(e) {
					e.preventDefault(); //a태그가 위로 올라가는 현상을 방지

					$('#file').click(); // input file을 클릭한 것과 같은 효과

				});

				// 파일 업로드를 했을 때, 확장자 이름 노출, 파일 확장자 검증
				$('#file').on('change',function(e) {
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

				$('#saveBtn').on('click', function(e) {
					let title = $('#title').val();
					let content = $('#content').val();

					// form태그를 자바스크립트에서 만든다	.
					let formData = new FormData();
					formData.append("title", title); //<input type ="" name="title"> 를 만들고 name 값을 보낸다
					formData.append("content", content); //<input type ="" name="content"> 를 만들고 name 값을 보낸다
					formData.append("file", $('#file')[0].files[0]); //$('#file')[0] : 첫번째 input file 태그, files[0]: 업로드 된 것 중에 첫번째 파일

					//ajax form 데이터 전송
					$.ajax({

						//request
						type : "post"
						, url : "/post/create"
						, data : formData
						, encType : "multipart/form-data" // 파일 업로드 필수 설정
						, processData : false //파일 업로드 필수 설정 ({"":""} 형태로 자동 변환 x)
						, contentType : false //파일 업로드 필수 설정

						//response
						, success : function(data) {
							if (data.result == "success") {
								alert('메모가 저장되었습니다');
								location.href = "/timeline/timeline_view";
							} else {
								alert(data.errorMessage);
							}
						}
						, error : function(e) {
							alert("메모 저장에 실패했습니다");
						}
					});
				});
			});
</script>