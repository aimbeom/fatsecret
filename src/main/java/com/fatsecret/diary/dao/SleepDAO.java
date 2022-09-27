package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.Sleep;

@Repository
public interface SleepDAO {
	
	
	//수면 리스트 추가
	public void addSleepList(
			@Param("userId") Integer userId,
			@Param("hour") int hour,
			@Param("minute") int minute,
			@Param("kcal") int kcal,
			@Param("date") String date
			);
	
	//userId, date를 매개로 선택한 날짜 데이터 뽑아오기
	public Sleep selectSleepListByIdAndDate(
			@Param("userId") Integer userId,
			@Param("date") String date
			);
	
	//수면 리스트 삭제
	public void deleteSleepListById(int id);
	
	//수면 리스트 수정
	public void updateSleep(
			@Param("id") int id,
			@Param("userId") Integer userId,
			@Param("hour") int hour,
			@Param("minute") int minute,
			@Param("kcal") int kcal
			);
	
	//유저의 전체 수면 리스트 가져오기
	public List<Sleep> selectSleepList(Integer userId);
}
