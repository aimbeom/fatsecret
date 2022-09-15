package com.fatsecret.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.common.EncryptUtils;
import com.fatsecret.user.bo.UserBO;
import com.fatsecret.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	UserBO userBO;
	
	//닉네임 중복확인
	@PostMapping("/is_duplicated_nickName")
	public Map<String, Object> isDuplicatedNickName(
			@RequestParam("nickname") String nickname
			) {
		
		Map<String, Object> result = new HashMap<>();
		boolean existNickName = userBO.getUserByNickName(nickname);
		
		result.put("result", existNickName);
		
		return result;
	}
	
	//회원가입
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
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam(value="content", required=false) String content,
			@RequestParam(value="file", required=false) MultipartFile file,
			HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		
		
		//비밀번호 암호화(md5, SHA256, 512)
		String encryptPassword = EncryptUtils.md5(password);
		
		userBO.addUser(gender, name, weight, height, birth, amountOfActivity, purpose, targetWeight, nickname, encryptPassword, email, content, file);
		result.put("result", "success");
		result.put("errorMessage", "회원가입 실패");
		
		return result;
	}
	
	//로그인
	@PostMapping("/sign_in")
	public Map<String, Object> login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpServletRequest request
			){
		Map<String, Object> result = new HashMap<>();
		
		
		
		//패스워드 암호화
		String encryptPassword = EncryptUtils.md5(password); 
		
		User user = userBO.getUserByEmailPassword(email, encryptPassword);
		
		if(user != null) {
			// 로그인 ok
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userEmail", user.getEmail());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userNickname", user.getNickname());
			session.setAttribute("userHeight", user.getHeight());
			session.setAttribute("userStartWeight", user.getStartWeight());
			session.setAttribute("userBirth", user.getBirth());
			session.setAttribute("userPurpose", user.getPurpose());
			session.setAttribute("userTargetWeight", user.getTargetWeight());
			session.setAttribute("userImage", user.getImagePath());
			session.setAttribute("userContent", user.getContent());
			
			//권장 칼로리량
			int recommendedKcal = userBO.calculateKcal(user.getId());
			
			session.setAttribute("recommendedKcal", recommendedKcal);
			result.put("result", "success");
		}
		
		return result;
	}
	
	/**
	 * 내 체중 수정
	 * @param weight
	 * @param session
	 * @return
	 */
	@PostMapping("/weight_update")
	public Map<String, Object> weightUpdate(
			@RequestParam("weight") int weight,
			HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		
		Integer id = (Integer)session.getAttribute("userId");
		userBO.updateWeightByUserId(id, weight);
		
		result.put("result", "success");
		
		return result;
	}
	
	/**
	 * 프로필 이미지 수정
	 * @param id
	 * @param file
	 * @param session
	 * @return
	 */
	@PostMapping("/my_image_update")
	public Map<String, Object> weightUpdate(
			@RequestParam("id") int id,
			@RequestParam(value="file", required=false) MultipartFile file,
			HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		
		String nickname = (String) session.getAttribute("userNickname");
		
		userBO.updateMyImageByUserIdFile(id, nickname, file);
		
		result.put("result", "success");
		result.put("errorMessage", "수정 실패");
		return result;
	}
	
	/**
	 * 프로필 이미지 삭제
	 * @param id
	 * @param session
	 * @return
	 */
	@PostMapping("/delete_my_image")
	public Map<String, Object> deleteMyImage(
			@RequestParam("id") int id,
			HttpSession session
			){
		Map<String, Object> result = new HashMap<>();
		
		userBO.updateMyImageNullById(id);
		
		result.put("result", "success");
		result.put("errorMessage", "수정 실패");
		return result;
	}

}
