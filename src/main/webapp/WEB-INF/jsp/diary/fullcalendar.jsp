<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- fullcalendar --%>
<div class="d-flex justify-content-center">
	<div id ="calendar" class="w-50">
		<div> 
			
		</div>
	</div>
</div>

<script>
	$.ajax({
		url: '/diary/diet_fullCalendar',
		type: 'GET',
		success: function(res){
			var list = res;
			console.log(list);
			
			var calendarEl = document.getElementById('calendar');
			
			var events = list.map(function(item) {
				return {
					title : item.reservationTitle,
					start : item.reservationDate + "T" + item.reservationTime
				}
			});
		});	
	// 풀캘린더 컨트롤러에서 디비 값 받아와서 달력에 뿌리기
</script>
	
