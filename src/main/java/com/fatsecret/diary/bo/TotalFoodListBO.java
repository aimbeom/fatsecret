package com.fatsecret.diary.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.TotalFoodListDAO;
import com.fatsecret.diary.model.TotalFoodList;

@Service
public class TotalFoodListBO {

	@Autowired
	TotalFoodListDAO totalFoodListDAO;

	public void addTotalFoodList(int userId, int totalCarb, int totalProtein, int totalFat, int totalKcal, int kcalPercent) {

		totalFoodListDAO.insertTotalFoodList(userId, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent);
	}

	public TotalFoodList getTotalFoodByUserId(int userId) {

		return totalFoodListDAO.selectTotalFoodByUserId(userId);
	}

	public void updateTotalFoodList(int id, int totalCarb, int totalProtein, int totalFat, int totalKcal, int kcalPercent) {

		totalFoodListDAO.updateTotalFoodList(id, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent);
	}

	public List<TotalFoodList> getTotalFoodListByUserId(int userId) {

		return totalFoodListDAO.selectTotalFoodListByUserId(userId);
	}
	
	public TotalFoodList getTotalFoodByUserIdDESC(int userId) {
		
		return totalFoodListDAO.selectTotalFoodByUserIdDESC(userId);
	}
}
