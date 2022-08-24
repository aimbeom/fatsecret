package com.fatsecret.diary.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatsecret.diary.model.DietCalendar;

@Service
public class DietCalendarBO {

	@Autowired
	private ExerciseBO exerciseBO;

	@Autowired
	private FoodListBO foodListBO;

	@Autowired
	private SleepBO sleepBO;

//	public List<DietCalendar> generateDietCalendar(int userId, String date, String type, int recommendedKcal) {
//
//		List<DietCalendar> dietCalendarList = new ArrayList<>();
//
//		for (int i = 0; i < dietCalendarList.size(); i++) {
//			DietCalendar dietCalendar = new DietCalendar();
//			
//			if (type == "food") {
//				
//				// 아침 총 탄단지칼
//				int mCarb = foodListBO.mtotalAmount(userId, date).getCarb();
//				int mProtein = foodListBO.mtotalAmount(userId, date).getProtein();
//				int mFat = foodListBO.mtotalAmount(userId, date).getFat();
//				int mKcal = foodListBO.mtotalAmount(userId, date).getKcal();
//				// 점심 총 탄단지칼
//				int lCarb = foodListBO.ltotalAmount(userId, date).getCarb();
//				int lProtein = foodListBO.ltotalAmount(userId, date).getProtein();
//				int lFat = foodListBO.ltotalAmount(userId, date).getFat();
//				int lKcal = foodListBO.ltotalAmount(userId, date).getKcal();
//				// 저녁 총 탄단지칼
//				int dCarb = foodListBO.dtotalAmount(userId, date).getCarb();
//				int dProtein = foodListBO.dtotalAmount(userId, date).getProtein();
//				int dFat = foodListBO.dtotalAmount(userId, date).getFat();
//				int dKcal = foodListBO.dtotalAmount(userId, date).getKcal();
//				// 해당 날짜 총 탄단지칼
//				int totalCarb = mCarb + lCarb + dCarb;
//				int totalProtein = mProtein + lProtein + dProtein;
//				int totalFat = mFat + lFat + dFat;
//				int totalKcal = mKcal + lKcal + dKcal;
//
//				// 총 탄단지칼 대입
//				dietCalendar.getFoodList().setCarb(totalCarb);
//				dietCalendar.getFoodList().setProtein(totalProtein);
//				dietCalendar.getFoodList().setFat(totalFat);
//				dietCalendar.getFoodList().setKcal(totalKcal);
//				
//				//당일 섭취량 백분율
//				foodListBO.kcalPercent(userId, date, recommendedKcal);
//				
//				exerciseBO.
//			}
//		}
//	}
}
