<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <div class="d-flex justify-content-center">
	<div id="calendar" class="w-50"></div>
</div> -->
<div class="d-flex justify-content-center mt-5">
	<div class="d-flex w-50 justify-content-between">
		<h3>마이 다이어트 캘린더 - 개요</h3>
		<!-- <a class="btn btn-success" href="/diary/diet_fullCalendar_view">내 일정표</a>	 -->
	</div>
</div>
<hr>
<div class="d-flex justify-content-center">
	<c:choose>
		<c:when
			test="${lastTotalFoodList != null && lastTotalActivityList == null}">
			<span>오늘자 <a href="/diary/exercise_diary_view">운동 다이어리</a>를 완성해주세요!</span>
		</c:when>
		<c:when
			test="${lastTotalFoodList == null && lastTotalActivityList != null}">
			<span>오늘자 <a href="/diary/food_diary_view">음식 다이어리</a>를 완성해주세요!</span>
		</c:when>
		<c:when
			test="${lastTotalFoodList == null && lastTotalActivityList == null}">
			<span> <a href="/diary/exercise_diary_view">운동</a> / <a href="/diary/food_diary_view">음식</a> 다이어리를 입력해 캘린더를 완성해주세요!</span>
		</c:when>
		<%--  	<c:when test="${lastTotalFoodList != null && lastTotalActivityList != null}">
			테스트
 	</c:when> --%>
	</c:choose>
</div>
<div class="diaryWrap d-flex justify-content-center"
	style="height: 400px;">
	<div class="diet_calendar">
		<div class="calendar_card mt-4" style="width: 800px">
			<table class="table">
				<thead class="text-center">
					<tr>
						<th>날짜</th>
						<th>음식(Cal)</th>
						<th>% 일일권장</th>
						<th>영양요약</th>
						<th>운동(Cal)</th>
						<th>총합(Cal)</th>
					</tr>
				</thead>
				<tbody class="text-center">
					<c:forEach items="${totalFoodList }" var="totalFoodList">
						<c:forEach items="${totalActivityList }" var="totalActivityList">
							<fmt:formatDate var="resultRegDt"
								value="${totalFoodList.createdAt }" pattern="yyyy-MM-dd" />
							<fmt:formatDate var="resultAtDt"
								value="${totalActivityList.createdAt }" pattern="yyyy-MM-dd" />
							<c:if test="${resultRegDt == resultAtDt}">
								<tr>
									<td>${resultRegDt}</td>
									<c:choose>
										<c:when test="${totalFoodList.kcal == null}">
											<td><a href="/diary/food_diary_view">항목 추가하기</a></td>
										</c:when>
										<c:otherwise>
											<td>${totalFoodList.kcal}kcal</td>
										</c:otherwise>
									</c:choose>
									<td>${totalFoodList.kcalPercent}%</td>
									<td class="">
										<div class="d-flex justify-content-between">
											<div class="d-flex justify-content-center mx-3 w-100">
												<small>탄수화물: <br> ${totalFoodList.carb }
												</small>
											</div>
											<div class="d-flex justify-content-center mx-2 w-100">
												<small>단백질: <br> ${totalFoodList.protein }
												</small>
											</div>
											<div class="d-flex justify-content-center mx-2 w-100">
												<small>지방: <br> ${totalFoodList.fat }
												</small>
											</div>
										</div>
									</td>
									<c:if test="${resultRegDt == resultAtDt }">
										<td>${totalActivityList.kcal }kcal</td>
									</c:if>
									<c:if test="${resultRegDt == resultAtDt }">
										<c:if test="${totalActivityList.kcal > totalFoodList.kcal}">
											<td><img src="https://cdn-icons-png.flaticon.com/512/2267/2267922.png" width="30"> ${totalActivityList.kcal - totalFoodList.kcal}kcal</td>
										</c:if>
										<c:if test="${totalActivityList.kcal < totalFoodList.kcal}">
											<td><img src="https://cdn-icons-png.flaticon.com/128/2267/2267904.png" width="30"> ${totalFoodList.kcal - totalActivityList.kcal}kcal</td>
										</c:if>
										<c:if test="${totalActivityList.kcal == totalFoodList.kcal}">
											<td>0</td>
										</c:if>
									</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>