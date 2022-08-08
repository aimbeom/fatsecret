package com.fatsecret.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.user.bo.UserBO;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	UserBO userBO;
	
	@PostMapping("/is_duplicated_nickName")
	public Map<String, Object> isDuplicatedNickName(
			@RequestParam("nickname") String nickname
			) {
		
		Map<String, Object> result = new HashMap<>();
		boolean existNickName = userBO.getUserByNickName(nickname);
		
		result.put("result", existNickName);
		
		return result;
	}
	
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("gender") String gender,
			@RequestParam("name") String name,
			@RequestParam("weight") int weight,
			@RequestParam("height") int height,
			@RequestParam("birth") String birth,
			@RequestParam("amountOfActivity") String amountOfActivity,
			@RequestParam("purpose") String purpose,
			@RequestParam("targetWeight") int targetWeight,
			@RequestParam("nickname") String nickname,
			@RequestParam("email") String email,
			@RequestParam(value="content", required=false) String content,
			@RequestParam(value="file", required=false) MultipartFile file
			){
		
		Map<String, Object> result = new HashMap<>();
		userBO.addUser(gender, name, weight, height, birth, amountOfActivity, purpose, targetWeight, nickname, nickname, email, content, file);
		result.put("result", "success");
		result.put("errorMessage", "회원가입 실패");
		
		
		
		return result;
	}
}
