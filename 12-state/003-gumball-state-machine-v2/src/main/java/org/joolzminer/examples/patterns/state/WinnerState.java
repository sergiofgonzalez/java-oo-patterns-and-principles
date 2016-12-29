package org.joolzminer.examples.patterns.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinnerState implements State {

	private static final Logger LOGGER = LoggerFactory.getLogger(WinnerState.class);
	
	private GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {		
		this.gumballMachine = gumballMachine;
	}
		
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert quarter before dispensing gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can't eject quarter after the crank has been turned");
	}

	@Override
	public void turnCrank() {
		System.out.println("You can't turn the crank twice");
	}

	@Override
	public void dispense() {
		LOGGER.debug("Releasing the gumball you paid for");
		gumballMachine.releaseGumball();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			LOGGER.debug("Dispensing another gumball for free");
			gumballMachine.releaseGumball();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("No gumballs left");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
}
