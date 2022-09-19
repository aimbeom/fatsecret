<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="diaryWrap d-flex w-100 justify-content-center" style="height: 800px">
	<div class="w-50 my-5">
		<div class="w-100">
			<div class="d-flex justify-content-center mb-3">
				<input type="text" class="datepicker text-center" id="datepicker"
					value="${setDate }">
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
						<td>${mTotalFoodList.fat + lTotalFoodList.fat + dTotalFoodList.fat}g</td>
						<td>${mTotalFoodList.carb + lTotalFoodList.carb + dTotalFoodList.carb}g</td>
						<td>${mTotalFoodList.protein + lTotalFoodList.protein + dTotalFoodList.protein}g</td>
						<td>${mTotalFoodList.kcal + lTotalFoodList.kcal + dTotalFoodList.kcal}kcal</td>
					</tr>
				</tbody>
			</table>
			<div>
				<div class="d-flex justify-content-end">
					<c:choose>
						<c:when test="${totalFoodListDate == null}">
							<button class="btn btn-success" id="saveTotalFoodInfo">기록</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-success" id="updateTotalFoodInfo">수정</button>
						</c:otherwise>
					</c:choose>
				</div>
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
								<small>${mTotalFoodList.fat}g</small><small>${mTotalFoodList.carb}g</small><small>${mTotalFoodList.protein}g</small><small>${mTotalFoodList.kcal}</small>
							</div>
						</div>
					</div>
					<button id="morningBtn" data-user-id="${userId }"
						class="btn btn-success form-control d-flex justify-content-first">
						<span style="color: white">+항목 추가하기</span>
					</button>
					<div id="morningFoodList2">
						<c:forEach items="${morningFoodList }" var="mlist">
							<div class="my-1" style="background-color:#d7f0bd">
								<div class="d-flex justify-content-between" >
									<div class="ml-3 d-flex w-100 justify-content-between">
										${mlist.foodName }
										<div class="d-flex w-50 justify-content-between px-5 mr-5">
											<small>${mlist.fat }g</small>
											<small>${mlist.carb }g</small>
											<small>${mlist.protein }g</small>
										</div>
									</div>
									<div>
										<a href="#" class="moringFoodDelBtn" data-mlist-id="${mlist.id }">
										<img class="mr-3" src="https://www.iconninja.com/files/603/22/506/x-icon.png" width="10px" height="10px">
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div id="morningFoodList" class="d-none justify-content-center "
						style="background-color: #d7f0bd;">
						<div class="d-flex">
							<div class="w-50 m-3 bg-light">
								<c:forEach items="${morningFoodList }" var="mlist">
									<div class="d-flex justify-content-between my-2">
										<div>
											<a href="#" class="mFoodUpdateBtn"><span class="ml-3">${mlist.foodName}</span></a>
											<span class="ml-3">${mlist.amount}</span>
										</div>
										<a href="#" class="moringFoodDelBtn"
											data-mlist-id="${mlist.id }"> <img class="mr-3"
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
								<small>${lTotalFoodList.fat}g</small><small>${lTotalFoodList.carb}g</small><small>${lTotalFoodList.protein}g</small><small>${lTotalFoodList.kcal}</small>
							</div>
						</div>
					</div>
					<button id="lunchBtn" data-user-id="${userId }"
						class="btn btn-success form-control d-flex justify-content-first">
						<span style="color: white">+항목 추가하기</span>
					</button>
					<div id="lunchFoodList2">
						<c:forEach items="${lunchFoodList }" var="llist">
							<div class="my-1" style="background-color:#d7f0bd">
								<div class="d-flex justify-content-between" >
									<div class="ml-3 d-flex w-100 justify-content-between">
										${llist.foodName }
										<div class="d-flex w-50 justify-content-between px-5 mr-5">
											<small>${llist.fat }g</small>
											<small>${llist.carb }g</small>
											<small>${llist.protein }g</small>
										</div>
									</div>
									<div>
										<a href="#" class="lunchFoodDelBtn" data-llist-id="${llist.id }"> <img
												class="mr-3" src="https://www.iconninja.com/files/603/22/506/x-icon.png"
												width="10px" height="10px">
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div id="lunchFoodList" class="d-none justify-content-center "
						style="background-color: #d7f0bd;">
						<div class="d-flex">
							<div class="w-50 m-3 bg-light">
								<c:forEach items="${lunchFoodList }" var="llist">
									<div class="d-flex justify-content-between my-2">
										<span class="ml-3">${llist.foodName}</span>
										<a href="#" class="lunchFoodDelBtn" data-llist-id="${llist.id }"> <img
											class="mr-3" src="https://www.iconninja.com/files/603/22/506/x-icon.png"
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
								<small>${dTotalFoodList.fat}g</small><small>${dTotalFoodList.carb}g</small><small>${dTotalFoodList.protein}g</small><small>${dTotalFoodList.kcal}</small>
							</div>
						</div>
					</div>
					<button id="dinnerBtn" data-user-id="${userId }"
						class="btn btn-success form-control d-flex justify-content-first">
						<span style="color: white">+항목 추가하기</span>
					</button>
					<div id="dinnerFoodList2">
						<c:forEach items="${dinnerFoodList }" var="dlist">
							<div class="my-1" style="background-color:#d7f0bd">
								<div class="d-flex justify-content-between" >
									<div class="ml-3 d-flex w-100 justify-content-between">
										${dlist.foodName }
										<div class="d-flex w-50 justify-content-between px-5 mr-5">
											<small>${dlist.fat }g</small>
											<small>${dlist.carb }g</small>
											<small>${dlist.protein }g</small>
										</div>
									</div>
									<div>
										<a href="#" class="dinnerFoodDelBtn" data-dlist-id="${dlist.id }"> <img
											class="mr-3" src="https://www.iconninja.com/files/603/22/506/x-icon.png"
											width="10px" height="10px">
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
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
					<span style="font-size: 40px">${kcalPercent }%</span>
					<div class="ml-3">
						<span style="font-size: 30px">RDI 기준</span><br>
						<div class="small">
							<span style="color: blue; font-size: 20px">${recommendedKcal }kcal</span>
						</div>
					</div>
					<div class="mr-3">
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
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(
			function() {
				//아침 식사 추가하기 버튼
				$('#morningBtn').on('click', function() {
					//경고 문구 안보이게 초기화
					$('#morningFoodList').removeClass('d-none');
					$('#morningFoodList2').addClass('d-none');
				});

				//아침식사 리스트 - 접기 버튼
				$('#moringFoldBtn').on('click', function() {
					//alert('test');
					//접기 버튼 클릭 시 다시 접기
					$('#morningFoodList').addClass('d-none');
					$('#morningFoodList2').removeClass('d-none');
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
					
					let date = $('#datepicker').val();
					
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
						url : "/diary/add_food",
						method : "post",
						data : {
							"timeType" : timeType,
							"foodName" : foodName,
							"amount" : amount,
							"carb" : carb,
							"protein" : protein,
							"fat" : fat,
							"kcal" : kcal,
							"date" : date
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
					//alert(id);

					$.ajax({
						//request
						type : "delete",
						url : "/diary/delete_food",
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
					$('#lunchFoodList2').addClass('d-none');
				});

				//점심식사 리스트 - 접기 버튼
				$('#lunchFoldBtn').on('click', function() {
					//alert('test');
					//접기 버튼 클릭 시 다시 접기
					$('#lunchFoodList').addClass('d-none');
					$('#lunchFoodList2').removeClass('d-none');
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
					
					let date = $('#datepicker').val();
					
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
						url : "/diary/add_food",
						method : "post",
						data : {
							"timeType" : timeType,
							"foodName" : foodName,
							"amount" : amount,
							"carb" : carb,
							"protein" : protein,
							"fat" : fat,
							"kcal" : kcal,
							"date" : date
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
						url : "/diary/delete_food",
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
					$('#dinnerFoodList2').addClass('d-none');
				});

				//저녁 식사 리스트 - 접기 버튼
				$('#dinnerFoldBtn').on('click', function() {
					//alert('test');
					//접기 버튼 클릭 시 다시 접기
					$('#dinnerFoodList').addClass('d-none');
					$('#dinnerFoodList2').removeClass('d-none');
				});
				//저녁식사 리스트 - 추가 버튼
				$('#dinnerSaveBtn').on('click', function() {
					//alert('test');
					let timeType = $(this).data('time-type');
					let foodName = $('#dFoodName').val();
					let amount = $('#dAmount').val();
					let carb = $('#dCarb').val().trim();
					let protein = $('#dProtein').val().trim();
					let fat = $('#dFat').val().trim();
					let kcal = $('#dKcal').val().trim();
					
					let date = $('#datepicker').val();
					
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
						alert('단백질 양을 ㄴ입력해주세요');
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
						url : "/diary/add_food",
						method : "post",
						data : {
							"timeType" : timeType,
							"foodName" : foodName,
							"amount" : amount,
							"carb" : carb,
							"protein" : protein,
							"fat" : fat,
							"kcal" : kcal,
							"date" : date
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
						url : "/diary/delete_food",
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

				//totalFoodList 추가
				$('#saveTotalFoodInfo').on('click', function(e) {
							/* $('#saveTotalFoodInfo').addClass('d-none'); */
							
							let totalFat = ${mTotalFoodList.fat + lTotalFoodList.fat + dTotalFoodList.fat};

							let totalCarb = ${mTotalFoodList.carb + lTotalFoodList.carb+ dTotalFoodList.carb};

							let totalProtein = ${mTotalFoodList.protein + lTotalFoodList.protein + dTotalFoodList.protein};

							let totalKcal = ${mTotalFoodList.kcal + lTotalFoodList.kcal + dTotalFoodList.kcal};

							let kcalPercent = ${kcalPercent};
							
							let date = $('#datepicker').val();
							//alert(date)
							//alert(kcalPercent);

							$.ajax({
								//request
								type : "post",
								url : "/diary/add_total_food",
								data : {
									"totalFat" : totalFat,
									"totalCarb" : totalCarb,
									"totalProtein" : totalProtein,
									"totalKcal" : totalKcal,
									"kcalPercent" : kcalPercent,
									"date" : date
								}

								//response
								,
								success : function(data) {
									if (data.result == "success") {
										alert("입력 성공");
										 /* $('#updateTotalFoodInfo').removeClass(
												'd-none'); */
										location.reload(true);
									} else {
										alert('입력 실패');
									}
								},
								error : function(e) {
									alert('오류 발생');
								}
							});
						});

				 $('#updateTotalFoodInfo').on('click', function(e) {

							/* let id = ${totalFoodList.id}; */

							let totalFat = ${mTotalFoodList.fat + lTotalFoodList.fat + dTotalFoodList.fat};

							let totalCarb = ${mTotalFoodList.carb + lTotalFoodList.carb+ dTotalFoodList.carb};

							let totalProtein = ${mTotalFoodList.protein + lTotalFoodList.protein + dTotalFoodList.protein};

							let totalKcal = ${mTotalFoodList.kcal + lTotalFoodList.kcal + dTotalFoodList.kcal};

							let kcalPercent = ${kcalPercent};
							//alert(id);

							$.ajax({
								//request
								type : "post",
								url : "/diary/update_total_food",
								data : {
									"totalCarb" : totalCarb,
									"totalProtein" : totalProtein,
									"totalFat" : totalFat,
									"totalKcal" : totalKcal,
									"kcalPercent" : kcalPercent
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