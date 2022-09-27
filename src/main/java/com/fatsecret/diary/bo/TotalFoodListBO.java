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
	
	@Autowired
	TotalFoodListDAO totalFoodListDAO;
	
	//토탈 음식 리스트 추가
	public void addTotalFoodList(Integer userId, int totalCarb, int totalProtein, int totalFat, int totalKcal, int kcalPercent, String date) {

		totalFoodListDAO.insertTotalFoodList(userId, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent, date);
	}
	
	//유저의 토탈 음식 리스트 가져오기
	public TotalFoodList getTotalFoodByUserId(Integer userId) {

		return totalFoodListDAO.selectTotalFoodByUserId(userId);
	}
	
	//토탈 음식 리스트 수정
	public void updateTotalFoodList(int id, int totalCarb, int totalProtein, int totalFat, int totalKcal, int kcalPercent) {

		totalFoodListDAO.updateTotalFoodList(id, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent);
	}
	
	//유저의 토탈 음식 리스트 모두 가져오기
	public List<TotalFoodList> getTotalFoodListByUserId(Integer userId) {

		return totalFoodListDAO.selectTotalFoodListByUserId(userId);
	}
	
	//유저의 음식 리스트 역순으로 가져오기
	public TotalFoodList getTotalFoodByUserIdDESC(Integer userId) {
		
		return totalFoodListDAO.selectTotalFoodByUserIdDESC(userId);
	}
	
	//오늘 날짜 토탈 음식 리스트 가져오기
	public TotalFoodList getTotalFoodListByUserIdCreatedAt(Integer userId) {
		
		return totalFoodListDAO.selectTotalFoodListByUserIdCreatedAt(userId);
	}
	
	// 선택한 날짜 유저의 토탈 음식 리스트 가져오기
	public TotalFoodList getTotalFoodByUserIdDate(Integer userId, String date) {
		
		return totalFoodListDAO.selectTotalFoodListByUserIdDate(userId, date);
	}
}
