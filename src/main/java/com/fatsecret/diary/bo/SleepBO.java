package com.fatsecret.diary.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.SleepDAO;
import com.fatsecret.diary.model.Sleep;

@Service
public class SleepBO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SleepDAO sleepDAO;
	
	//수면 리스트 추가
	public void addSleepList(int userId, int hour, int minute, int kcal) {
		
		sleepDAO.addSleepList(userId, hour, minute, kcal);
	}
	
	//유저 아이디, 선택한 날짜를 매개로 수면 리스트 가져오기
	public Sleep selectSleepListByIdAndDate(int userId, String date) {
		
		return sleepDAO.selectSleepListByIdAndDate(userId, date);
	}
	
	//오늘 날짜 리스트 삭제하기
	public void deleteSleepListById(int id) {
		sleepDAO.deleteSleepListById(id);
	}
	
//	//총 수면 소비시간
//	public Sleep calculate(int userId) {
//		//유저id와 오늘 날짜를 매개로 리스트 가져오기
//		Sleep sleepList = selectSleepListById(userId);
//		
//		if(sleepList == null) {
//
//			return sleepList;
//		}
//		
//		int totalSleepHour = 0;
//		int totalSleepMinute = 0;
//		
//		int sleepHour = sleepList.getHour();
//		int sleepMinute = sleepList.getMinute();
//		
//		if(sleepMinute == 0) {
//			totalSleepHour = 24 - sleepHour;
//			logger.info("totalSleepHour:{}", totalSleepHour);
//		} else {
//			totalSleepHour = 23 - sleepHour;
//			logger.info("totalSleepHour:{}", totalSleepHour);
//			totalSleepMinute = 60 - sleepMinute;
//			logger.info("totalSleepMinute:{}", totalSleepMinute);
//		}
//		sleepList.setHour(totalSleepHour);
//		sleepList.setMinute(totalSleepMinute);
//		
//		return sleepList;
//	}
}
