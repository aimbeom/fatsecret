<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="wrap w-50 container" style="border: 3px solid">
	<div class="box1 w-100">
		<div class="d-flex justify-content-between">
			<div class="d-flex">
				<div class="imgInfo m-3">
					<img src="${userImage }" width="250px" height="250px">
					<div>
						<div class="d-flex justify-content-center">
							<span style="color: black">${userName}</span>

						</div>
						<div class="d-flex justify-content-center">
							<span style="color: black">${userEmail}</span>
						</div>
					</div>
				</div>
				<div class="postInfo m-4">
				<div></div>
					<div class="mb-3">
						<span style="font-size: 15px">게시글</span>
					</div>
					<div class="mb-3">
						<span style="font-size: 15px">${postCount }</span>
					</div>
					<div class="mb-3">
						<span style="font-size: 15px">팔로잉</span>
					</div>
					<div class="mb-3">
						<span style="font-size: 15px">${userName }</span>
					</div>
					<div class="mb-3">
						<span style="font-size: 15px">팔로워</span>
					</div>
					<div class="mb-0">
						<span style="font-size: 15px">${userName }</span>
					</div>
				</div>
			</div>
			<div class="info m-4">
				<div class="d-flex justify-content-between m-4">
					<span style="font-size: 15px">이름 :</span> <span
						style="font-size: 15px">${userName }</span>
				</div>
				<div class="d-flex justify-content-between m-4">
					<span style="font-size: 15px">신장 :</span> <span
						style="font-size: 15px">${userHeight }cm</span>
				</div>
				<div class="d-flex justify-content-between m-4">
					<span style="font-size: 15px">생년월일 :</span> <span
						style="font-size: 15px">${userBirth }</span>
				</div>
				<div class="d-flex justify-content-between m-4">
					<span style="font-size: 15px">목표 :</span> <span
						style="font-size: 15px">${userPurpose }</span>
				</div>
				<div class="d-flex justify-content-center m-4">
					<span style="font-size: 15px">${userContent }</span>
				</div>
			</div>
		</div>
		<div class="box-2 w-100 mr-3 bg-secondary">
			<div class="d-flex justify-content-between m-3">
				<span style="font-size: 30px">시작 체중</span> <span
					style="font-size: 30px">현재 체중</span> <span style="font-size: 30px">목표
					체중</span>
			</div>
			<div class="d-flex justify-content-between mx-5">
				<span style="font-size: 30px">${userWeight}kg</span> <span
					style="font-size: 30px">${userWeight}kg</span> <span
					style="font-size: 30px">${userTargetWeight}kg</span>
			</div>
			<div class="d-flex justify-content-between m-3">
				<span style="font-size: 30px">감소한 양</span> <span
					style="font-size: 30px">현재 성과</span> <span style="font-size: 30px">남은
					양</span>
			</div>
			<div class="d-flex justify-content-between mx-5">
				<span style="font-size: 30px">${userWeight-userTargetWeight}kg</span>
				<span style="font-size: 30px">${userWeight}</span> <span
					style="font-size: 30px">${userTargetWeight-userWeight}kg</span>
			</div>
		</div>
	</div>
</div>
