package com.fatsecret.diary.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.FoodList;

@Repository
public interface FoodListDAO {
	
	//아침 음식 추가
	public void addMorningFoodList(
			@Param("userId") int userId,
			@Param("timeType") String timeType,
			@Param("foodName") String foodName,
			@Param("amount") String amount,
			@Param("carb") int carb,
			@Param("protein") int protein,
			@Param("fat") int fat,
			@Param("kcal") int kcal
			);
	
	//아침 음식 리스트 가져오기
	public List<FoodList> selectMorningFoodListByUserIdTimeType(
			@Param("userId") int userId
			,@Param("date") String date
			);
	
	//아침 음식 삭제
	public void delMorningFoodListById(int id);
	
	//점심 음식 추가
	public void addLunchFoodList(
			@Param("userId") int userId,
			@Param("timeType") String timeType,
			@Param("foodName") String foodName,
			@Param("amount") String amount,
			@Param("carb") int carb,
			@Param("protein") int protein,
			@Param("fat") int fat,
			@Param("kcal") int kcal
			);
	
	//점심 음식 리스트 가져오기
	public List<FoodList> selectLunchFoodListByUserIdTimeType(
			@Param("userId") int userId
			,@Param("date") String date
			);
	
	//점심 음식 삭제
	public void delLunchFoodListById(int id);
	
	//저녁 음식 추가
	public void addDinnerFoodList(
			@Param("userId") int userId,
			@Param("timeType") String timeType,
			@Param("foodName") String foodName,
			@Param("amount") String amount,
			@Param("carb") int carb,
			@Param("protein") int protein,
			@Param("fat") int fat,
			@Param("kcal") int kcal
			);
	
	//저녁 음식 리스트 가져오기
	public List<FoodList> selectDinnerFoodListByUserIdTimeType(
			@Param("userId") int userId
			,@Param("date") String date
			);

	//저녁 음식 삭제
	public void delDinnerFoodListById(int id);
	

}


