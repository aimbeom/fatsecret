package com.fatsecret.diary.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.FoodListDAO;
import com.fatsecret.diary.model.FoodList;

@Service
public class FoodListBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FoodListDAO foodListDAO;

	// 음식 추가
	public void addFoodList(int userId, String timeType, String foodName, String amount, int carb, int protein, int fat,
			int kcal) {

		foodListDAO.addFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
	}

	// 음식 리스트 가져오기
	public List<FoodList> getFoodListByUserIdTimeTypeDate(int userId, String timeType, String date) {

		return foodListDAO.selectFoodListByUserIdTimeTypeDate(userId, timeType, date);
	}

	// 음식 리스트 삭제
	public void delFoodById(int id) {

		foodListDAO.delFoodById(id);
	}

	// 탄단지칼 합산 구하기
	public FoodList totalAmount(int userId, String timeType, String date) {
		int totalCarb = 0;
		int totalProtein = 0;
		int totalFat = 0;
		int totalKcal = 0;

		FoodList food = new FoodList();

		// 음식 리스트
		List<FoodList> foodList = getFoodListByUserIdTimeTypeDate(userId, timeType, date);

		for (int i = 0; i < foodList.size(); i++) {

			int carb = foodList.get(i).getCarb();
			totalCarb += carb;
			logger.info("totalCarb:{}", totalCarb);

			int protein = foodList.get(i).getProtein();
			totalProtein += protein;
			logger.info("totalProtein:{}", totalProtein);

			int fat = foodList.get(i).getFat();
			totalFat += fat;
			logger.info("totalFat:{}", totalFat);

			int kcal = foodList.get(i).getKcal();
			totalKcal += kcal;
			logger.info("totalKcal:{}", totalKcal);

			food.setCarb(totalCarb);
			food.setProtein(totalProtein);
			food.setFat(totalFat);
			food.setKcal(totalKcal);
		}
		return food;
	}

	// 당일 섭취량 백분율 구하기
	public float kcalPercent(int userId, String date, int recommendedKcal) {

		FoodList mfoodList = totalAmount(userId, "아침", date);
		FoodList lfoodList = totalAmount(userId, "점심", date);
		FoodList dfoodList = totalAmount(userId, "점심", date);

		float totalKcal = mfoodList.getKcal() + lfoodList.getKcal() + dfoodList.getKcal();

		float kcalPercent = (totalKcal / recommendedKcal) * 100;

		logger.info("kcalPercent:{}", kcalPercent);

		return kcalPercent;
	}

	// 탄단지 섭취 비율 백분율 구하기
	public FoodList elementPercent(int userId, String date, int recommendedKcal) {

		FoodList foodList = new FoodList();

		// 탄단지별 달성 백분율 구하기
		float recommendCarb = (float) (recommendedKcal * 0.5) / 4;
		float recommendFat = (float) (recommendedKcal * 0.2) / 9;
		float recommendProtein = (float) (recommendedKcal * 0.3) / 4;

		logger.info("------------recommendCarb:{}", recommendCarb);
		logger.info("------------recommendFat:{}", recommendFat);
		logger.info("------------recommendProtein:{}", recommendProtein);

		// 섭취한 탄단지 백분율 구하기
		FoodList mfoodList = totalAmount(userId, "아침", date);
		FoodList lfoodList = totalAmount(userId, "점심", date);
		FoodList dfoodList = totalAmount(userId, "저녁", date);

		int totalCarb = mfoodList.getCarb() + lfoodList.getCarb() + dfoodList.getCarb();
		int totalProtein = mfoodList.getProtein() + lfoodList.getProtein() + dfoodList.getProtein();
		int totalFat = mfoodList.getFat() + lfoodList.getFat() + dfoodList.getFat();

		float carbPercent = totalCarb / recommendCarb * 100;
		float proteinPercent = totalProtein / recommendProtein * 100;
		float fatPercent = totalFat / recommendFat * 100;

		logger.info("------------carbPercent:{}", carbPercent);
		logger.info("------------proteinPercent:{}", proteinPercent);
		logger.info("------------recommendProtein:{}", fatPercent);

		foodList.setCarb((int) carbPercent);
		foodList.setProtein((int) totalProtein);
		foodList.setFat((int) fatPercent);

		return foodList;
	}

	public List<FoodList> getFoodList(int userId) {

		return foodListDAO.selectFoodListByUserId(userId);
	}

	// 당일 총 칼로리 계산
	public int totalKcal(int userId, String date, int recommendedKcal) {

		FoodList mfoodList = totalAmount(userId, "아침", date);
		FoodList lfoodList = totalAmount(userId, "점심", date);
		FoodList dfoodList = totalAmount(userId, "점심", date);

		int totalKcal = mfoodList.getKcal() + lfoodList.getKcal() + dfoodList.getKcal();

		logger.info("totalKcal:{}", totalKcal);

		return totalKcal;
	}
	
	// 역순으로 리스트 가져오기
	public List<FoodList> getFoodListDesc(int userId) {
		
		return foodListDAO.selectFoodListDesc(userId);
	}
	
}
