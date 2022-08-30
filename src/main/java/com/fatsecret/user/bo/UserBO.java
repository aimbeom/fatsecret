package com.fatsecret.user.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.common.FileManagerService;
import com.fatsecret.user.dao.UserDAO;
import com.fatsecret.user.model.User;

@Service
public class UserBO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private FileManagerService fileManager;
	
	//ID 중복확인
	public boolean getUserByNickName(String nickname) {
		
		return userDAO.selectUserByNickName(nickname);
	}
	
	//회원가입
	public void addUser(String gender, String name, int weight,
			int height, String birth, String amountOfActivity,
			String purpose, int targetWeight, String nickname,
			String password, String email, String content,
			MultipartFile file) {
		
		String imagePath = null;
		// 파일이 있으면 파일 업로드 => path 리턴 받음
		if (file != null) {
			imagePath = fileManager.saveFile(nickname, file);
		}
	
		userDAO.insertUser(gender, name, weight, height, birth, amountOfActivity, purpose, targetWeight, nickname, password, email, content, imagePath);
	}
	
	//권장 칼로리 계산
	public int calculateKcal(int userId) {
		User user = getUserByUserId(userId);
		//성별
		user.getGender();
		//키
		int height = user.getHeight();
		//표준 체중
		int standartWeight = (int) ((height-100)*0.9);
		//활동량
		String purpose = user.getAmountOfActivity();
		int acivityIndex;
		
		if(purpose == "정주") {
			acivityIndex = 25;
			int result = standartWeight * acivityIndex;
			logger.info("[권장칼로리] 결과값. result:{}", result);
			return result;
		} else if(purpose == "낮음") {
			acivityIndex = 30;
			int result = standartWeight * acivityIndex;
			logger.info("[권장칼로리] 결과값. result:{}", result);
			return result;
		} else if(purpose == "활동적") {
			acivityIndex = 35;
			int result = standartWeight * acivityIndex;
			logger.info("[권장칼로리] 결과값. result:{}", result);
			return result;
		} else {
			acivityIndex = 40;
			int result = standartWeight * acivityIndex;
			logger.info("[권장칼로리] 결과값. result:{}", result);
			return result;
		}
	}
	
	//로그인
	public User getUserByEmailPassword(String email, String password) {
		
		return userDAO.selectUserByEmailPassword(email, password);
	}
	
	//CardtView와 CommentCard에 뿌려줄 userList 가져오기 id값을 매개로 받아온다
	public User getUserByUserId(int id) {
		
		return userDAO.selectUserByUserId(id);
	}
	
	//몸무게 수정
	public void updateWeightByUserId(int id, int weight) {
		userDAO.updateWeightByUserId(id, weight);
	}
	
}
