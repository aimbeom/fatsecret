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

	@Autowired
	private SleepDAO sleepDAO;

	// 수면 리스트 추가
	public void addSleepList(int userId, int hour, int minute, int kcal) {

		sleepDAO.addSleepList(userId, hour, minute, kcal);
	}

	// 유저 아이디, 선택한 날짜를 매개로 수면 리스트 가져오기
	public Sleep selectSleepListByIdAndDate(int userId, String date) {

		return sleepDAO.selectSleepListByIdAndDate(userId, date);
	}

	// 오늘 날짜 리스트 삭제하기
	public void deleteSleepListById(int id) {
		sleepDAO.deleteSleepListById(id);
	}	

	// 수면 리스트 수정
	public void updateSleep(int id, int userId, int hour, int minute, int kcal) {

		sleepDAO.updateSleep(id, userId, hour, minute, kcal);
	}
}
