package org.joolzminer.examples.patterns.state;

import java.rmi.RemoteException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class HasQuarterState implements State {

	private static final Logger LOGGER = LoggerFactory.getLogger(HasQuarterState.class);
	
	private Random randomWinner = new Random();
	
	private transient GumballMachine gumballMachine;
	
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
	public void turnCrank() throws RemoteException {
		LOGGER.debug("the crank has been turned: dispensing gumball");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("Can't dispense before turning the crank");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	
}
