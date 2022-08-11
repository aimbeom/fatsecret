package com.fatsecret.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {
	
	/**
	 * 글쓰기 페이지
	 * @param model
	 * @return
	 */
//	http://localhost:8080/post/write_view	
	@RequestMapping("/write_view")
	public String write(Model model) {
		model.addAttribute("viewName", "post/write");
		
		return "template/layout";
	}
}
