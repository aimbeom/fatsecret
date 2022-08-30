package com.fatsecret.diary.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatsecret.diary.model.DietCalendar;
import com.fatsecret.diary.model.TotalActivityList;
import com.fatsecret.diary.model.TotalFoodList;

public class DietCalendarBO {
	
	@Autowired
	private TotalFoodListBO totalFoodListBO;
	
	@Autowired
	private TotalActivityListBO toatlActivityListBO;
	
//	public List<DietCalendar> generateCalendar(int userId){
//		
//		List<DietCalendar> dietCalendarList = new ArrayList<>();
//		
//		List<TotalFoodList> totalFoodList = totalFoodListBO.getTotalFoodListByUserId(userId);
//		
//		List<TotalActivityList> totalActivityList =toatlActivityListBO.getTotalActivityListByUserId(userId);
//		
//		for(DietCalendar dietCalendar : dietCalendarList) {
//			
//			TotalFoodList totalFood = new TotalFoodList();
//			TotalActivityList totalActivity = new TotalActivityList();
//			
//			
//		}
//	}
}
