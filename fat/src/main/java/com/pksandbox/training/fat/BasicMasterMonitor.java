package com.pksandbox.training.fat;

import java.util.Date;

import com.pksandbox.training.alert.Alerter;
import com.pksandbox.training.core.Observer;
import com.pksandbox.training.core.Subject;
import com.pksandbox.training.fat.activity.ActivityUpdate;
import com.pksandbox.training.fat.food.FoodUpdate;
import com.pksandbox.training.history.HistoryTracker;
import com.pksandbox.training.user.UserSettingsUpdate;

public class BasicMasterMonitor {

	private Observer<FoodUpdate> foodObserver;
	private Observer<ActivityUpdate> activityObsever;
	private Observer<UserSettingsUpdate> userSettingsObserver;
	private HistoryTracker historyTracker;
	private Alerter messageAlerter;
	private double caloriesBurned;
	private boolean isGoalAchieved = false;

	private FoodUpdate lastFoodUpdate;
	private ActivityUpdate lastActivityUpdate;
	private UserSettingsUpdate lastUserSettingsUpdate;

	private Alerter soundAlerter;
	private static String foodHistoricalUpdatePlaceHolder = "Food update received - Consumed {0}  @ {1} Calories";
	private String activityHistoricalUpdatePlaceHolder = "Activity update received - Performed {0}  burining {1} Calories";
	private String userSettingHistoricalUpdatePlaceHolder = "User settings update received - Weight {0}, Target {1}";

	public BasicMasterMonitor(Subject<FoodUpdate> foodSubject,
			Subject<ActivityUpdate> activitySubject,
			Subject<UserSettingsUpdate> userSettingsSubject) {
		subscribeToFoodUpdates(foodSubject);
		subscribeToActivityUpdates(activitySubject);
		subscribeToUserSettingsUpdate(userSettingsSubject);
	}

	public HistoryTracker getHistoryTracker() {
		return historyTracker;
	}

	public void setHistoryTracker(HistoryTracker historyTracker) {
		this.historyTracker = historyTracker;
	}

	public Alerter getMessageAlerter() {
		return messageAlerter;
	}

	public void setMessageAlerter(Alerter messageAlerter) {
		this.messageAlerter = messageAlerter;
	}

	public Alerter getSoundAlerter() {
		return soundAlerter;
	}

	public void setSoundAlerter(Alerter soundAlerter) {
		this.soundAlerter = soundAlerter;
	}

	private void subscribeToFoodUpdates(Subject<FoodUpdate> foodSubject) {
		foodObserver = new Observer<FoodUpdate>() {

			public void update(FoodUpdate foodUpdate) {
				historyTracker.addHistory(
						new Date(),
						foodHistoricalUpdatePlaceHolder.format(
								foodUpdate.getFoodConsumed(),
								foodUpdate.getCaloriesConsumed()));
				lastFoodUpdate = foodUpdate;
				caloriesBurned += foodUpdate.getCaloriesConsumed();
				applyRule();
			}
		};
		foodSubject.addObserver(foodObserver);
	}

	private void subscribeToActivityUpdates(
			Subject<ActivityUpdate> activitySubject) {
		activityObsever = new Observer<ActivityUpdate>() {

			public void update(ActivityUpdate activityUpdate) {
				historyTracker.addHistory(new Date(),
						activityHistoricalUpdatePlaceHolder.format(
								activityUpdate.getActivityPerformed(),
								activityUpdate.getCaloriesBurned()));
				lastActivityUpdate = activityUpdate;
				caloriesBurned -= activityUpdate.getCaloriesBurned();
				applyRule();
			}
		};
		activitySubject.addObserver(activityObsever);
	}

	private void subscribeToUserSettingsUpdate(
			Subject<UserSettingsUpdate> userSettingsSubject) {
		userSettingsObserver = new Observer<UserSettingsUpdate>() {

			public void update(UserSettingsUpdate userSettingsUpdate) {
				historyTracker.addHistory(new Date(),
						userSettingHistoricalUpdatePlaceHolder.format(
								String.valueOf(userSettingsUpdate.getWeight()),
								userSettingsUpdate.getTargetIntake()));
				lastUserSettingsUpdate = userSettingsUpdate;
				applyRule();
			}
		};
		userSettingsSubject.addObserver(userSettingsObserver);
	}

	private void applyRule() {
		double target = lastUserSettingsUpdate.getTargetIntake();

		// if goal has already been achieved
		if (isGoalAchieved) {
			//we have fallen off our target
			if (caloriesBurned < lastUserSettingsUpdate.getTargetIntake()) {
				isGoalAchieved = false;
				soundAlerter.alert("Failure Sound");
				messageAlerter.alert("Off the target");
				return;
			}
		}

		if (caloriesBurned >= target) {
			isGoalAchieved = true;
			soundAlerter.alert("Failure Sound");
			messageAlerter.alert("Goal fails");
			return;
		}
		
		if(caloriesBurned < target){
			double targetToAchieve = 100 - (caloriesBurned/target) * 100;
			soundAlerter.alert("Motivation Sound");
			messageAlerter.alert("Onto the target");
		}
		
		
	}
}
