package org.joolzminer.examples.patterns.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DomainTest {

	@Test
	public void testMallardDuckCanSwimQuackAndFly() {
		/* Arrange */
		MallardDuck d = new MallardDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("MallardDuck.display")));
		assertThat(d.quack(), is(equalTo("MallardDuck.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
		assertThat(d.fly(), is(equalTo("MallardDuck.fly")));
	}
	
	@Test
	public void testRedHeadDuckCanSwimQuackAndFly() {
		/* Arrange */
		RedHeadDuck d = new RedHeadDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RedHeadDuck.display")));
		assertThat(d.quack(), is(equalTo("RedHeadDuck.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
		assertThat(d.fly(), is(equalTo("RedHeadDuck.fly")));
	}
	
	@Test
	public void testRubberDuckCanSwimAndQuack() {
		/* Arrange */
		RubberDuck d = new RubberDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RubberDuck.display")));
		assertThat(d.quack(), is(equalTo("RubberDuck.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
	
	@Test
	public void testdecoyDuckCanOnlySwim() {
		/* Arrange */
		DecoyDuck d = new DecoyDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("DecoyDuck.display")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
}
