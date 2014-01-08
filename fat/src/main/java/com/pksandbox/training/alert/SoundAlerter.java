package com.pksandbox.training.alert;

public class SoundAlerter implements Alerter {
	private String lastSoundPlayed; 
	
	public void alert(String alert) {
		lastSoundPlayed = alert;
	}

	//In the real world scenario we might have stubbed out the 
	//interface which would have been used to play the sound 
	//and checked which sound meta data is being sent to the 
	//interface
	public String getLastSoundPlayed() {
		return lastSoundPlayed;
	}
}
