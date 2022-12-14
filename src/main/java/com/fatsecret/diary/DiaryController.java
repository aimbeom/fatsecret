package com.fatsecret.diary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatsecret.diary.bo.ExerciseBO;
import com.fatsecret.diary.bo.FoodListBO;
import com.fatsecret.diary.bo.SleepBO;
import com.fatsecret.diary.bo.TotalActivityListBO;
import com.fatsecret.diary.bo.TotalFoodListBO;
import com.fatsecret.diary.model.Exercise;
import com.fatsecret.diary.model.FoodList;
import com.fatsecret.diary.model.Sleep;
import com.fatsecret.diary.model.TotalActivityList;
import com.fatsecret.diary.model.TotalFoodList;
import com.fatsecret.user.bo.UserBO;
import com.fatsecret.user.model.User;

@RequestMapping("/diary")
@Controller
public class DiaryController {
	
	@Autowired
	private FoodListBO foodListBO;

	@Autowired
	private ExerciseBO exerciseBO;

	@Autowired
	private SleepBO sleepBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private TotalFoodListBO totalFoodListBO;
	
	@Autowired
	private TotalActivityListBO totalActivityListBO;
	
	/**
	 * 다이어트 캘린더
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/diary/diet_calendar_view
	@RequestMapping("/diet_calendar_view")
	public String dietDiary(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");
		int recommendedKcal = (int) session.getAttribute("recommendedKcal");
		
		//유저의 전체 음식 리스트 가져오기
		List<TotalFoodList> totalFoodList = totalFoodListBO.getTotalFoodListByUserId(userId);
		
		//유저의 전체 활동 리스트 가져오기
		List<TotalActivityList> totalActivityList = totalActivityListBO.getTotalActivityListByUserId(userId);
		User user = userBO.getUserByUserId(userId);
		
		//오늘날짜 토탈 음식, 운동 리스트 유무 확인
		TotalFoodList lastTotalFoodList = totalFoodListBO.getTotalFoodListByUserIdCreatedAt(userId);
		TotalActivityList lastTotalActivityList = totalActivityListBO.getTotalActivityByUserIdCreatedAt(userId);
		
		model.addAttribute("viewName", "diary/diet_diary");
		model.addAttribute("totalFoodList", totalFoodList);
		model.addAttribute("totalActivityList", totalActivityList);
		
		model.addAttribute("lastTotalFoodList", lastTotalFoodList);
		model.addAttribute("lastTotalActivityList", lastTotalActivityList);
		
		model.addAttribute("user", user);
		
		
		
		return "template/layout2";
	}

	/**
	 * 음식 다이어리
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/diary/food_diary_view
	@RequestMapping("/food_diary_view")
	public String foodDiary(
			@RequestParam(value = "date", required = false) String date, 
			Model model,
			HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		int recommendedKcal = (int) session.getAttribute("recommendedKcal");

		User user = userBO.getUserByUserId(userId);
		
		// 아,점,저 음식 리스트
		List<FoodList> morningFoodList = foodListBO.getFoodListByUserIdTimeTypeDate(userId, "아침", date);
		List<FoodList> lunchFoodList = foodListBO.getFoodListByUserIdTimeTypeDate(userId, "점심", date);
		List<FoodList> dinnerFoodList = foodListBO.getFoodListByUserIdTimeTypeDate(userId, "저녁", date);

		// 탄단지칼 토탈
		FoodList mTotalFoodList = foodListBO.totalAmount(userId, "아침", date);
		FoodList lTotalFoodList = foodListBO.totalAmount(userId, "점심", date);
		FoodList dTotalFoodList = foodListBO.totalAmount(userId, "저녁", date);
		
		//선택한 날짜 토탈 리스트 유무 확인
		TotalFoodList totalFoodListDate = totalFoodListBO.getTotalFoodByUserIdDate(userId, date);
		
		// 당일 섭취량 백분율
		int kcalPercent = (int) foodListBO.kcalPercent(userId, date, recommendedKcal);
		
		// 탄단지 달성률
		FoodList elementPercent = foodListBO.elementPercent(userId, date, recommendedKcal);

		model.addAttribute("viewName", "diary/food_diary");
		
		model.addAttribute("morningFoodList", morningFoodList);
		model.addAttribute("lunchFoodList", lunchFoodList);
		model.addAttribute("dinnerFoodList", dinnerFoodList);

		model.addAttribute("mTotalFoodList", mTotalFoodList);
		model.addAttribute("lTotalFoodList", lTotalFoodList);
		model.addAttribute("dTotalFoodList", dTotalFoodList);
		
		model.addAttribute("totalFoodListDate", totalFoodListDate);

		model.addAttribute("kcalPercent", kcalPercent);

		model.addAttribute("elementPercent", elementPercent);

		model.addAttribute("setDate", date);
		
		model.addAttribute("user", user);
		
		return "template/layout2";
	}

	/**
	 * 운동/휴식 다이어리
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/diary/exercise_diary_view
	@RequestMapping("/exercise_diary_view")
	public String exerciseDairy(@RequestParam(value = "date", required = false) String date, Model model,
			HttpSession session) {
		
		//세션에서 유저 id 받아오기
		Integer userId = (Integer) session.getAttribute("userId");
		
		//유저의 선택 날짜 운동 리스트 전부 가져오기
		List<Exercise> exerciseList = exerciseBO.getExerciseListByUserIdAndDate(userId, date);
		
		
		Exercise exercise = exerciseBO.calculate(userId, date);
		
		Sleep sleep = sleepBO.selectSleepListByIdAndDate(userId, date);
		
		User user = userBO.getUserByUserId(userId);
		
		// 활동 토탈 소모 칼로리
		TotalActivityList totalActivity = totalActivityListBO.getTotalActivityByUserId(userId);
		
		model.addAttribute("viewName", "diary/exercise_diary");
		
		model.addAttribute("exerciseList", exerciseList);
		
		model.addAttribute("exercise", exercise);

		model.addAttribute("totalActivity", totalActivity);
		
		model.addAttribute("sleep", sleep);

		model.addAttribute("setDate", date);
		
		model.addAttribute("user", user);
		
		return "template/layout2";
	}

}
