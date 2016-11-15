package org.joolzminer.examples.patterns.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DomainTest {

	@Test
	public void testMallardDuckQuackAndSwimAreInheritedFromDuck() {
		/* Arrange */
		MallardDuck d = new MallardDuck();
				
		/* Act + Assert */
		assertThat(d.quack(), is(equalTo("Duck.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
	
	@Test
	public void testMallardDuckDisplayIsOverridden() {
		/* Arrange */
		MallardDuck d = new MallardDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("MallardDuck.display")));
	}
		
	@Test
	public void testRedHeadDuckQuackAndSwimAreInheritedFromDuck() {
		/* Arrange */
		RedHeadDuck d = new RedHeadDuck();
				
		/* Act + Assert */
		assertThat(d.quack(), is(equalTo("Duck.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
	
	@Test
	public void testRedHeadDuckDisplayIsOverridden() {
		/* Arrange */
		RedHeadDuck d = new RedHeadDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RedHeadDuck.display")));
	}
	
	@Test
	public void testRubberDuckSwimIsInheritedFromDuck() {
		/* Arrange */
		RubberDuck d = new RubberDuck();
				
		/* Act + Assert */
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
	
	@Test
	public void testRubberDuckDisplayAndQuackAreOverridden() {
		/* Arrange */
		RubberDuck d = new RubberDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RubberDuck.display")));
		assertThat(d.quack(), is(equalTo("RubberDuck.quack")));
	}	
}
