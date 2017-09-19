package org.joolzminer.examples.patterns.state;

public class GumballMachine {

	private State soldOutState;
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State winnerState;
	
	private int count;
	private State state;
	private String location;
	
	public GumballMachine(String location, int numGumballs) {
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
	
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
		
	public String getStateDescription() {
		return state.getClass().getSimpleName();
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
	

	public int getCount() {
		return count;
	}

	public String getLocation() {
		return location;
	}	
	
	
}
