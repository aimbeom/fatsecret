package com.fatsecret.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatsecret.post.bo.PostBO;
import com.fatsecret.post.model.Post;
import com.fatsecret.user.bo.UserBO;
import com.fatsecret.user.model.User;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	PostBO postBO;
	
	@Autowired
	UserBO userBO;
	
	/**
	 * 글쓰기 페이지
	 * @param model
	 * @return
	 */
//	http://localhost:8080/post/write_view	
	@RequestMapping("/write_view")
	public String write(Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userBO.getUserByUserId(userId);
		
		model.addAttribute("viewName", "post/write");
		model.addAttribute("user", user);
		
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
			HttpSession session,
			Model model) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userBO.getUserByUserId(userId);
		
		model.addAttribute("viewName", "post/detail");
		
		Post post = postBO.getPostListByPostId(postId);
		model.addAttribute("user", user);
		
		model.addAttribute("post", post);
		
		return "template/layout";
	}
	
	
}
