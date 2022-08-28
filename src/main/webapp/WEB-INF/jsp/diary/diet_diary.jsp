<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="d-flex justify-content-center">
	<div id="calendar" class="w-50"></div>
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
						<tr>
							<fmt:formatDate var="resultRegDt" value="${totalFoodList.createdAt }" pattern="yyyy-MM-dd" />
							<td>${resultRegDt}</td>
							<c:choose>
								<c:when test="${totalFoodList.kcal == null}">
									<td><a href="/diary/food_diary_view">항목 추가하기</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="/diary/food_diary_view?">${totalFoodList.kcal}kcal</a></td>
								</c:otherwise>
							</c:choose>
							<td>${totalFoodList.kcalPercent}%</td>
							<td class="w-50">
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
							<c:forEach items="${totalActivityList }" var="totalActivityList">
								<c:choose>
									<c:when test="${totalActivityList.kcal == null}">
										<td><a href="/diary/exercise_diary_view">항목 추가하기</a></td>
									</c:when>
									<c:otherwise>
										<td>${totalActivityList.kcal}kcal</td>
									</c:otherwise>
								</c:choose>
								<td>${totalActivityList.kcal + totalFoodList.kcal}kcal</td>
							</c:forEach>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</div>

