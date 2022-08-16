package com.fatsecret.timeline;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatsecret.post.bo.PostBO;
import com.fatsecret.post.model.Post;
import com.fatsecret.timeline.bo.TimelineBO;
import com.fatsecret.timeline.model.CardView;

@RequestMapping("/timeline")
@Controller
public class TimelineController {
	
	@Autowired
	TimelineBO timelineBO;
	
	
//	http://localhost:8080/timeline/timeline_view
	@RequestMapping("/timeline_view")
	public String timelineView(Model model, HttpSession session) {
		
		List<CardView> cardList = timelineBO.generateCardViewList((Integer) session.getAttribute("userId"));
		
		model.addAttribute("viewName", "/timeline/timeline");
		model.addAttribute("cardList", cardList);
		
		return	"template/layout2";
	}
}
