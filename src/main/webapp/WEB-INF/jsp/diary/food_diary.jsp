<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="diaryWrap d-flex justify-content-center"
	style="height: 800px">
	<div class="w-50 my-5">
		<div class="w-100">
			<div class="d-flex justify-content-center mb-3">
				<input type="text" class="datepicker text-center" id="datepicker" value="${setDate }">
			</div>
			<table class="table">
				<thead class="text-center">
					<tr>
						<th>지방</th>
						<th>탄수화물</th>
						<th>단백질</th>
						<th>Cal</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<tr>
						<td>${mFoodList.fat + lFoodList.fat + dFoodList.fat}g</td>
						<td>${mFoodList.carb + lFoodList.carb + dFoodList.carb}g</td>
						<td>${mFoodList.protein + lFoodList.protein + dFoodList.protein}g</td>
						<td>${mFoodList.kcal + lFoodList.kcal + dFoodList.kcal}kcal</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="input-wrap w-100 mt-5">
			<div class="m-4">
				<div class="d-flex justify-content-between">
					<span style="font-size: 30px">아침 식사</span>
					<div class="w-50">
						<div class="d-flex justify-content-between">
							<small>지방</small><small>탄수화물</small><small>단백질</small><small>Cal</small>
						</div>
						<div class="d-flex justify-content-between">
							<small>${mFoodList.fat}</small><small>${mFoodList.carb}</small><small>${mFoodList.protein}</small><small>${mFoodList.kcal}</small>
						</div>
					</div>
				</div>
				<button id="morningBtn" data-user-id="${userId }"
					class="btn btn-success form-control d-flex justify-content-first">
					<span style="color: white">+항목 추가하기</span>
				</button>
				<div id="morningFoodList" class="d-none justify-content-center "
					style="background-color: #d7f0bd;">
					<div class="d-flex">
						<div class="w-50 m-3 bg-light">
							<c:forEach items="${morningFoodList }" var="mlist">
								<div class="d-flex justify-content-between my-2">
									<span class="ml-3">${mlist.foodName}</span> <a href="#"
										class="moringFoodDelBtn" data-mlist-id="${mlist.id }"> <img
										class="mr-3"
										src="https://www.iconninja.com/files/603/22/506/x-icon.png"
										width="10px" height="10px">
									</a>
								</div>
							</c:forEach>
						</div>
						<div class="w-50 m-3">
							<input type="text" id="mFoodName" class="form-control m-1"
								placeholder="음식"> <input type="text" id="mAmount"
								class="form-control m-1" placeholder="양 수"> <input
								type="text" id="mCarb" class="form-control m-1"
								placeholder="탄수화물"> <input type="text" id="mProtein"
								class="form-control m-1" placeholder="단백질"> <input
								type="text" id="mFat" class="form-control m-1" placeholder="지방">
							<input type="text" id="mKcal" class="form-control m-1"
								placeholder="kcal">
							<div class="d-flex justify-content-between mt-2">
								<button id="moringFoldBtn" class="btn btn-success">접기</button>
								<button id="morningSaveBtn" class="btn btn-success"
									data-time-type="아침">추가</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="m-4">
				<div class="d-flex justify-content-between">
					<span style="font-size: 30px">점심 식사</span>
					<div class="w-50">
						<div class="d-flex justify-content-between">
							<small>지방</small><small>탄수화물</small><small>단백질</small><small>Cal</small>
						</div>
						<div class="d-flex justify-content-between">
							<small>${lFoodList.fat}</small><small>${lFoodList.carb}</small><small>${lFoodList.protein}</small><small>${lFoodList.kcal}</small>
						</div>
					</div>
				</div>
				<button id="lunchBtn" data-user-id="${userId }"
					class="btn btn-success form-control d-flex justify-content-first">
					<span style="color: white">+항목 추가하기</span>
				</button>
				<div id="lunchFoodList" class="d-none justify-content-center "
					style="background-color: #d7f0bd;">
					<div class="d-flex">
						<div class="w-50 m-3 bg-light">
							<c:forEach items="${lunchFoodList }" var="llist">
								<div class="d-flex justify-content-between my-2">
									<span class="ml-3">${llist.foodName}</span> <a href="#"
										class="lunchFoodDelBtn" data-llist-id="${llist.id }"> <img
										class="mr-3"
										src="https://www.iconninja.com/files/603/22/506/x-icon.png"
										width="10px" height="10px">
									</a>
								</div>
							</c:forEach>
						</div>
						<div class="w-50 m-3">
							<input type="text" id="lFoodName" class="form-control m-1"
								placeholder="음식"> <input type="text" id="lAmount"
								class="form-control m-1" placeholder="양 수"> <input
								type="text" id="lCarb" class="form-control m-1"
								placeholder="탄수화물"> <input type="text" id="lProtein"
								class="form-control m-1" placeholder="단백질"> <input
								type="text" id="lFat" class="form-control m-1" placeholder="지방">
							<input type="text" id="lKcal" class="form-control m-1"
								placeholder="kcal">
							<div class="d-flex justify-content-between mt-2">
								<button id="lunchFoldBtn" class="btn btn-success">접기</button>
								<button id="lunchSaveBtn" class="btn btn-success"
									data-time-type="점심">추가</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="m-4">
				<div class="d-flex justify-content-between">
					<span style="font-size: 30px">저녁 식사</span>
					<div class="w-50">
						<div class="d-flex justify-content-between">
							<small>지방</small><small>탄수화물</small><small>단백질</small><small>Cal</small>
						</div>
						<div class="d-flex justify-content-between">
							<small>${dFoodList.fat}</small><small>${dFoodList.carb}</small><small>${dFoodList.protein}</small><small>${dFoodList.kcal}</small>
						</div>
					</div>
				</div>
				<button id="dinnerBtn" data-user-id="${userId }"
					class="btn btn-success form-control d-flex justify-content-first">
					<span style="color: white">+항목 추가하기</span>
				</button>
				<div id="dinnerFoodList" class="d-none justify-content-center "
					style="background-color: #d7f0bd;">
					<div class="d-flex">
						<div class="w-50 m-3 bg-light">
							<c:forEach items="${dinnerFoodList }" var="dlist">
								<div class="d-flex justify-content-between my-2">
									<span class="ml-3">${dlist.foodName}</span> <a href="#"
										class="dinnerFoodDelBtn" data-dlist-id="${dlist.id }"> <img
										class="mr-3"
										src="https://www.iconninja.com/files/603/22/506/x-icon.png"
										width="10px" height="10px">
									</a>
								</div>
							</c:forEach>
						</div>
						<div class="w-50 m-3">
							<input type="text" id="dFoodName" class="form-control m-1"
								placeholder="음식"> <input type="text" id="dAmount"
								class="form-control m-1" placeholder="양 수"> <input
								type="text" id="dCarb" class="form-control m-1"
								placeholder="탄수화물"> <input type="text" id="dProtein"
								class="form-control m-1" placeholder="단백질"> <input
								type="text" id="dFat" class="form-control m-1" placeholder="지방">
							<input type="text" id="dKcal" class="form-control m-1"
								placeholder="kcal">
							<div class="d-flex justify-content-between mt-2">
								<button id="dinnerFoldBtn" class="btn btn-success">접기</button>
								<button id="dinnerSaveBtn" class="btn btn-success"
									data-time-type="저녁">추가</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="m-4">
				<span style="font-size: 30px">간식/기타</span><br> <a
					class="btn btn-success form-control d-flex justify-content-first">
					<span style="color: white">+항목 추가하기</span>
				</a>
			</div> -->
		</div>
		<div class="d-flex justify-content-between w-100"
			style="background-color: #d7f0bd;">
			<div class="bg-warning w-50 m-5 d-flex">
				<span style="font-size: 40px">${kcalPercent}%</span>
				<div class="ml-3">
					<span style="font-size: 30px">RDI 기준</span><br>
					<div class="small"><span style="color:blue; font-size:20px">${recommendedKcal }kcal</span></div>
				</div>
				<div class="mr-3">
					<img
						src="https://www.iconninja.com/files/214/518/441/heart-icon.png"
						width="30px" height="30px" alt="empty heart" class="mt-3">
				</div>
			</div>
			<div class="w-50 m-5 d-flex justify-content-between bg-warning">
				<div>
					<span style="font-size: 20px">칼로리 분석</span>
					<div class="ml-2">
						<div class="small text-gray">탄수화물 : (${elementPercent.carb }%)</div>
						<div class="small text-gray">단백질 : (${elementPercent.protein }%)</div>
						<div class="small text-gray">지방 : (${elementPercent.fat }%)</div>
					</div>
				</div>
				<div class="mr-2 mt-3">
					<span style="font-size: 30px">N/A</span>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		//아침 식사 추가하기 버튼
		$('#morningBtn').on('click', function() {
			//경고 문구 안보이게 초기화
			$('#morningFoodList').removeClass('d-none');
		});

		//아침식사 리스트 - 접기 버튼
		$('#moringFoldBtn').on('click', function() {
			//alert('test');
			//접기 버튼 클릭 시 다시 접기
			$('#morningFoodList').addClass('d-none');
		});

		//아침식사 리스트 - 추가 버튼
		$('#morningSaveBtn').on('click', function() {
			//alert('test');

			let timeType = $(this).data('time-type');
			let foodName = $('#mFoodName').val();
			let amount = $('#mAmount').val();
			let carb = $('#mCarb').val().trim();
			let protein = $('#mProtein').val().trim();
			let fat = $('#mFat').val().trim();
			let kcal = $('#mKcal').val().trim();

			//validation
			if (foodName == "") {
				alert('음식 이름을 입력해주세요');
				return;
			}

			if (amount == "") {
				alert('양을 입력해주세요');
				return;
			}

			if (carb == "") {
				alert('탄수화물 양을 입력해주세요');
				return;
			}

			if (protein == "") {
				alert('단백질 양을 입력해주세요');
				return;
			}

			if (fat == "") {
				alert('지방 양을 입력해주세요');
				return;
			}

			if (kcal == "") {
				alert('칼로리 양을 입력해주세요');
				return;
			}

			$.ajax({
				//request
				url : "/diary/add_morning_food",
				method : "post",
				data : {
					"timeType" : timeType,
					"foodName" : foodName,
					"amount" : amount,
					"carb" : carb,
					"protein" : protein,
					"fat" : fat,
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

		//아침 음식리스트 삭제
		$('.moringFoodDelBtn').on('click', function(e) {
			e.preventDefault();

			//validation
			let id = $(this).data('mlist-id');
			alert(id);

			$.ajax({
				//request
				type : "delete",
				url : "/diary/delete_morning_food",
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

		//점심 식사 추가하기 버튼
		$('#lunchBtn').on('click', function() {
			//alert('test');
			//경고 문구 안보이게 초기화
			$('#lunchFoodList').removeClass('d-none');
		});

		//점심식사 리스트 - 접기 버튼
		$('#lunchFoldBtn').on('click', function() {
			//alert('test');
			//접기 버튼 클릭 시 다시 접기
			$('#lunchFoodList').addClass('d-none');
		});

		//점심식사 리스트 - 추가 버튼
		$('#lunchSaveBtn').on('click', function() {
			//alert('test');

			let timeType = $(this).data('time-type');
			let foodName = $('#lFoodName').val();
			let amount = $('#lAmount').val();
			let carb = $('#lCarb').val().trim();
			let protein = $('#lProtein').val().trim();
			let fat = $('#lFat').val().trim();
			let kcal = $('#lKcal').val().trim();

			//validation
			if (foodName == "") {
				alert('음식 이름을 입력해주세요');
				return;
			}

			if (amount == "") {
				alert('양을 입력해주세요');
				return;
			}

			if (carb == "") {
				alert('탄수화물 양을 입력해주세요');
				return;
			}

			if (protein == "") {
				alert('단백질 양을 입력해주세요');
				return;
			}

			if (fat == "") {
				alert('지방 양을 입력해주세요');
				return;
			}

			if (kcal == "") {
				alert('칼로리 양을 입력해주세요');
				return;
			}

			$.ajax({
				//request
				url : "/diary/add_lunch_food",
				method : "post",
				data : {
					"timeType" : timeType,
					"foodName" : foodName,
					"amount" : amount,
					"carb" : carb,
					"protein" : protein,
					"fat" : fat,
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

		//점심 음식리스트 삭제
		$('.lunchFoodDelBtn').on('click', function(e) {
			e.preventDefault();

			//validation
			let id = $(this).data('llist-id');
			//alert(id);

			$.ajax({
				//request
				type : "delete",
				url : "/diary/delete_lunch_food",
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

		//저녁 식사 추가하기 버튼
		$('#dinnerBtn').on('click', function() {
			//alert('test');
			//경고 문구 안보이게 초기화
			$('#dinnerFoodList').removeClass('d-none');
		});
		//저녁 식사 리스트 - 접기 버튼
		$('#dinnerFoldBtn').on('click', function() {
			//alert('test');
			//접기 버튼 클릭 시 다시 접기
			$('#dinnerFoodList').addClass('d-none');
		});
		//점심식사 리스트 - 추가 버튼
		$('#dinnerSaveBtn').on('click', function() {
			//alert('test');
			let timeType = $(this).data('time-type');
			let foodName = $('#dFoodName').val();
			let amount = $('#dAmount').val();
			let carb = $('#dCarb').val().trim();
			let protein = $('#dProtein').val().trim();
			let fat = $('#dFat').val().trim();
			let kcal = $('#dKcal').val().trim();

			//validation
			if (foodName == "") {
				alert('음식 이름을 입력해주세요');
				return;
			}

			if (amount == "") {
				alert('양을 입력해주세요');
				return;
			}

			if (carb == "") {
				alert('탄수화물 양을 입력해주세요');
				return;
			}

			if (protein == "") {
				alert('단백질 양을 입력해주세요');
				return;
			}

			if (fat == "") {
				alert('지방 양을 입력해주세요');
				return;
			}

			if (kcal == "") {
				alert('칼로리 양을 입력해주세요');
				return;
			}

			$.ajax({
				//request
				url : "/diary/add_dinner_food",
				method : "post",
				data : {
					"timeType" : timeType,
					"foodName" : foodName,
					"amount" : amount,
					"carb" : carb,
					"protein" : protein,
					"fat" : fat,
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
		//저녁 음식리스트 삭제
		$('.dinnerFoodDelBtn').on('click', function(e) {
			e.preventDefault();

			//validation
			let id = $(this).data('dlist-id');
			//alert(id);

			$.ajax({
				//request
				type : "delete",
				url : "/diary/delete_dinner_food",
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

		/* $(function() {
			$("#datepicker").datepicker();

			$("#datepicker").val();

			$("#datepicker").on("change", function() {
				var selected = $(this).val();
				alert(selected);

			});
		}); */
	});
</script>