package com.pksandbox.training.fat.food;

public class FoodUpdate {
	private String foodConsumed;
	private double caloriesConsumed;
	
	public FoodUpdate(String foodConsumed, double caloriesConsumed) {
		this.foodConsumed = foodConsumed;
		this.caloriesConsumed = caloriesConsumed;
	}
	public String getFoodConsumed() {
		return foodConsumed;
	}
	public void setFoodConsumed(String foodConsumed) {
		this.foodConsumed = foodConsumed;
	}
	public double getCaloriesConsumed() {
		return caloriesConsumed;
	}
	public void setCaloriesConsumed(double caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
}
