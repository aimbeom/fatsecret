package com.fatsecret.diary.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.model.DietCalendar;
import com.fatsecret.diary.model.Exercise;
import com.fatsecret.diary.model.FoodList;
import com.fatsecret.diary.model.Sleep;

@Service
public class DietCalendarBO {

	@Autowired
	private ExerciseBO exerciseBO;

	@Autowired
	private FoodListBO foodListBO;

	@Autowired
	private SleepBO sleepBO;

//	public List<DietCalendar> generateDietCalendar(int userId, String date, String type, int recommendedKcal) {
//		List<DietCalendar> dietCalendarList = new ArrayList<>();
//
//		// food Dairy
//		// 유저의 음식 다이어리 가져오기
//		List<FoodList> foodList = foodListBO.getFoodList(userId);
//		foodListBO.totalAmount(userId, type, date);
//		
//		// exercise Diary
//		// 유저의 운동 다이어리 가져오기
//		List<Exercise> exerciseList = exerciseBO.getExerciseList(userId);
//		List<Sleep> sleepList = sleepBO.getSleepList(userId);
//	}
}
