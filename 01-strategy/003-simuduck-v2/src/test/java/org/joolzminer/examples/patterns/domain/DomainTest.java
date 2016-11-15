package org.joolzminer.examples.patterns.domain;

import org.joolzminer.examples.patterns.domain.behaviors.BasicQuack;
import org.joolzminer.examples.patterns.domain.behaviors.FlyWithWings;
import org.joolzminer.examples.patterns.domain.behaviors.SqueakQuack;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DomainTest {

	@Test
	public void testMallardDuckCanSwimQuackAndFly() {
		/* Arrange */
		MallardDuck d = new MallardDuck() {{
			setFlyBehavior(new FlyWithWings());
			setQuackBehavior(new BasicQuack());
		}};
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("MallardDuck.display")));
		assertThat(d.quack(), is(equalTo("BasicQuack.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
		assertThat(d.fly(), is(equalTo("FlyWithWings.fly")));
	}
	
	@Test
	public void testRedHeadDuckCanSwimQuackAndFly() {
		/* Arrange */
		RedHeadDuck d = new RedHeadDuck() {{
			setFlyBehavior(new FlyWithWings());
			setQuackBehavior(new BasicQuack());
		}};
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RedHeadDuck.display")));
		assertThat(d.quack(), is(equalTo("BasicQuack.quack")));
		assertThat(d.swim(), is(equalTo("Duck.swim")));
		assertThat(d.fly(), is(equalTo("FlyWithWings.fly")));
	}
	
	@Test
	public void testRubberDuckCanSwimAndSqueak() {
		/* Arrange */
		RubberDuck d = new RubberDuck() {{
			setQuackBehavior(new SqueakQuack());
		}};
				
		/* Act + Assert */
		assertThat(d.display(), is(equalTo("RubberDuck.display")));
		assertThat(d.squeak(), is(equalTo("SqueakQuack.quack")));
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
