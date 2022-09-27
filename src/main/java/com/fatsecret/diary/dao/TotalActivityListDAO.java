package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.TotalActivityList;

@Repository
public interface TotalActivityListDAO {
	
	//토탈 활동 리스트 추가
	public void insertTotalActivityList(
			@Param("userId") Integer userId,
			@Param("kcal") int kcal,
			@Param("date") String date
			);
	
	//유저의 가장 최근 토탈 활동 리스트 가져오기
	public TotalActivityList selectTotalActivityByUserId(
			@Param("userId") Integer userId);
	
	//유저의 토탈 활동 리스트 모두 가져오기
	public List<TotalActivityList> selectTotalActivityListByUserId(
			@Param("userId") Integer userId);
	
	//토탈 활동 리스트 수정
	public void updateTotalActivityByUserId(
			@Param("id") int id
			,@Param("kcal") int kcal
			);
	
	//토탈 활동 리스트 가장 최근것 가져오기
	public TotalActivityList selectTotalActivityByUserIdDESC(Integer userId);
	
	//오늘 날짜 데이터 가져오기
	public TotalActivityList selectTotalActivityByUserIdCreatedAt(Integer userId);
}
