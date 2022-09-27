package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.Exercise;

@Repository
public interface ExerciseDAO {
	
	//활동 리스트 추가
	public void addExerciseList(
			@Param("userId") Integer userId,
			@Param("name") String name,
			@Param("hour") int hour,
			@Param("minute") int timinuteme,
			@Param("kcal") int kcal,
			@Param("date") String date
			);
	
	// 선택한 날짜 리스트 가져오기
	public List<Exercise> selectExerciseListByUserIdAndDate(
			@Param("userId") Integer userId,
			@Param("date") String date
			);
	
	//리스트 삭제
	public void deleteExerciseListById(int id);
	
	// 유저의 활동 리스트 전부 가져오기
	public List<Exercise> selectExerciseList(Integer userId);
	
}
