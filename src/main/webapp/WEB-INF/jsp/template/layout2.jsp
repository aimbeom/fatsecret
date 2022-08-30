<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FatSecret</title>
<!-- jquery : bootstrap, datepicker -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- stylesheet yml로 사용할 땐 /static을 붙여준다-->
<link rel="stylesheet" type="text/css" href="/static/css/fatSecret.css">

<!-- fullcalender -->
<link href="/static/fullcalendar-5.11.3/lib/main.css" rel="stylesheet" />
<script src="/static/fullcalendar-5.11.3/lib/main.js"></script>

<!-- <script>
      document.addEventListener('DOMContentLoaded', function() {
    	 var calendarEl = document.getElementById('calendar');
         var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        	
         /*  ,events: function(start,end,time,callback){
        		  var sStart = start._d.getFullYear()+'-'+(start._d.getMonth()+1)+'-'+start._d.getDate()+' 00:00:00';
        		  var sEnd = end._d.getFullYear()+'-'+(end._d.getMonth()+1)+'-'+end._d.getDate()+' 23:59:59';

        		  // console.log(start._d.getFullYear()+'-'+(start._d.getMonth()+1)+'-'+start._d.getDate()+' 00:00:00');
        		  // console.log(end._d.getFullYear()+'-'+(end._d.getMonth()+1)+'-'+end._d.getDate()+' 23:59:59')
        		  var sConfirm='all';

        		  aParame = {'start_date': sStart,'end_date':sEnd,'mode':'select','calendar_status':sConfirm};
        		  $.ajax({
        		  	url: "/test/action.php",
        		  	type: 'POST',
        		  	cache: false,
        		  	data: aParame,
        		  	dataType:'JSON',
        		  	success: function (result) {
        		  	callback(result);
        		  },
        		  	error: function (request, status, error) {
        		  	console.log(error);
        		  	}
        		  });

        		  } */
        });
         
        calendar.render();
      });
</script> -->

<script>
	$(function() {
		$('.datepicker').datepicker(
				{
					dateFormat : 'yy-mm-dd' //달력 날짜 형태
					,
					showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
					,
					showMonthAfterYear : true // 월- 년 순서가아닌 년도 - 월 순서
					,
					changeYear : true //option값 년 선택 가능
					,
					changeMonth : true //option값  월 선택 가능  
					,
					minDate : new Date('1950-01-01'),
					maxDate : new Date('2022-12-31')

					,
					onSelect : function() {
						let date = $.datepicker.formatDate("yy-mm-dd", $(
								"#datepicker").datepicker("getDate"));
						alert(date);
						let type = "food";

						location.href = "/diary/food_diary_view?date=" + date
								+ "&type=" + type;

						if (date == null) {
							$('#datepicker').datepicker('setDate', 'today');
						}
					}
				});

		$('.Edatepicker').datepicker(
				{
					dateFormat : 'yy-mm-dd' //달력 날짜 형태
					,
					showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
					,
					showMonthAfterYear : true // 월- 년 순서가아닌 년도 - 월 순서
					,
					changeYear : true //option값 년 선택 가능
					,
					changeMonth : true //option값  월 선택 가능  
					,
					minDate : new Date('1950-01-01'),
					maxDate : new Date('2022-12-31')

					,
					onSelect : function() {
						let date = $.datepicker.formatDate("yy-mm-dd", $(
								"#Edatepicker").datepicker("getDate"));
						alert(date);
						let type = "exercise";

						location.href = "/diary/exercise_diary_view?date="
								+ date + "&type=" + type;

						if (date == null) {
							$('#Edatepicker').datepicker('setDate', 'today');
						}
					}
				});
	});
</script>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="../include/gnb2.jsp" />
		</header>
		<section class="content">
			<jsp:include page="../${viewName}.jsp" />
		</section>
	</div>
</body>
</html>