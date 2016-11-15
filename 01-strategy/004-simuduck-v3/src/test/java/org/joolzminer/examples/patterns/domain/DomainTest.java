package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.SqueakQuack;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DomainTest {

	@Test
	public void testMallardDuckCanSwimQuackAndFly() {
		/* Arrange */
		Duck d = new MallardDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("MallardDuck.display")));
		assertThat(d.quack(), is(equalTo("BasicQuack.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
		assertThat(d.fly(), is(equalTo("FlyWithWings.fly")));
	}
	
	@Test
	public void testRedHeadDuckCanSwimQuackAndFly() {
		/* Arrange */
		Duck d = new RedHeadDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RedHeadDuck.display")));
		assertThat(d.quack(), is(equalTo("BasicQuack.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
		assertThat(d.fly(), is(equalTo("FlyWithWings.fly")));
	}
	
	@Test
	public void testRubberDuckCanSwimAndSqueak() {
		/* Arrange */
		Duck d = new RubberDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RubberDuck.display")));
		assertThat(d.quack(), is(equalTo("SqueakQuack.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRubberDuckCantFly() {
		/* Arrange */
		Duck d = new RubberDuck();
				
		/* Act + Assert */
		d.fly();
	}
	
	@Test
	public void testdecoyDuckCanOnlySwim() {
		/* Arrange */
		Duck d = new DecoyDuck();
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("DecoyDuck.display")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testdecoyDuckCantQuack() {
		/* Arrange */
		Duck d = new DecoyDuck();
				
		/* Act + Assert */
		d.quack();

	}
	@Test(expected = UnsupportedOperationException.class)
	public void testdecoyDuckCantFly() {
		/* Arrange */
		Duck d = new DecoyDuck();
				
		/* Act + Assert */
		d.fly();
	}
	
	@Test
	public void testBehaviorCanBeSetDynamically() {
		/* Arrange */
		Duck d = new MallardDuck();
		
		/* Act */
		String prevBehavior = d.quack();
		d.setQuackBehavior(new SqueakQuack());

		/* Assert */
		assertThat(prevBehavior, is(equalTo("BasicQuack.quack")));
		assertThat(d.quack(), is(equalTo("SqueakQuack.quack")));
	}
}
