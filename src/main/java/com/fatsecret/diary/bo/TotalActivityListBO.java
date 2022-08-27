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

	public TotalActivityList getTotalActivity(int userId, String date) {

		return totalActivityListDAO.selectTotalActivity(userId, date);
	}

	public List<TotalActivityList> getTotalActivityList(int userId) {

		return totalActivityListDAO.selectTotalActivityList(userId);
	}
}
