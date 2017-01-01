package org.joolzminer.examples.patterns.state;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.joolzminer.examples.patterns.proxy.GumballMachineRemote;

@SuppressWarnings("serial")
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

	private State soldOutState;
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State winnerState;
	
	private int count;
	private State state;
	private String location;
	
	public GumballMachine(String location, int numGumballs) throws RemoteException{
		count = 0;
		this.location = location;
		
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		
		count = numGumballs;
		if (numGumballs > 0) {
			state = noQuarterState;
		} else {
			state = soldOutState;
		}		
	}
	
	public void insertQuarter() throws RemoteException {
		state.insertQuarter();
	}
	
	public void ejectQuarter() throws RemoteException {
		state.ejectQuarter();
	}
	
	public void turnCrank() throws RemoteException {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}

	void releaseGumball() {
		System.out.println("A gumball has been released...");
		if (count > 0) {
			--count;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}
	
	public State getWinnerState() {
		return winnerState;
	}

	@Override
	public int getCount() throws RemoteException {
		return count;
	}

	@Override
	public String getLocation() throws RemoteException {
		return location;
	}

	@Override
	public State getState() throws RemoteException {
		return state;
	}	
}
