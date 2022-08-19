<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="diaryWrap d-flex justify-content-center"
	style="height: 800px">
	<div class="w-50 my-5">
		<div class="w-100">
			<div class="d-flex justify-content-center mb-3">
				<input type="text" class="datepicker text-center"
					id="exerciseDatepicker" value="${setDate }">
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
						<td>${mFoodList.fat + lFoodList.fat + dFoodList.fat}</td>
						<td>${mFoodList.carb + lFoodList.carb + dFoodList.carb}g</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="input-wrap w-100 mt-5">
			<div class="m-4">
				<div class="d-flex justify-content-between">
					<span style="font-size: 30px">활동 및 운동</span>
					<div class="w-50">
						<div class="d-flex justify-content-end">
							<small class="mr-5">시간 소비</small><small class="mr-2">Cal</small>
						</div>
						<div class="d-flex justify-content-end mr-3">
							<span class="mr-5">-</span><span class="ml-4">-</span>
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
							<c:forEach items="${morningFoodList }" var="mlist">
								<div class="d-flex justify-content-between my-2">
									<span class="ml-3">${mlist.foodName}</span> <a href="#"
										class="exerciseDelBtn" data-mlist-id="${mlist.id }"> <img
										class="mr-3"
										src="https://www.iconninja.com/files/603/22/506/x-icon.png"
										width="10px" height="10px">
									</a>
								</div>
							</c:forEach>
						</div>
						<%-- exerciseList --%>
						<div class="w-50 m-3">
							<input type="text" id="activityName" class="form-control m-1"
								placeholder="운동명"> <input type="text" id="activityTime"
								class="form-control m-1" placeholder="운동 시간"> <input
								type="text" id="activitykCal" class="form-control m-1"
								placeholder="소비 Cal">
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
								<span class="mr-5">-</span><span class="ml-4">-</span>
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-between w-100 form-control">
						<a href="#" class="btn" id="sleepBtn"><span>수면</span></a>
						<div id="exerciseList" class="d-none justify-content-center "
							style="background-color: #d7f0bd;">
							<div class="d-flex">
								<div class="w-50 m-3 bg-light">
									<c:forEach items="${morningFoodList }" var="mlist">
										<div class="d-flex justify-content-between my-2">
											<span class="ml-3">${mlist.foodName}</span> <a href="#"
												class="exerciseDelBtn" data-mlist-id="${mlist.id }"> <img
												class="mr-3"
												src="https://www.iconninja.com/files/603/22/506/x-icon.png"
												width="10px" height="10px">
											</a>
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="d-flex justify-content-between">
								<div class="mr-4">-</div>
								<div>-</div>
							</div>
						</div>
					</div>
				</div>
				<div class="w-100 d-none" id="sleepList">
					<div class="d-flex justify-content-between form-control">
						<input type="text" id="hour" class="form-control m-1"
							placeholder="시간"> <input type="text" id="mAmount"
							class="form-control m-1" placeholder="분"> <input
							type="text" id="minute" class="form-control m-1"
							placeholder="소비 Kcal">
						<div class="d-flex m-2">
							<button id="sleepFoldBtn" class="btn btn-success mr-2">접기</button>
							<button id="sleepSaveBtn" class="btn btn-success ml-2">저장</button>
						</div>
					</div>

				</div>
				<div class="d-flex justify-content-between w-100 form-control">
					<span class="ml-3">휴식</span>
					<div class="d-flex justify-content-between">
						<div class="mr-4">24시간</div>
						<div>2016</div>
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
			//경고 문구 안보이게 초기화
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
			alert('test');

			let activityName = $('#activityName').val();
			let activityTime = $('#activityTime').val();
			let kcal = $('#mKcal').val().trim();

			//validation
			if (foodName == "") {
				alert('음식 이름을 입력해주세요');
				return;
			}

			if (foodName == "") {
				alert('음식 이름을 입력해주세요');
				return;
			}

			if (kcal == "") {
				alert('칼로리 양을 입력해주세요');
				return;
			}
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
	});
</script>