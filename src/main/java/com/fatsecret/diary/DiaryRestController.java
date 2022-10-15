package com.fatsecret.diary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatsecret.diary.bo.ExerciseBO;
import com.fatsecret.diary.bo.FoodListBO;
import com.fatsecret.diary.bo.SleepBO;
import com.fatsecret.diary.bo.TotalActivityListBO;
import com.fatsecret.diary.bo.TotalFoodListBO;
import com.fatsecret.diary.model.TotalActivityList;
import com.fatsecret.diary.model.TotalFoodList;

@RequestMapping("/diary")
@RestController
public class DiaryRestController {
	
	@Autowired
	private FoodListBO foodListBO;
	
	@Autowired
	private ExerciseBO exerciseBO;
	
	@Autowired
	private SleepBO sleepBO;
	
	@Autowired
	private TotalFoodListBO totalFoodListBO;
	
	@Autowired
	private TotalActivityListBO totalActivityListBO;
	
	/**
	 * 식사 추가
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
	@PostMapping("/add_food")
	public Map<String, Object> addMorningFood(
			@RequestParam("timeType") String timeType
			, @RequestParam("foodName") String foodName
			, @RequestParam("amount") String amount
			, @RequestParam("carb") int carb
			, @RequestParam("protein") int protein
			, @RequestParam("fat") int fat
			, @RequestParam("kcal") int kcal
			, @RequestParam("date") String date
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		foodListBO.addFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal, date);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 식사 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete_food")
	public Map<String, Object> delFood(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		foodListBO.delFoodById(id);
		
		return result;
	}

	/**
	 * 운동 리스트 추가
	 * @param name
	 * @param hour
	 * @param minute
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/add_exercise")
	public Map<String, Object> addActivity(
			@RequestParam("name") String name,
			@RequestParam(value="hour", required=false) int hour,
			@RequestParam(value="minute", required=false) int minute,
			@RequestParam("kcal") int kcal,
			@RequestParam("date") String date,
			HttpSession session){
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int) session.getAttribute("userId");
		
		exerciseBO.addExerciseList(userId, name, hour, minute, kcal, date);
		
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
			@RequestParam("date") String date,
			HttpSession session){
		Map<String, Object> result = new HashMap<>();
		
		int userId = (int) session.getAttribute("userId");
		
		sleepBO.addSleepList(userId, hour, minute, kcal, date);
		
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
	
	/**
	 * 수면 리스트 수정
	 * @param id
	 * @param hour
	 * @param minute
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/update_sleep")
	public Map<String, Object> updateSleep(
			@RequestParam("id") int id,
			@RequestParam(value="hour", required=false) int hour,
			@RequestParam(value="minute", required=false) int minute,
			@RequestParam("kcal") int kcal,
			HttpSession session
			){
		
		int userId = (int) session.getAttribute("userId");
		
		Map<String, Object> result = new HashMap<>();
		
		sleepBO.updateSleep(id, userId, hour, minute, kcal);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 음식 총 리스트 추가
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
	@PostMapping("/add_total_food")
	public Map<String, Object> addTotalFood(
			@RequestParam("totalCarb") int totalCarb
			, @RequestParam("totalProtein") int totalProtein
			, @RequestParam("totalFat") int totalFat
			, @RequestParam("totalKcal") int totalKcal
			, @RequestParam("kcalPercent") int kcalPercent
			, @RequestParam("date") String date
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		totalFoodListBO.addTotalFoodList(userId, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent, date);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 총 음식 리스트 수정
	 * @param id
	 * @param totalCarb
	 * @param totalProtein
	 * @param totalFat
	 * @param totalKcal
	 * @param session
	 * @return
	 */
	@PostMapping("/update_total_food")
	public Map<String, Object> updateTotalFood(
			 @RequestParam("totalCarb") int totalCarb
			, @RequestParam("totalProtein") int totalProtein
			, @RequestParam("totalFat") int totalFat
			, @RequestParam("totalKcal") int totalKcal
			, @RequestParam("kcalPercent") int kcalPercent
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		TotalFoodList totalFood = totalFoodListBO.getTotalFoodByUserIdDESC(userId);
		
		int id = totalFood.getId();
		
		totalFoodListBO.updateTotalFoodList(id, totalCarb, totalProtein, totalFat, totalKcal, kcalPercent);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 총 운동 리스트 추가
	 * @param totalCarb
	 * @param totalProtein
	 * @param totalFat
	 * @param totalKcal
	 * @param kcalPercent
	 * @param session
	 * @return
	 */
	@PostMapping("/add_total_activity")
	public Map<String, Object> addTotalActivity(
			@RequestParam("kcal") int kcal
			, @RequestParam("date") String date
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		totalActivityListBO.addTotalActivityList(userId, kcal, date);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 총 운동 리스트 수정
	 * @param kcal
	 * @param session
	 * @return
	 */
	@PostMapping("/update_total_activity")
	public Map<String, Object> updateTotalActivity(
			@RequestParam("kcal") int kcal
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		
		TotalActivityList totalActivity = totalActivityListBO.getTotalActivityByUserIdDESC(userId);
		
		int id = totalActivity.getId();
		
		totalActivityListBO.updateTotalActivityByUserId(id,kcal);
		
		result.put("result", "success");
		
		return result;
	}

}
