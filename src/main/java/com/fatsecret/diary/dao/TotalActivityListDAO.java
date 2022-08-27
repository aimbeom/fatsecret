package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.TotalActivityList;

@Repository
public interface TotalActivityListDAO {
	
	public void insertTotalActivityList(
			@Param("userId") int userId,
			@Param("kcal") int kcal);
	
	public TotalActivityList selectTotalActivity(
			@Param("userId") int userId,
			@Param("date") String date);
	
	public List<TotalActivityList> selectTotalActivityList(
			@Param("userId") int userId);
}
