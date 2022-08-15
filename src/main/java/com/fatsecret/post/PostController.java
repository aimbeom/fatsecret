package com.fatsecret.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatsecret.post.bo.PostBO;
import com.fatsecret.post.model.Post;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	PostBO postBO;
	
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
	
	/**
	 * 글 수정
	 * @param postId
	 * @param model
	 * @return
	 */
//	http://localhost:8080/post/detail_view
	@RequestMapping("/detail_view")
	public String update(
			@RequestParam("postId") int postId,
			Model model) {
		model.addAttribute("viewName", "post/detail");
		
		Post post = postBO.getPostListByPostId(postId);
		
		model.addAttribute("post", post);
		
		return "template/layout";
	}
	
	
}
