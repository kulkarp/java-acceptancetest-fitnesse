package com.pksandbox.training.fat.activity;

public class ActivityUpdate {
	private String activityPerformed;
	private double caloriesBurned;
	public ActivityUpdate(String activityPerformed, double caloriesBurned) {
		this.activityPerformed = activityPerformed;
		this.caloriesBurned = caloriesBurned;
	}
	public String getActivityPerformed() {
		return activityPerformed;
	}
	public void setActivityPerformed(String activityPerformed) {
		this.activityPerformed = activityPerformed;
	}
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
}
