package com.fatsecret.diary.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.FoodList;

@Repository
public interface FoodListDAO {
	
	//음식 추가
	public void addFoodList(
			@Param("userId") Integer userId,
			@Param("timeType") String timeType,
			@Param("foodName") String foodName,
			@Param("amount") String amount,
			@Param("carb") int carb,
			@Param("protein") int protein,
			@Param("fat") int fat,
			@Param("kcal") int kcal,
			@Param("date") String date
			);
	
	//음식 리스트 가져오기
	public List<FoodList> selectFoodListByUserIdTimeTypeDate(
			@Param("userId") Integer userId,
			@Param("timeType") String timeType,
			@Param("date") String date
			);

	//음식 삭제
	public void delFoodById(int id);

	//userId로 데이터 뽑기
	public List<FoodList> selectFoodListByUserId(Integer usreId);
	
	//userid로 역순 데이터 뽑기
	public List<FoodList> selectFoodListDesc(Integer userId);

}


