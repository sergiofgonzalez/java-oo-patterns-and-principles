package org.joolzminer.examples.patterns.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SuppressWarnings("serial")
public class NoQuarterState implements State {

	private static final Logger LOGGER = LoggerFactory.getLogger(NoQuarterState.class);
	
	private transient GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {		
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		LOGGER.debug("A quarter has been inserted");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Can't eject quarter: quarter has not been inserted");
	}

	@Override
	public void turnCrank() {
		System.out.println("Can't turn crank: quarter has not been inserted");
	}

	@Override
	public void dispense() {
		System.out.println("Can't dispense: quarter has not been inserted");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
