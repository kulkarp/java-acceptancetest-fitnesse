package com.pksandbox.training.fat.food;

import com.pksandbox.training.core.BasicObservable;


public class BasicFoodMonitor extends
BasicObservable<FoodUpdate> implements FoodMonitor{
	
	public void setInput(String foodConsumed, double caloriesConsumed){
		notifyObservers(new FoodUpdate(foodConsumed, caloriesConsumed));
	}

}
