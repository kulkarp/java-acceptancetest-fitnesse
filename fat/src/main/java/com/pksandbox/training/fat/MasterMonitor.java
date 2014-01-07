package com.pksandbox.training.fat;

import com.pksandbox.training.alert.Alerter;
import com.pksandbox.training.core.Observer;
import com.pksandbox.training.fat.activity.ActivityMonitor;
import com.pksandbox.training.fat.food.FoodMonitor;


public class MasterMonitor<T> implements Observer<T>{
	private ActivityMonitor activityMonitor;
	private FoodMonitor foodMonitor;
	private Alerter soundAlerter;
	private Alerter messageAlerter;	
	
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	public ActivityMonitor getActivityMonitor() {
		return activityMonitor;
	}

	public void setActivityMonitor(ActivityMonitor activityMonitor) {
		this.activityMonitor = activityMonitor;
	}

	public FoodMonitor getFoodMonitor() {
		return foodMonitor;
	}

	public void setFoodMonitor(FoodMonitor foodMonitor) {
		this.foodMonitor = foodMonitor;
	}
	
}
