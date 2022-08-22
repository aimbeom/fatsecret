package com.fatsecret.diary;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatsecret.diary.bo.ExerciseBO;
import com.fatsecret.diary.bo.FoodListBO;
import com.fatsecret.diary.bo.SleepBO;
import com.fatsecret.diary.model.Exercise;
import com.fatsecret.diary.model.FoodList;
import com.fatsecret.diary.model.Sleep;

@RequestMapping("/diary")
@Controller
public class DiaryController {
	
	@Autowired
	private FoodListBO foodListBO;
	
	@Autowired
	private ExerciseBO exerciseBO;
	
	@Autowired
	private SleepBO sleepBO;
	
	/**
	 * 다이어트 캘린더
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/diary/diet_calendar_view
	@RequestMapping("/diet_calendar_view")
	public String dietDiary(
			@RequestParam(value="date", required=false) String date,
			@RequestParam(value="type", required=false) String type,
			Model model,
			HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		int recommendedKcal = (int) session.getAttribute("recommendedKcal");
		
		model.addAttribute("viewName", "diary/diet_diary");
		
		return "template/layout2";
	}
	
	/**
	 * 음식 다이어리
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/diary/food_diary_view
	@RequestMapping("/food_diary_view")
	public String foodDiary(
			@RequestParam(value="date", required=false) String date
			,Model model
			,HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		int recommendedKcal = (int) session.getAttribute("recommendedKcal");
		
		//아,점,저 음식 리스트
		List<FoodList> morningFoodList = foodListBO.getMorningFoodListByUserIdTimeType(userId, date);
		List<FoodList> lunchFoodList = foodListBO.getLunchFoodListByUserIdTimeType(userId, date);
		List<FoodList> dinnerFoodList = foodListBO.getDinnerFoodListByUserIdTimeType(userId, date);
		
		//탄단지칼 토탈
		FoodList mFoodList = foodListBO.mtotalAmount(userId, date);
		FoodList lFoodList = foodListBO.ltotalAmount(userId, date);
		FoodList dFoodList = foodListBO.dtotalAmount(userId, date);
		
		int kcalPercent = (int) foodListBO.kcalPercent(userId, date,recommendedKcal);
		
		//탄단지 달성률
		FoodList elementPercent = foodListBO.elementPercent(userId, date,recommendedKcal);
		
		model.addAttribute("viewName", "diary/food_diary");
		model.addAttribute("morningFoodList", morningFoodList);
		model.addAttribute("lunchFoodList", lunchFoodList);
		model.addAttribute("dinnerFoodList", dinnerFoodList);
		
		model.addAttribute("mFoodList", mFoodList);
		model.addAttribute("lFoodList", lFoodList);
		model.addAttribute("dFoodList", dFoodList);
		
		model.addAttribute("kcalPercent", kcalPercent);

		model.addAttribute("elementPercent", elementPercent);
		
		model.addAttribute("setDate", date);
		
		return "template/layout2";
	}
	
	/**
	 * 운동/휴식 다이어리
	 * @param model
	 * @param session
	 * @return
	 */
//	http://localhost:8080/diary/exercise_diary_view
	@RequestMapping("/exercise_diary_view")
	public String exerciseDairy(
			@RequestParam(value="date", required=false) String date
			,Model model
			,HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		
		List<Exercise> exerciseList = exerciseBO.getExerciseListByUserIdAndDate(userId, date);
		
		Exercise exercise = exerciseBO.calculate(userId, date);
		
		Sleep sleep = sleepBO.selectSleepListByIdAndDate(userId, date);
		
//		Sleep totalSleepTime = sleepBO.calculate(userId);
		
		model.addAttribute("viewName", "diary/exercise_diary");
		model.addAttribute("exerciseList", exerciseList);
		model.addAttribute("exercise", exercise);
		
		model.addAttribute("sleep", sleep);
//		model.addAttribute("totalSleepTime", totalSleepTime);
		
		model.addAttribute("setDate", date);
		
		return "template/layout2";
	}
	
	
	
	
	
////	http://localhost:8080/diary/test
//	@ResponseBody
//	@RequestMapping("/test")
//	public List<FoodList> test(Model model, HttpSession session) {
//		int userId = (int) session.getAttribute("userId");
//	
//		List<FoodList> morningFoodList = foodListBO.getMorningFoodListByUserIdTimeType(userId);
//		model.addAttribute("viewName", "diary/food_diary");
//		model.addAttribute("morningFoodList", morningFoodList);
//		
//		return morningFoodList;
//	}
	
	
}
