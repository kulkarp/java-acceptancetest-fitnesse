package com.pksandbox.training.history;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasicHistoryTracker implements HistoryTracker {
	private List<History> historicalData = new ArrayList<History>();
	
	public void addHistory(Date dateTime, String eventDescription) {
		History history = new History();
		history.setDate(dateTime);
		history.setEventDescription(eventDescription);
		
		historicalData.add(history);
	}
	
	public History[] getHistoricalData(){
		return (History[]) historicalData.toArray();
	}
}
