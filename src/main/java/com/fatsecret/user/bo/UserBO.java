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
	public User getUserByUserId(Integer id) {
		
		return userDAO.selectUserByUserId(id);
	}
	
	//몸무게 수정
	public void updateWeightByUserId(int id, int weight) {
		userDAO.updateWeightByUserId(id, weight);
	}
	
	//권장 칼로리 정보 가져오기
	public User getCurrentUser() {
		return userDAO.selectCurrentUser();
	}
	
	//내 이미지 업데이트
	public void updateMyImageByUserIdFile(int id, String nickname, MultipartFile file) {
		
		User user = getUserByUserId(id);
		
		String imagePath = null;
		// 파일이 있으면 파일 업로드 => path 리턴 받음
		if (file != null) {
			imagePath = fileManager.saveFile(nickname, file);
		
			// 새로 업로드된 이미지가 성공하면 기존 이미지 삭제(기존 이미지가 있을 때에만)
			if(imagePath != null && user.getImagePath() != null) {
				// 기존 이미지 삭제
				try {
					fileManager.deleteFile(user.getImagePath());
				} catch (Exception e) {
					logger.error("이미지 삭제 실패");
				}
			}
		}
		userDAO.updateMyImageByUserIdFile(id, imagePath);
	}
	
	public void  updateMyImageNullById(int id) {
		
		userDAO.updateMyImageNullById(id);
	}
	
}
