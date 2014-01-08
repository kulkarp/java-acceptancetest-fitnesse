package com.pksandbox.training.history;

import java.util.Date;

public interface HistoryTracker {
	public void addHistory(Date dateTime, String history);
}
