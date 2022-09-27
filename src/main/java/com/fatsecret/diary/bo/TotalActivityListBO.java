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
	
	
	//전체 토탈 리스트 추가
	public void addTotalActivityList(Integer userId, int kcal, String date) {

		totalActivityListDAO.insertTotalActivityList(userId, kcal, date);
	}
	
	//유저의 토탈 활동 기록 가져오기
	public TotalActivityList getTotalActivityByUserId(Integer userId) {

		return totalActivityListDAO.selectTotalActivityByUserId(userId);
	}

	//유저의 전체 활동 기록 모두 가져오기
	public List<TotalActivityList> getTotalActivityListByUserId(Integer userId) {

		return totalActivityListDAO.selectTotalActivityListByUserId(userId);
	}
	
	//토탈 활동 리스트 수정	
	public void updateTotalActivityByUserId(int id, int kcal) {
		
		totalActivityListDAO.updateTotalActivityByUserId(id, kcal);
	}
	
	//역순으로 토탈 활동 리스트 가져오기
	public TotalActivityList getTotalActivityByUserIdDESC(Integer userId) {
		
		return totalActivityListDAO.selectTotalActivityByUserIdDESC(userId);
	}
	
	//오늘 날짜 토탈 활동 리스트 가져오기
	public TotalActivityList getTotalActivityByUserIdCreatedAt(Integer userId) {
		
		return totalActivityListDAO.selectTotalActivityByUserIdCreatedAt(userId);
	}
}