package com.fatsecret.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fatsecret.user.model.User;

@Repository
public interface UserDAO {
	
	public boolean selectUserByNickName(String nickname);
	
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
	
	public User selectUser();
	
	public User selectUserByEmailPassword(
			@Param ("email") String email,
			@Param ("password") String password
			);
	
	public User selectUserByUserId(int id);
	
	public void updateWeightByUserId(
			@Param("id") int id,
			@Param("weight") int weight
			);
	
	public User selectCurrentUser();
}
