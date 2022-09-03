package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.TotalFoodList;

@Repository
public interface TotalFoodListDAO {
	
	public void insertTotalFoodList(
			@Param("userId") Integer userId,
			@Param("carb") int totalCarb,
			@Param("protein") int totalProtein,
			@Param("fat") int totalFat,
			@Param("kcal") int totalKcal,
			@Param("kcalPercent") int kcalPercent
			);
	
	public TotalFoodList selectTotalFoodByUserId(
			@Param("userId") Integer userId
			);
	
	public void updateTotalFoodList(
			@Param("id") int id,
			@Param("carb") int totalCarb,
			@Param("protein") int totalProtein,
			@Param("fat") int totalFat,
			@Param("kcal") int totalKcal,
			@Param("kcalPercent") int kcalPercent
			);
	
	public List<TotalFoodList> selectTotalFoodListByUserId(Integer userId);
	
	public TotalFoodList selectTotalFoodByUserIdDESC(Integer userId);
}
