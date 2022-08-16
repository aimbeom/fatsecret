package com.fatsecret.diary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/diary")
@Controller
public class DiaryController {
	
	/**
	 * 다이어트 캘린더
	 * @param model
	 * @return
	 */
//	http://localhost:8080/diary/diet_view
	@RequestMapping("/diet_view")
	public String dietDiary(Model model) {
		
		model.addAttribute("viewName", "diary/diet_diary");
		
		return "template/layout2";
	}
	
//	http://localhost:8080/diary/diet_view
	@RequestMapping("/diet_view")
	public String foodDiary(Model model) {
		
		model.addAttribute("viewName", "diary/food_diary");
		
		return "template/layout2";
	}
}
