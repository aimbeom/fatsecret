package com.fatsecret.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.post.bo.PostBO;
import com.fatsecret.post.model.Post;

@RequestMapping("/post")
@RestController
public class PostRestController {
	
	@Autowired
	PostBO postBO;
	
	@PostMapping("/write")
	public Map<String, Object> write(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("file") MultipartFile file,
			HttpSession session
			){
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		
		//글쓴이 정보를 세션에서 꺼낸다, 꺼내야 할 정보가 세션에 있는지 없는지 유무 확인까지
		Object userIdObject = session.getAttribute("userId"); //꺼낼때는 원래의 type이 아닌 object로 꺼낸다
				
		//로그인 되어있지 않음
		if(userIdObject == null) { 
			result.put("result", "error");
			result.put("errorMessage", "로그인 후 사용 가능합니다.");
			
			return result;
		}
				
		//로그인이 된 사용자
		int userId = (int)userIdObject;
		String userNickname = (String)session.getAttribute("userNickname");
		
		//bo 전송/수신
		postBO.addPost(userId, userNickname, title, content, file);
		
		return result;
	}
	
	/**
	 * 글 삭제
	 * @param postId
	 * @param session
	 * @return
	 */
	@DeleteMapping("delete")
	public Map<String, Object> delete(
			@RequestParam("postId") int postId,
			HttpSession session
			){
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		result.put("errorMessage", "실패");
		
		int userId = (int) session.getAttribute("userId");
		postBO.deletePostByPostIdUserId(postId, userId);
		
		return result;
	}
	
	/**
	 * 글 수정
	 * @param postId
	 * @param subject
	 * @param content
	 * @param file
	 * @param session
	 * @return
	 */
	@PutMapping("/update")
	public Map<String, Object> update(
			@RequestParam("postId") int postId,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam(value="file", required=false) MultipartFile file,
			HttpSession session
			){
		// 로그인 된 사람만 도달했는지 검사 => 나중에
		String userNickname = (String)session.getAttribute("userNickname");
		int userId = (int)session.getAttribute("userId");
		
		//db update
		int row = postBO.updatePost(userId, userNickname, postId, title, content, file);
		
		//성공 여부
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		if(row < 1) {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	
//	http://localhost:8080/post/test
	//받아온 정보 확인하는 테스트
	@RequestMapping("/test")
	public List<Post> test(){
		
		List<Post> result = postBO.getPostList();
		
		return result;
	}
}
