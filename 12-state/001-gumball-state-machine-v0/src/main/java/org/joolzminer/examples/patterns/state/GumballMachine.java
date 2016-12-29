package org.joolzminer.examples.patterns.state;

import static org.joolzminer.examples.patterns.state.GumballMachine.State.*;

public class GumballMachine {
	
	public enum State { 
		SOLD_OUT,
		NO_QUARTER,
		HAS_QUARTER,
		GUMBALL_SOLD
	};
	
	
	private State state;
	private int count;
	
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	
	public void insertQuarter() {	
		if (state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter");
		} else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
		} else if (state == SOLD_OUT) {
			System.out.println("Can't accept quarter: machine is out of gumballs");
		} else if (state == GUMBALL_SOLD) {
			System.out.println("Can't accept another quarter before you take the gumball");
		}
	}
	
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			state = NO_QUARTER;
			System.out.println("Quarter returned per customer request");
		} else if (state == NO_QUARTER) {
			System.out.println("No quarter to return: you haven't inserted a quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("No quarter to return: out of gumballs");
		} else if (state == GUMBALL_SOLD) {
			System.out.println("Cannot return quarter: gumball already dispensed");
		}		
	}
	
	public void turnCrank() {
		if (state == HAS_QUARTER) {
			state = GUMBALL_SOLD;
			dispenseGumball();
		} else if (state == NO_QUARTER) {
			System.out.println("Can't turn crank before inserting quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("Can't turn crank when out of gumballs");
		} else if (state == GUMBALL_SOLD) {
			System.out.println("Can't turn crank: gumball already dispensed");
		}				
	}
	
	public void dispenseGumball() {		
		if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed: quarter has been inserted");
		} else if (state == NO_QUARTER) {
			System.out.println("No gumball dispensed: no quarter has been inserted");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed: machine is out of gumballs");
		} else if (state == GUMBALL_SOLD) {
			System.out.println("Dispensing gumball");
			count--;
			if (count == 0) {
				System.out.println("Machine is out of gumballs");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		}				
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}	
	
	
}
