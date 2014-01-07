package com.pksandbox.training.core;

public interface Subject<T> {
	void addObserver(Observer<T> observer);
	void removeObserver(Observer<T> observer);
}
