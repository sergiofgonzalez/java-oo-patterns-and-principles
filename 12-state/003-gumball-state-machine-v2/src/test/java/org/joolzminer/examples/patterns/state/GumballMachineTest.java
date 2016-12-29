package org.joolzminer.examples.patterns.state;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class GumballMachineTest {

	@Test
	public void testHappyPathShouldGetUsGumball() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		assertThat(gumballMachine.getStateDescription(), is(equalTo("NoQuarterState")));
		
		gumballMachine.insertQuarter();
		assertThat(gumballMachine.getStateDescription(), is(equalTo("HasQuarterState")));
		
		gumballMachine.turnCrank();
		assertThat(gumballMachine.getStateDescription(), is(equalTo("NoQuarterState")));
		assertThat(gumballMachine.getCount(), is(equalTo(4)));
	}
	
	@Test
	public void testEjectBeforeTurningTheCrankShouldGiveQuarterBack() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		gumballMachine.insertQuarter();
		gumballMachine.ejectQuarter();
		assertThat(gumballMachine.getStateDescription(), is(equalTo("NoQuarterState")));
		assertThat(gumballMachine.getCount(), is(equalTo(5)));
	}
	
	@Test
	public void testTurningCrankWithoutMoneyShouldNotWork() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		gumballMachine.turnCrank();
		assertThat(gumballMachine.getStateDescription(), is(equalTo("NoQuarterState")));
		assertThat(gumballMachine.getCount(), is(equalTo(5)));
	}
	
	@Test
	public void testEjectingWithoutMoneyShouldNotWork() {
		GumballMachine gumballMachine = new GumballMachine(5);
		
		gumballMachine.ejectQuarter();
		assertThat(gumballMachine.getStateDescription(), is(equalTo("NoQuarterState")));
		assertThat(gumballMachine.getCount(), is(equalTo(5)));
	}
	
	@Test
	public void testEjectingAfterSoldShouldNotWork() {
		GumballMachine gumballMachine = new GumballMachine(5);
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();
		assertThat(gumballMachine.getStateDescription(), is(equalTo("NoQuarterState")));
		assertThat(gumballMachine.getCount(), is(equalTo(4)));
	}
}
