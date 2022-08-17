package com.fatsecret.diary;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatsecret.diary.bo.FoodListBO;
import com.fatsecret.diary.model.FoodList;

@RequestMapping("/diary")
@Controller
public class DiaryController {
	
	@Autowired
	private FoodListBO foodListBO;
	
	/**
	 * 다이어트 캘린더
	 * @param model
	 * @return
	 */
//	http://localhost:8080/diary/diet_calendar_view
	@RequestMapping("/diet_calendar_view")
	public String dietDiary(Model model) {
		
		model.addAttribute("viewName", "diary/diet_diary");
		
		return "template/layout2";
	}
	
	/**
	 * 음식 다이어리
	 * @param model
	 * @return
	 */
//	http://localhost:8080/diary/food_diary_view
	@RequestMapping("/food_diary_view")
	public String foodDiary(Model model, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
	
		List<FoodList> morningFoodList = foodListBO.getMorningFoodListByUserIdTimeType(userId);
		List<FoodList> lunchFoodList = foodListBO.getLunchFoodListByUserIdTimeType(userId);
		List<FoodList> dinnerFoodList = foodListBO.getDinnerFoodListByUserIdTimeType(userId);
		
		model.addAttribute("viewName", "diary/food_diary");
		model.addAttribute("morningFoodList", morningFoodList);
		model.addAttribute("lunchFoodList", lunchFoodList);
		model.addAttribute("dinnerFoodList", dinnerFoodList);
		
		return "template/layout2";
	}
	
	
	
//	http://localhost:8080/diary/test
	@ResponseBody
	@RequestMapping("/test")
	public List<FoodList> test(Model model, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
	
		List<FoodList> morningFoodList = foodListBO.getMorningFoodListByUserIdTimeType(userId);
		model.addAttribute("viewName", "diary/food_diary");
		model.addAttribute("morningFoodList", morningFoodList);
		
		return morningFoodList;
	}
	
	
}
