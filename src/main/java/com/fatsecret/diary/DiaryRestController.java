package com.fatsecret.diary;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatsecret.diary.bo.ExerciseBO;
import com.fatsecret.diary.bo.FoodListBO;
import com.fatsecret.diary.bo.SleepBO;

@RequestMapping("/diary")
@RestController
public class DiaryRestController {
	
	@Autowired
	private FoodListBO foodListBO;
	
	@Autowired
	private ExerciseBO exerciseBO;
	
	@Autowired
	private SleepBO sleepBO;
	
	/**
	 * 아침식사 추가
	 * @param timeType
	 * @param foodName
	 * @param amount
	 * @param carb
	 * @param protein
	 * @param fat
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/add_morning_food")
	public Map<String, Object> addMorningFood(
			@RequestParam("timeType") String timeType
			, @RequestParam("foodName") String foodName
			, @RequestParam("amount") String amount
			, @RequestParam("carb") int carb
			, @RequestParam("protein") int protein
			, @RequestParam("fat") int fat
			, @RequestParam("kcal") int kcal
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		foodListBO.addMorningFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 아침식사 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete_morning_food")
	public Map<String, Object> delMorningFood(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		foodListBO.delMorningFoodListById(id);
		
		return result;
	}
	
	/**
	 * 점심식사 추가
	 * @param timeType
	 * @param foodName
	 * @param amount
	 * @param carb
	 * @param protein
	 * @param fat
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/add_lunch_food")
	public Map<String, Object> addLunchFood(
			@RequestParam("timeType") String timeType
			, @RequestParam("foodName") String foodName
			, @RequestParam("amount") String amount
			, @RequestParam("carb") int carb
			, @RequestParam("protein") int protein
			, @RequestParam("fat") int fat
			, @RequestParam("kcal") int kcal
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		foodListBO.addLunchFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 점심식사 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete_lunch_food")
	public Map<String, Object> delLunchFood(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		foodListBO.delLunchFoodListById(id);
		
		return result;
	}
	
	/**
	 * 저녁식사 추가
	 * @param timeType
	 * @param foodName
	 * @param amount
	 * @param carb
	 * @param protein
	 * @param fat
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/add_dinner_food")
	public Map<String, Object> addDinnerFood(
			@RequestParam("timeType") String timeType
			, @RequestParam("foodName") String foodName
			, @RequestParam("amount") String amount
			, @RequestParam("carb") int carb
			, @RequestParam("protein") int protein
			, @RequestParam("fat") int fat
			, @RequestParam("kcal") int kcal
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		foodListBO.addDinnerFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 저녁식사 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete_dinner_food")
	public Map<String, Object> delDinnerFood(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		foodListBO.delDinnerFoodListById(id);
		
		return result;
	}
	
	/**
	 * 활동 리스트 추가
	 * @param activityName
	 * @param activityTime
	 * @param kcal
	 * @param session
	 * @return
	 */
	
	
	/**
	 * 운동 리스트 추가
	 * @param name
	 * @param hour
	 * @param minute
	 * @param kcal
	 * @param session
	 * @return
	 */
	//활동 리스트 추가
	@PostMapping("/add_exercise")
	public Map<String, Object> addActivity(
			@RequestParam("name") String name,
			@RequestParam(value="hour", required=false) int hour,
			@RequestParam(value="minute", required=false) int minute,
			@RequestParam("kcal") int kcal,
			HttpSession session){
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int) session.getAttribute("userId");
		
		exerciseBO.addExerciseList(userId, name, hour, minute, kcal);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 운동 리스트 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete_exercise")
	public Map<String, Object> delActivity(
			@RequestParam("id") int id
			){
		
		Map<String, Object> result = new HashMap<>();
		
		exerciseBO.deleteExerciseListById(id);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 수면 리스트 추가
	 * @param hour
	 * @param minute
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/add_sleep")
	public Map<String, Object> addSleep(
			@RequestParam(value="hour", required=false) int hour,
			@RequestParam(value="minute", required=false) int minute,
			@RequestParam("kcal") int kcal,
			HttpSession session){
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int) session.getAttribute("userId");
		
		sleepBO.addSleepList(userId, hour, minute, kcal);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 수면 리스트 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete_sleep")
	public Map<String, Object> delSleep(
			@RequestParam("id") int id
			){
		
		Map<String, Object> result = new HashMap<>();
		
		sleepBO.deleteSleepListById(id);
		
		result.put("result", "success");
		
		return result;
	}
}
