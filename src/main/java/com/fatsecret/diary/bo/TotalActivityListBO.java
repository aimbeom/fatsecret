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

	public void addTotalActivityList(int userId, int kcal) {

		totalActivityListDAO.insertTotalActivityList(userId, kcal);
	}

	public TotalActivityList getTotalActivityByUserId(int userId) {

		return totalActivityListDAO.selectTotalActivityByUserId(userId);
	}

	public List<TotalActivityList> getTotalActivityListByUserId(int userId) {

		return totalActivityListDAO.selectTotalActivityListByUserId(userId);
	}
	
	public void updateTotalActivityByUserId(int id, int userId, int kcal) {
		
		totalActivityListDAO.updateTotalActivityByUserId(id, userId, kcal);
	}
}
