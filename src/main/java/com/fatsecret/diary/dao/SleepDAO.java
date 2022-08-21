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
	
	public Sleep selectSleepListById(int userId);
	
	public void deleteSleepListById(int id);
}
