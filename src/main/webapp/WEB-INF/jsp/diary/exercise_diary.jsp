<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="diaryWrap d-flex justify-content-center"
	style="height: 800px">
	<div class="w-50 my-5">
		<div class="w-100">
			<div class="d-flex justify-content-center mb-3">
				<input type="text" class="datepicker text-center" id="datepicker">
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
						<td>${mFoodList.fat + lFoodList.fat + dFoodList.fat}g</td>
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
								placeholder="운동명"> <input type="text" id="mAmount"
								class="form-control m-1" placeholder="운동 시간"> <input
								type="text" id="mCarb" class="form-control m-1"
								placeholder="소비 Cal"> 
							<div class="d-flex justify-content-between mt-2">
								<button id="moringFoldBtn" class="btn btn-success">접기</button>
								<button id="morningSaveBtn" class="btn btn-success"
									data-time-type="아침">추가</button>
							</div>
						</div>
					</div>
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
});
</script>
