package org.joolzminer.examples.patterns.observer;

public interface Observer {
	void update(double temperature, double humidity, double pressure);
}
