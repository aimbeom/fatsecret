package com.fatsecret.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.user.model.User;

@Repository
public interface UserDAO {
	
	public boolean selectUserByNickName(String nickname);
	
	//회원가입
	public void insertUser(
			@Param ("gender") String gender,
			@Param ("name") String name,
			@Param ("weight") int weight,
			@Param ("height") int height,
			@Param ("birth") String birth,
			@Param ("amountOfActivity") String amountOfActivity,
			@Param ("purpose") String purpose,
			@Param ("targetWeight") int targetWeight,
			@Param ("nickname") String nickname,
			@Param ("password") String password,
			@Param ("email") String email,
			@Param ("content") String content,
			@Param ("imagePath") String imagePath
			);
	
	//public User selectUser();
	
	//로그인
	public User selectUserByEmailPassword(
			@Param ("email") String email,
			@Param ("password") String password
			);
	
	//CardtView와 CommentCard에 뿌려줄 userList 가져오기 id값을 매개로 받아온다
	public User selectUserByUserId(Integer id);
	
	//몸무게 수정
	public void updateWeightByUserId(
			@Param("id") Integer id,
			@Param("weight") int weight
			);
	
	//권장 칼로리 정보 가져오기
	public User selectCurrentUser();
	
	//프로필 이미지 수정
	public void updateMyImageByUserIdFile(
			@Param ("id") int id,
			@Param ("imagePath") String imagePath
			);
	
	//프로필 이미지 삭제
	public void updateMyImageNullById(int id);
}
