package com.fatsecret.diary.model;

public class DietCalendar {
	
	private Exercise exercise;
	private FoodList foodList;
	private Sleep Sleep;
	
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	public FoodList getFoodList() {
		return foodList;
	}
	public void setFoodList(FoodList foodList) {
		this.foodList = foodList;
	}
	public Sleep getSleep() {
		return Sleep;
	}
	public void setSleep(Sleep sleep) {
		Sleep = sleep;
	}
	
	
	
}
