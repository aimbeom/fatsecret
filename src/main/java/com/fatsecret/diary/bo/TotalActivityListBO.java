package com.fatsecret.diary.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.TotalActivityListDAO;
import com.fatsecret.diary.model.TotalActivityList;

@Service
public class TotalActivityListBO {

	@Autowired
	private TotalActivityListDAO totalActivityListDAO;

	public void addTotalActivityList(Integer userId, int kcal, String date) {

		totalActivityListDAO.insertTotalActivityList(userId, kcal, date);
	}

	public TotalActivityList getTotalActivityByUserId(Integer userId) {

		return totalActivityListDAO.selectTotalActivityByUserId(userId);
	}

	public List<TotalActivityList> getTotalActivityListByUserId(Integer userId) {

		return totalActivityListDAO.selectTotalActivityListByUserId(userId);
	}
	
	public void updateTotalActivityByUserId(int id, int kcal) {
		
		totalActivityListDAO.updateTotalActivityByUserId(id, kcal);
	}
	
	public TotalActivityList getTotalActivityByUserIdDESC(Integer userId) {
		
		return totalActivityListDAO.selectTotalActivityByUserIdDESC(userId);
	}
	
	public TotalActivityList getTotalActivityByUserIdCreatedAt(Integer userId) {
		
		return totalActivityListDAO.selectTotalActivityByUserIdCreatedAt(userId);
	}
}