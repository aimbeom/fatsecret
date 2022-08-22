package com.fatsecret.diary.bo;

import java.util.Date;
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

	// 아침 음식 추가
	public void addMorningFoodList(int userId, String timeType, String foodName, String amount, int carb, int protein,
			int fat, int kcal) {

		foodListDAO.addMorningFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
	}

	// userId,date로 선택한 날짜 아침 음식 리스트 가져오기
	public List<FoodList> getMorningFoodListByUserIdTimeType(int userId, String date) {

		return foodListDAO.selectMorningFoodListByUserIdTimeType(userId, date);
	}

	// 아침식사 리스트 삭제
	public void delMorningFoodListById(int id) {

		foodListDAO.delMorningFoodListById(id);
	}

	// 점심 음식 추가
	public void addLunchFoodList(int userId, String timeType, String foodName, String amount, int carb, int protein,
			int fat, int kcal) {

		foodListDAO.addLunchFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
	}

	// userId 점심 음식 리스트 가져오기
	public List<FoodList> getLunchFoodListByUserIdTimeType(int userId, String date) {

		return foodListDAO.selectLunchFoodListByUserIdTimeType(userId, date);
	}

	// 점심식사 리스트 삭제
	public void delLunchFoodListById(int id) {

		foodListDAO.delLunchFoodListById(id);
	}

	// 저녁 음식 추가
	public void addDinnerFoodList(int userId, String timeType, String foodName, String amount, int carb, int protein,
			int fat, int kcal) {

		foodListDAO.addDinnerFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
	}

	// userId 저녁 음식 리스트 가져오기
	public List<FoodList> getDinnerFoodListByUserIdTimeType(int userId, String date) {

		return foodListDAO.selectDinnerFoodListByUserIdTimeType(userId, date);
	}

	// 점심식사 리스트 삭제
	public void delDinnerFoodListById(int id) {

		foodListDAO.delDinnerFoodListById(id);
	}

	// 아침 탄단지칼 합산 구하기
	public FoodList mtotalAmount(int userId, String date) {
		int totalCarb = 0;
		int totalProtein = 0;
		int totalFat = 0;
		int totalKcal = 0;

		FoodList foodList = new FoodList();

		// 아침 리스트
		List<FoodList> morningList = getMorningFoodListByUserIdTimeType(userId, date);

		for (int i = 0; i < morningList.size(); i++) {

			int carb = morningList.get(i).getCarb();
			totalCarb += carb;
			logger.info("totalCarb:{}", totalCarb);

			int protein = morningList.get(i).getProtein();
			totalProtein += protein;
			logger.info("totalProtein:{}", totalProtein);

			int fat = morningList.get(i).getFat();
			totalFat += fat;
			logger.info("totalFat:{}", totalFat);

			int kcal = morningList.get(i).getKcal();
			totalKcal += kcal;
			logger.info("totalKcal:{}", totalKcal);

			foodList.setCarb(totalCarb);
			foodList.setProtein(totalProtein);
			foodList.setFat(totalFat);
			foodList.setKcal(kcal);
		}
		return foodList;
	}

	// 점심 탄단지칼 합산 구하기
	public FoodList ltotalAmount(int userId, String date) {
		int totalCarb = 0;
		int totalProtein = 0;
		int totalFat = 0;
		int totalKcal = 0;

		FoodList foodList = new FoodList();

		// 점심 리스트
		List<FoodList> lunchList = getLunchFoodListByUserIdTimeType(userId, date);

		for (int i = 0; i < lunchList.size(); i++) {

			int carb = lunchList.get(i).getCarb();
			totalCarb += carb;
			logger.info("totalCarb:{}", totalCarb);

			int protein = lunchList.get(i).getProtein();
			totalProtein += protein;
			logger.info("totalProtein:{}", totalProtein);

			int fat = lunchList.get(i).getFat();
			totalFat += fat;
			logger.info("totalFat:{}", totalFat);

			int kcal = lunchList.get(i).getKcal();
			totalKcal += kcal;
			logger.info("totalKcal:{}", totalKcal);

			foodList.setCarb(totalCarb);
			foodList.setProtein(totalProtein);
			foodList.setFat(totalFat);
			foodList.setKcal(kcal);
		}
		return foodList;
	}

	// 저녁 탄단지칼 합산 구하기
	public FoodList dtotalAmount(int userId, String date) {
		int totalCarb = 0;
		int totalProtein = 0;
		int totalFat = 0;
		int totalKcal = 0;

		FoodList foodList = new FoodList();

		// 점심 리스트
		List<FoodList> dinnerList = getDinnerFoodListByUserIdTimeType(userId, date);

		for (int i = 0; i < dinnerList.size(); i++) {

			int carb = dinnerList.get(i).getCarb();
			totalCarb += carb;
			logger.info("totalCarb:{}", totalCarb);

			int protein = dinnerList.get(i).getProtein();
			totalProtein += protein;
			logger.info("totalProtein:{}", totalProtein);

			int fat = dinnerList.get(i).getFat();
			totalFat += fat;
			logger.info("totalFat:{}", totalFat);

			int kcal = dinnerList.get(i).getKcal();
			totalKcal += kcal;
			logger.info("totalKcal:{}", totalKcal);

			foodList.setCarb(totalCarb);
			foodList.setProtein(totalProtein);
			foodList.setFat(totalFat);
			foodList.setKcal(kcal);
		}
		return foodList;
	}
	
	//당일 섭취량 백분율 구하기
	public float kcalPercent(int userId, String date ,int recommendedKcal) {
		
		FoodList mfoodList = mtotalAmount(userId, date);
		FoodList lfoodList = ltotalAmount(userId, date);
		FoodList dfoodList = dtotalAmount(userId, date);
		
		float totalKcal = mfoodList.getKcal() + lfoodList.getKcal() + dfoodList.getKcal();
		
		float kcalPercent = (totalKcal/recommendedKcal)*100;
		
		logger.info("kcalPercent:{}", kcalPercent);
		
		return kcalPercent;
	}
	
	//탄단지 섭취 비율 백분율 구하기
	public FoodList elementPercent(int userId, String date, int recommendedKcal){
		
		FoodList foodList = new FoodList();
		
		//탄단지별 달성 백분율 구하기
		float recommendCarb = (float)(recommendedKcal*0.5)/4;
		float recommendFat = (float)(recommendedKcal*0.2)/9;
		float recommendProtein = (float)(recommendedKcal*0.3)/4;
		
		logger.info("------------recommendCarb:{}", recommendCarb);
		logger.info("------------recommendFat:{}", recommendFat);
		logger.info("------------recommendProtein:{}", recommendProtein);
		
		//섭취한 탄단지 백분율 구하기
		FoodList mfoodList = mtotalAmount(userId, date);
		FoodList lfoodList = ltotalAmount(userId, date);
		FoodList dfoodList = dtotalAmount(userId, date);
		
		int totalCarb = mfoodList.getCarb() + lfoodList.getCarb() + dfoodList.getCarb();
		int totalProtein = mfoodList.getProtein() + lfoodList.getProtein() + dfoodList.getProtein();
		int totalFat = mfoodList.getFat() + lfoodList.getFat() + dfoodList.getFat();
		
		float carbPercent = totalCarb/recommendCarb*100;
		float proteinPercent = totalProtein/recommendProtein*100;
		float fatPercent = totalFat/recommendFat*100;
		
		logger.info("------------carbPercent:{}", carbPercent);
		logger.info("------------proteinPercent:{}", proteinPercent);
		logger.info("------------recommendProtein:{}", fatPercent);
		
		foodList.setCarb((int) carbPercent);
		foodList.setProtein((int) totalProtein);
		foodList.setFat((int) fatPercent);
		
		return foodList;
	}
	
//	public List<FoodList> getFoodListByUserId(int userId){
//		
//		FoodListDAO.selectFoodListByUserId(usreId);
//	}

}
