package org.joolzminer.examples.patterns.state;

import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class SoldState implements State {

	private static final Logger LOGGER = LoggerFactory.getLogger(SoldState.class);
	
	private transient GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine) {		
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
	public void dispense() throws RemoteException {
		LOGGER.debug("Dispensing gumball after successful operation of the machine");
		gumballMachine.releaseGumball();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("No gumballs left");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
