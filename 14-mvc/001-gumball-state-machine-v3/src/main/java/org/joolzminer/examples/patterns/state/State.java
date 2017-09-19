package org.joolzminer.examples.patterns.state;

public interface State {
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void dispense();
	
}
