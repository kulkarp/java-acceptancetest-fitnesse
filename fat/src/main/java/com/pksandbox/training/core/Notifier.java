package com.pksandbox.training.core;

public interface Notifier<T> {
	public void notifyObservers(T update);
}
