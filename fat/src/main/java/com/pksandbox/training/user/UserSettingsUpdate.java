package com.pksandbox.training.user;

public class UserSettingsUpdate {
	private double weight;
	private double targetIntake;
	
	public UserSettingsUpdate(double weight, double targetIntake) {
		this.weight = weight;
		this.targetIntake = targetIntake;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getTargetIntake() {
		return targetIntake;
	}
	public void setTargetIntake(double targetIntake) {
		this.targetIntake = targetIntake;
	}
}
