package com.fatsecret.comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatsecret.comment.bo.CommentBO;

@RequestMapping("/comment")
@RestController
public class CommentRestcontroller {
	
	@Autowired
	CommentBO commentBO;
	
	/**
	 * 댓글 추가
	 * @param content
	 * @param postId
	 * @param session
	 * @return
	 */
	@PostMapping("/add_comment")
	public Map<String, Object> addComment(
			@RequestParam("content") String content,
			@RequestParam("postId") int postId,
			HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		int userId = (int) session.getAttribute("userId");
		result.put("result", "success");
		
		commentBO.addComment(userId, postId, content);
		
		return result;
	}
	
	/**
	 * 댓글 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete_comment")
	public Map<String, Object> deleteComment(
			@RequestParam("id") int id
			){
		
		Map<String, Object> result = new HashMap<>();
		
		commentBO.deleteCommentById(id);
		
		result.put("result", "success");
		
		return result;
	}
}
