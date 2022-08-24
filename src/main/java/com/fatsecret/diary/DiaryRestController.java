package com.fatsecret.diary;

import java.util.HashMap;
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
			, HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		
		foodListBO.addFoodList(userId, timeType, foodName, amount, carb, protein, fat, kcal);
		
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
	
//	@PostMapping("update_food"){
//		public Map
//	}
	
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
}
