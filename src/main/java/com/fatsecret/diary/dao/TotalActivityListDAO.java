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
	
	public TotalActivityList selectTotalActivityByUserId(
			@Param("userId") int userId);
	
	public List<TotalActivityList> selectTotalActivityListByUserId(
			@Param("userId") int userId);
	
	public void updateTotalActivityByUserId(
			@Param("id") int id
			,@Param("userId") int userId
			,@Param("kcal") int kcal
			);
}
