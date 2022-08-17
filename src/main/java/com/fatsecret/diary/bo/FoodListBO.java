package com.fatsecret.diary.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.FoodListDAO;
import com.fatsecret.diary.model.FoodList;
import com.fatsecret.diary.model.FoodListCard;

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

	// userId 아침 음식 리스트 가져오기
	public List<FoodList> getMorningFoodListByUserIdTimeType(int userId) {

		return foodListDAO.selectMorningFoodListByUserIdTimeType(userId);
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
	public List<FoodList> getLunchFoodListByUserIdTimeType(int userId) {

		return foodListDAO.selectLunchFoodListByUserIdTimeType(userId);
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
	public List<FoodList> getDinnerFoodListByUserIdTimeType(int userId) {

		return foodListDAO.selectDinnerFoodListByUserIdTimeType(userId);
	}

	// 점심식사 리스트 삭제
	public void delDinnerFoodListById(int id) {

		foodListDAO.delDinnerFoodListById(id);
	}

	// 아침 탄단지칼 합산 구하기
	public FoodList totalAmount(int userId) {
		int totalCarb = 0;
		int totalProtein = 0;
		int totalFat = 0;
		
		FoodList foodList = null;
		
		// 아침 리스트
		List<FoodList> morningList = getMorningFoodListByUserIdTimeType(userId);
		
			int carb = foodList.getCarb();
			totalCarb += carb;
			
			int protein = foodList.getProtein();
			totalProtein += protein;
			
			int fat = foodList.getFat();
			totalFat += fat;
			
			foodList.setCarb(totalCarb);
			foodList.setProtein(totalProtein);
			foodList.setFat(totalFat);

			return foodList;
	}

}
