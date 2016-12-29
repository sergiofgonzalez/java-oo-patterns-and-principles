package org.joolzminer.examples.patterns.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HasQuarterState implements State {

	private static final Logger LOGGER = LoggerFactory.getLogger(HasQuarterState.class);
	
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine) {		
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("Can't insert another quarter: you've already inserted a quarter");
	}

	@Override
	public void ejectQuarter() {
		LOGGER.debug("previously inserted quarter has been ejected");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		LOGGER.debug("the crank has been turned: dispensing gumball");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	@Override
	public void dispense() {
		System.out.println("Can't dispense before turning the crank");
	}

}
