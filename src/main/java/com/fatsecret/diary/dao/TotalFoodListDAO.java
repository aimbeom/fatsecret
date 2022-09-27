package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.TotalFoodList;

@Repository
public interface TotalFoodListDAO {
	
	//토탈 음식 리스트 추가
	public void insertTotalFoodList(
			@Param("userId") Integer userId,
			@Param("carb") int totalCarb,
			@Param("protein") int totalProtein,
			@Param("fat") int totalFat,
			@Param("kcal") int totalKcal,
			@Param("kcalPercent") int kcalPercent,
			@Param("date") String date
			);
	
	//유저 가장 최근 토탈 음식 리스트 하나 가져오기
	public TotalFoodList selectTotalFoodByUserId(
			@Param("userId") Integer userId
			);
	
	//토탈 음식 리스트 수정
	public void updateTotalFoodList(
			@Param("id") int id,
			@Param("carb") int totalCarb,
			@Param("protein") int totalProtein,
			@Param("fat") int totalFat,
			@Param("kcal") int totalKcal,
			@Param("kcalPercent") int kcalPercent
			);
	
	//유저의 토탈 음식 리스트 전부 가져오기
	public List<TotalFoodList> selectTotalFoodListByUserId(Integer userId);
	
	//유저의 토탈 음식 리스트 역순 가져오기
	public TotalFoodList selectTotalFoodByUserIdDESC(Integer userId);
	
	//오늘 날짜 리스트 가져오기
	public TotalFoodList selectTotalFoodListByUserIdCreatedAt(Integer userId);
	
	//선택한 날짜의 리스트 가져오기
	public TotalFoodList selectTotalFoodListByUserIdDate(
			@Param("userId") Integer userId,
			@Param("date") String date
			);

}
