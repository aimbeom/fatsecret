package com.fatsecret.diary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.diary.model.Exercise;

@Repository
public interface ExerciseDAO {
	
	public void addExerciseList(
			@Param("userId") int userId,
			@Param("name") String name,
			@Param("hour") int hour,
			@Param("minute") int timinuteme,
			@Param("kcal") int kcal
			);
	
	public List<Exercise> selectExerciseListByUserIdAndDate(
			@Param("userId") int userId,
			@Param("date") String date
			);
	
	public void deleteExerciseListById(int id);
	
	public List<Exercise> selectExerciseList(int userId);
	
}
