package com.pksandbox.training.fat.activity;

import com.pksandbox.training.core.BasicObservable;

public class BasicActivityMonitor extends BasicObservable<ActivityUpdate>
		implements ActivityMonitor {

	public void setInput(String activityDescription, double caloriesBurned) {
		notifyObservers(new ActivityUpdate(activityDescription, caloriesBurned));
	}
}
