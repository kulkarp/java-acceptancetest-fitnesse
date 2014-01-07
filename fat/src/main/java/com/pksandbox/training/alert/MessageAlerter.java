package com.pksandbox.training.alert;

public class MessageAlerter implements Alerter {
	private String lastMessageDisplayed;
	
	public void Alert(String alert) {
		lastMessageDisplayed = alert;
	}

	//In the real world scenario we might have stubbed out 
	//the interface which would have received this message
	public String getLastMessageDisplayed() {
		return lastMessageDisplayed;
	}
}
