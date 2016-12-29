package org.joolzminer.examples.patterns.state;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import static org.joolzminer.examples.patterns.state.GumballMachine.State.*;

public class GumballMachineTest {

	@Test
	public void testHappyPathShouldGetUsGumball() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		assertThat(gumballMachine.getState(), is(NO_QUARTER));
		
		gumballMachine.insertQuarter();
		assertThat(gumballMachine.getState(), is(HAS_QUARTER));
		
		gumballMachine.turnCrank();
		assertThat(gumballMachine.getState(), is(NO_QUARTER));
		assertThat(gumballMachine.getCount(), is(equalTo(4)));
	}
	
	@Test
	public void testEjectBeforeTurningTheCrankShouldGiveQuarterBack() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		gumballMachine.insertQuarter();
		gumballMachine.ejectQuarter();
		assertThat(gumballMachine.getState(), is(NO_QUARTER));
		assertThat(gumballMachine.getCount(), is(equalTo(5)));
	}
	
	@Test
	public void testTurningCrankWithoutMoneyShouldNotWork() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		gumballMachine.turnCrank();
		assertThat(gumballMachine.getState(), is(NO_QUARTER));
		assertThat(gumballMachine.getCount(), is(equalTo(5)));
	}
	
	@Test
	public void testEjectingWithoutMoneyShouldNotWork() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		gumballMachine.ejectQuarter();
		assertThat(gumballMachine.getState(), is(NO_QUARTER));
		assertThat(gumballMachine.getCount(), is(equalTo(5)));
	}
	
	@Test
	public void testEjectingAfterSoldShouldNotWork() {
		GumballMachine gumballMachine = new GumballMachine(5);
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();
		assertThat(gumballMachine.getState(), is(NO_QUARTER));
		assertThat(gumballMachine.getCount(), is(equalTo(4)));
	}
}
