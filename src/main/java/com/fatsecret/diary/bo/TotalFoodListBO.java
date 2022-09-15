package com.fatsecret.diary.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.TotalFoodListDAO;
import com.fatsecret.diary.model.TotalFoodList;

@Service
public class TotalFoodListBO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TotalFoodListDAO totalFoodListDAO;

	public void addTotalFoodList(Integer userId, int totalCarb, int totalProtein, int totalFat, int totalKcal, int kcalPercent, String date) {

		totalFoodListDAO.insertTotalFoodList(userId, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent, date);
	}

	public TotalFoodList getTotalFoodByUserId(Integer userId) {

		return totalFoodListDAO.selectTotalFoodByUserId(userId);
	}

	public void updateTotalFoodList(int id, int totalCarb, int totalProtein, int totalFat, int totalKcal, int kcalPercent) {

		totalFoodListDAO.updateTotalFoodList(id, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent);
	}

	public List<TotalFoodList> getTotalFoodListByUserId(Integer userId) {

		return totalFoodListDAO.selectTotalFoodListByUserId(userId);
	}
	
	public TotalFoodList getTotalFoodByUserIdDESC(Integer userId) {
		
		return totalFoodListDAO.selectTotalFoodByUserIdDESC(userId);
	}
	
	public TotalFoodList getTotalFoodListByUserIdCreatedAt(Integer userId) {
		
		return totalFoodListDAO.selectTotalFoodListByUserIdCreatedAt(userId);
	}
	
	public TotalFoodList getTotalFoodByUserIdDate(Integer userId, String date) {
		
		return totalFoodListDAO.selectTotalFoodListByUserIdDate(userId, date);
	}
}
