package com.fatsecret.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatsecret.like.bo.LikeBO;

@RequestMapping("/like")
@RestController
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	// 선택한 게시글의 번호를 url로 직접 받는다
	@RequestMapping("/{postId}")
	public Map<String, Object> like(
			@PathVariable int postId,
			HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		//유저 정보 불러오기
		Integer userId = (Integer) session.getAttribute("userId");
		
		likeBO.like(userId, postId);
		
		return result;
	}
}
