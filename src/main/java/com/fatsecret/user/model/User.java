package com.fatsecret.user.model;

import java.util.Date;

public class User {
	
	private int id;
	private String gender;
	private String name;
	private int weight;
	private int height;
	private String birth;
	private String amountOfActivity;
	private String purpose;
	private int targetWeight;
	private String nickname;
	private String password;
	private String email;
	private String content;
	private String imagePath;
	private int startWeight;
	private Date createdAt;
	private Date updatedAt;

	public int getStartWeight() {
		return startWeight;
	}
	
	public void setStartWeight(int startWeight) {
		this.startWeight = startWeight;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAmountOfActivity() {
		return amountOfActivity;
	}
	public void setAmountOfActivity(String amountOfActivity) {
		this.amountOfActivity = amountOfActivity;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getTargetWeight() {
		return targetWeight;
	}
	public void setTargetWeight(int targetWeight) {
		this.targetWeight = targetWeight;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
