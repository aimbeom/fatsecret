<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="diaryWrap d-flex justify-content-center"
	style="height: 800px">
	<div class="w-50 my-5">
		<div class="w-100">
			<div class="d-flex justify-content-center mb-3">
				<input type="text" class="Edatepicker text-center" id="Edatepicker"
					value="${setDate }">
			</div>
			<table class="table">
				<thead class="text-center">
					<tr>
						<th>시간 소비</th>
						<th>Cal</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>24시간</td>
						<td>${2016 - sleep.kcal + exercise.kcal}</td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex justify-content-end">
				<fmt:formatDate var="resultRegDt" value="${totalActivity.createdAt }" pattern="yyyy-MM-dd" />
					<c:choose>
						<c:when test="${resultRegDt != setDate }">
							<button class="btn btn-success" id="saveTotalActivityInfo">기록</button>
						</c:when>
						<c:when test="${resultRegDt == setDate }">
							<button class="btn btn-success" id="updateTotalActivityInfo">수정</button>
						</c:when>
					</c:choose>
			</div>
		</div>
		<div class="input-wrap w-100 mt-5">
			<div class="m-4">
				<div class="d-flex justify-content-between">
					<span style="font-size: 30px">활동 및 운동</span>
					<div class="w-50">
						<div class="d-flex justify-content-end">
							<small class="mr-5">시간 소비</small><small class="mr-2">Cal</small>
						</div>
						<div class="d-flex justify-content-end">
							<span class="mr-5" style="font-size: 12px;">${exercise.hour }시간
								${exercise.minute }분</span> <span class="mr-2" style="font-size: 12px">${exercise.kcal }</span>
						</div>
					</div>
				</div>
				<button id="exerciseBtn" data-user-id="${userId }"
					class="btn btn-success form-control d-flex justify-content-first">
					<span style="color: white">+항목 추가하기</span>
				</button>
				<div id="exerciseList" class="d-none justify-content-center "
					style="background-color: #d7f0bd;">
					<div class="d-flex">
						<div class="w-50 m-3 bg-light">
							<c:forEach items="${exerciseList }" var="exercise">
								<div class="d-flex justify-content-between my-2">
									<span class="ml-3">${exercise.name}</span> <a href="#"
										class="exerciseDelBtn" data-exercise-id="${exercise.id }">
										<img class="mr-3"
										src="https://www.iconninja.com/files/603/22/506/x-icon.png"
										width="10px" height="10px">
									</a>
								</div>
							</c:forEach>
						</div>
						<%-- exerciseList --%>
						<div class="w-50 m-3">
							<input type="text" id="activityName" class="form-control m-1"
								placeholder="운동명"> <input type="text" id="activityHour"
								class="form-control m-1" placeholder="시간"> <input
								type="text" id="activityMinute" class="form-control m-1"
								placeholder="분"> <input type="text" id="activitykcal"
								class="form-control m-1" placeholder="소비 Cal">
							<div class="d-flex justify-content-between mt-2">
								<button id="exerciseFoldBtn" class="btn btn-success">접기</button>
								<button id="exerciseSaveBtn" class="btn btn-success">추가</button>
							</div>
						</div>
					</div>
				</div>
				<%-- sleep --%>
				<div class="mt-5">
					<div class="d-flex justify-content-between">
						<span style="font-size: 30px">수면 및 휴식</span>
						<div class="w-50">
							<div class="d-flex justify-content-end">
								<small class="mr-5">시간 소비</small><small class="mr-2">Cal</small>
							</div>
							<div class="d-flex justify-content-end mr-3">
								<span class="ml-3" style="font-size: 12px;">${24 - exercise.hour }시간</span>
								<span class="ml-5" style="font-size: 12px;">${2016 - sleep.kcal }</span>
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-between w-100 form-control">
						<a href="#" class="btn" id="sleepBtn"><span>수면</span></a>
						<c:if test="${sleep != null }">
							<a href="#" class="sleepDelBtn" data-sleep-id="${sleep.id }">
								<img class="ml-5"
								src="https://www.iconninja.com/files/603/22/506/x-icon.png"
								width="10px" height="10px">
							</a>
						</c:if>
						<div class="d-flex justify-content-end mr-1">
							<div class="mr-4">
								<c:choose>
									<c:when test="${sleep.hour == null}">
										<span>${sleep.hour }시간</span>
									</c:when>
									<c:otherwise>
										<span>${sleep.hour }시간 ${sleep.minute } 분</span>
									</c:otherwise>
								</c:choose>
							</div>
							<div>${sleep.kcal }</div>
						</div>
					</div>
				</div>
				<div class="w-100 d-none" id="sleepList">
					<div class="d-flex justify-content-between form-control">
						<input type="text" id="sleepHour" class="form-control m-1"
							placeholder="시간"> <input type="text" id="sleepMinute"
							class="form-control m-1" placeholder="분"> <input
							type="text" id="sleepKcal" class="form-control m-1"
							placeholder="소비 Kcal">
						<div class="d-flex m-2">
							<button id="sleepFoldBtn" class="btn btn-success mr-2">접기</button>
							<c:choose>
								<c:when test="${sleep == null }">
									<button id="sleepSaveBtn" class="btn btn-success ml-2">저장</button>
								</c:when>
								<c:otherwise>
									<button id="sleepUpdateBtn" class="btn btn-success ml-2">수정</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-between w-100 form-control">
					<span class="ml-3">휴식</span>
					<div class="d-flex justify-content-between">
						<c:choose>
							<c:when test="${sleep.hour == null}">
								<div class="mr-4">24시간</div>
								<div>2016</div>
							</c:when>
							<c:when test="${(60 - exercise.minute) - sleep.minute < 0}">
								<div class="mr-4">${((24 - exercise.hour) - sleep.hour)-1}시간
									${(60 - exercise.minute) - sleep.minute }분</div>
								<div>${2016 - sleep.kcal }</div>
							</c:when>
							<c:otherwise>
								<div class="mr-4">${((24 - exercise.hour) - sleep.hour)}시간
									${(60 - exercise.minute) - sleep.minute }분</div>
								<div>${2016 - sleep.kcal }</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		//운동 추가하기 버튼
		$('#exerciseBtn').on('click', function() {
			//안보이게 초기화				
			$('#exerciseList').removeClass('d-none');
		});

		//운동 리스트 - 접기 버튼
		$('#exerciseFoldBtn').on('click', function() {
			//alert('test');
			//접기 버튼 클릭 시 다시 접기
			$('#exerciseList').addClass('d-none');
		});

		//운동 리스트 - 추가 버튼
		$('#exerciseSaveBtn').on('click', function() {
			//alert('test');

			let name = $('#activityName').val();
			let hour = $('#activityHour').val().trim();
			let minute = $('#activityMinute').val().trim();
			let kcal = $('#activitykcal').val();

			//validation
			if (name == "") {
				alert('활동명을 입력해주세요');
				return;
			}

			if (hour == "") {
				alert('시간을 입력해주세요');
			} else if (hour > 24) {
				alert('최대 24시간까지 입력 가능합니다');
				return;
			}

			if (minute == "") {
				alert('분을 입력해주세요');
			} else if (minute > 59) {
				alert('최대 59분까지 입력 가능합니다');
				return;
			}

			if (kcal == "") {
				alert('칼로리 양을 입력해주세요');
				return;
			}

			$.ajax({
				//request
				url : "/diary/add_exercise",
				method : "post",
				data : {
					"name" : name,
					"hour" : hour,
					"minute" : minute,
					"kcal" : kcal
				}
				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert('성공입니다');
						location.reload(true);
					} else {
						alert('저장 실패');
					}
				},
				error : function(e) {
					alert('통신 오류');
				}
			});
		});

		//운동 리스트 삭제
		$('.exerciseDelBtn').on('click', function(e) {
			e.preventDefault();

			//validation
			let id = $(this).data('exercise-id');
			//alert(id);

			$.ajax({
				//request
				type : "delete",
				url : "/diary/delete_exercise",
				data : {
					"id" : id
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

		//수면시간 추가하기 버튼
		$('#sleepBtn').on('click', function(e) {
			e.preventDefault();
			//경고 문구 안보이게 초기화
			$('#sleepList').removeClass('d-none');
		});

		//수면 리스트 - 접기 버튼
		$('#sleepFoldBtn').on('click', function() {
			//alert('test');
			//접기 버튼 클릭 시 다시 접기
			$('#sleepList').addClass('d-none');
		});

		//수면 리스트 - 추가 / 수정 버튼
		$('#sleepSaveBtn').on('click', function() {

			let hour = $('#sleepHour').val();
			let minute = $('#sleepMinute').val();
			let kcal = $('#sleepKcal').val();

			//validation
			if (hour == "") {
				alert('수면 시간을 입력해주세요');
			} else if (hour > 24) {
				alert('최대 24시간까지 입력 가능합니다');
				return;
			}

			if (minute == "") {
				alert('수면 시간을 입력해주세요');
			} else if (minute > 59) {
				alert('최대 59분까지 입력 가능합니다');
			}

			if (kcal == "") {
				alert('칼로리 소모량을 입력해주세요');
				return;
			}

			$.ajax({
				//request
				url : "/diary/add_sleep",
				method : "post",
				data : {
					"hour" : hour,
					"minute" : minute,
					"kcal" : kcal
				}
				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert('성공입니다');
						location.reload(true);
					} else {
						alert('저장 실패');
					}
				},
				error : function(e) {
					alert('통신 오류');
				}
			});
		});

		//수면 리스트 삭제
		$('.sleepDelBtn').on('click', function(e) {
			e.preventDefault();

			//validation
			let id = $(this).data('sleep-id');
			//alert(id);

			$.ajax({
				//request
				type : "delete",
				url : "/diary/delete_sleep",
				data : {
					"id" : id
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

		//수면 리스트 수정
		$('#sleepUpdateBtn').on('click', function(e) {
			e.preventDefault();

			let id = $('.sleepDelBtn').data('sleep-id');
			let hour = $('#sleepHour').val();
			let minute = $('#sleepMinute').val();
			let kcal = $('#sleepKcal').val();
			//alert(date);

			$.ajax({
				//request
				type : "post",
				url : "/diary/update_sleep",
				data : {
					"id" : id,
					"hour" : hour,
					"minute" : minute,
					"kcal" : kcal,
				}
				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert("수정 성공");
						location.reload(true);
					} else {
						alert('수정 실패');
					}
				},
				error : function(e) {
					alert('오류 발생');
				}
			});
		});

		//총 활동 리스트 - 추가
		$('#saveTotalActivityInfo').on('click', function() {

			let kcal = ${2016 - sleep.kcal + exercise.kcal};

			$.ajax({
				//request
				url : "/diary/add_total_activity",
				method : "post",
				data : {
					"kcal" : kcal
				}
				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert('성공입니다');
						location.reload(true);
					} else {
						alert('저장 실패');
					}
				},
				error : function(e) {
					alert('통신 오류');
				}
			});
		});
		
		$('#updateTotalActivityInfo').on('click', function(e) {
				
			//let id = ${totalActivity.id};
			let kcal = ${2016 - sleep.kcal + exercise.kcal};
			//alert(id);
			
			$.ajax({
				//request
				type : "post",
				url : "/diary/update_total_activity",
				data : {
					"kcal" : kcal
				}

				//response
				,
				success : function(data) {
					if (data.result == "success") {
						alert("수정 성공");
						location.reload(true);
					} else {
						alert('수정 실패');
					}
				},
				error : function(e) {
					alert('오류 발생');
				}
			});

		});

	});
</script>