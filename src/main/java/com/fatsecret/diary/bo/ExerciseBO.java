package com.fatsecret.diary.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.dao.ExerciseDAO;
import com.fatsecret.diary.model.Exercise;

@Service
public class ExerciseBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExerciseDAO exerciseDAO;
	
	// 운동 리스트 추가
	public void addExerciseList(Integer userId, String name, int hour, int minute, int kcal, String date) {

		exerciseDAO.addExerciseList(userId, name, hour, minute, kcal, date);
	}

	// userId로 선택한 날짜 운동 리스트 가져오기
	public List<Exercise> getExerciseListByUserIdAndDate(Integer userId, String date) {

		return exerciseDAO.selectExerciseListByUserIdAndDate(userId, date);
	}
	
	// 운동 리스트 삭제하기
	public void deleteExerciseListById(int id) {
		
		exerciseDAO.deleteExerciseListById(id);
	}
	
	// userId로 해당 유저의 운동 리스트들 가져와 합산 계산
	public Exercise calculate(Integer userId, String date) {
		
		int totalHour = 0;
		int totalMinute = 0;
		int totalKcal = 0;

		List<Exercise> exerciseList = getExerciseListByUserIdAndDate(userId, date);
		
		Exercise exercise = new Exercise();
		for (int i = 0; i < exerciseList.size(); i++) {
			
			//리스트에 있는 칼로리,시간,분을 가져온다
			int kcal = exerciseList.get(i).getKcal();
			int hour = exerciseList.get(i).getHour();
			int minute = exerciseList.get(i).getMinute();
			
			//총 칼로리와 시간 합산
			totalHour += hour;
			totalMinute += minute;
			totalKcal += kcal;
			
			if(totalMinute == 60) {
				totalMinute = 0;
				totalHour += 1;
			}
			else if (totalMinute > 60) {
				totalMinute = (totalMinute - 60);
				totalHour += 1;
			}
			
			//Exercise에 대입
			exercise.setHour(totalHour);
			exercise.setMinute(totalMinute);
			exercise.setKcal(totalKcal);
		}
		return exercise;
	}
	
	// 유저의 운동 리스트 가져오기
	public List<Exercise> getExerciseList(Integer userId){
		
		return exerciseDAO.selectExerciseList(userId);
	}
	
}
