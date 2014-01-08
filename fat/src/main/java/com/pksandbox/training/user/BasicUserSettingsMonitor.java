package com.pksandbox.training.user;

import com.pksandbox.training.core.BasicObservable;

public class BasicUserSettingsMonitor extends
		BasicObservable<UserSettingsUpdate> implements UserSettingsMonitor {

	public void setInput(double weight, double targetIntake) {
		notifyObservers(new UserSettingsUpdate(weight, targetIntake));
	}
}
