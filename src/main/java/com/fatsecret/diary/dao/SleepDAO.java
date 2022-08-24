package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.Sleep;

@Repository
public interface SleepDAO {
	
	
	//수면 리스트 추가
	public void addSleepList(
			@Param("userId") int userId,
			@Param("hour") int hour,
			@Param("minute") int minute,
			@Param("kcal") int kcal
			);
	
	//userId, date를 매개로 선택한 날짜 데이터 뽑아오기
	public Sleep selectSleepListByIdAndDate(
			@Param("userId") int userId,
			@Param("date") String date
			);
	
	public void deleteSleepListById(int id);
	
	public boolean existSleep(int id);
	
	public void updateSleep(
			@Param("id") int id,
			@Param("userId") int userId,
			@Param("hour") int hour,
			@Param("minute") int minute,
			@Param("kcal") int kcal
			);
}
