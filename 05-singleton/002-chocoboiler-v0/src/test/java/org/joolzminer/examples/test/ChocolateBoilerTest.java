package org.joolzminer.examples.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.ChocolateBoiler;
import org.junit.Test;

public class ChocolateBoilerTest {

	@Test
	public void testChocolateBoilerIsSingleton() {

		ChocolateBoiler singleton1 = ChocolateBoiler.getInstance(); 
		ChocolateBoiler singleton2 = ChocolateBoiler.getInstance();
		
		assertThat(singleton1, is(equalTo(singleton2)));
	}	
	
	@Test
	public void testChocolateBoilerHappyPath() {
		/* Arrange */
		ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance(); 
		
		/* Act */
		chocolateBoiler.fill();
		chocolateBoiler.boil();
		chocolateBoiler.drain();
		
		/* Assert */
		assertThat(chocolateBoiler.isEmpty(), is(true));
	}	
}
