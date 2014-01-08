package com.pksandbox.training.core;

import java.util.ArrayList;
import java.util.List;

public class BasicObservable <T> implements Subject<T>, Notifier<T>{
	private List<Observer<T>> observers = new ArrayList<Observer<T>>();

	public void notifyObservers(T update) {
		for (Observer<T> observer : observers) {
			observer.update(update);
		}
	}

	public void addObserver(Observer<T> observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer<T> observer) {
		observers.remove(observer);
	}
}
