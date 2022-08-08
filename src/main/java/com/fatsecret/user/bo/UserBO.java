package com.fatsecret.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fatsecret.common.FileManagerService;
import com.fatsecret.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private FileManagerService fileManager;
	
	public boolean getUserByNickName(String nickname) {
		
		return userDAO.selectUserByNickName(nickname);
	}
	
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
	
	public int calculateKcal() {
		
		return 3;
	}
}
