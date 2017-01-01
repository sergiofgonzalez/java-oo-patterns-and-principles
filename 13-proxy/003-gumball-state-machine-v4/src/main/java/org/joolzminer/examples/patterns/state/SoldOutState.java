package org.joolzminer.examples.patterns.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class SoldOutState implements State {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(SoldOutState.class);
	
	@SuppressWarnings("unused")
	private transient GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {		
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert a quarter on a machine with no gumballs");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can't eject a quarter on a machine with no gumballs");
	}

	@Override
	public void turnCrank() {
		System.out.println("You can't turn the crank on a machine with no gumballs");
	}

	@Override
	public void dispense() {
		System.out.println("You can't dispense on a machine with no gumballs");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
