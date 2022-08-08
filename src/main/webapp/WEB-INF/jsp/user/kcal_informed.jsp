<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap w-50 container">
	<div class="detail-information form-group m-4 w-75">
		<h1 style=color:#4aa8d8>내 세부정보</h1>
		<div class="genderBlock form-group">
			내 일일권장 섭취량
			<div class="d-flex my-4">
				<input type="text" id="recommendedKcal">
				<h1 style=color:#4aa8d8>  kcal</h1>
			</div>
			<div id="recommendedKaclComment" class="small text-secondary">
			귀하의 성별, 나이, 신장, 체중, 활동수준과 목표에 따라 일일권장 섭취량(RDI) [****]칼로리가 계산되었습니다.
			</div>
		</div>
		<div class="d-flex w-100 justify-content-between mt-5">
			<a href="#" class="btn btn-secondary form-control mr-4">취소</a>
			<button type="button" id="signUpBtn" class="btn btn-success form-control">다음</button>
		</div>
	</div>
</div>		